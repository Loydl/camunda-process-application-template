package ch.loydl.camunda.service.impl;

import org.assertj.core.api.SoftAssertions;
import org.junit.Test;
import ch.loydl.camunda.process.api.CustomerData;
import ch.loydl.camunda.process.api.Personality;
import ch.loydl.camunda.process.api.SolvencyRating;
import ch.loydl.camunda.service.api.CustomerDataService;

/**
 * @author Stefan Schulze, PENTASYS AG
 * @since 15.02.2017
 */
public class CustomerDataServiceBeanTest {

    private static final String COMPANY_ID = "01234567";
    private static final String PRIVATE_ID = "087654321";

    private CustomerDataService underTest = new CustomerDataServiceBean();

    @Test
    public void generatesCompanyCustomer() throws Exception {
        CustomerData result = underTest.findById(COMPANY_ID);
        SoftAssertions.assertSoftly(s -> {
            s.assertThat(result.getCustomerId()).as("Customer ID").isEqualTo(COMPANY_ID);
            s.assertThat(result.getFullName()).as("Full name").isEqualTo("Oracle AG");
            s.assertThat(result.getPersonality()).as("Personality").isEqualTo(Personality.JURIDICAL);
            s.assertThat(result.getRating()).as("Rating").isEqualTo(SolvencyRating.D);
        });
    }

    @Test
    public void generatesPrivateCustomer() throws Exception {
        CustomerData result = underTest.findById(PRIVATE_ID);
        SoftAssertions.assertSoftly(s -> {
            s.assertThat(result.getCustomerId()).as("Customer ID").isEqualTo(PRIVATE_ID);
            s.assertThat(result.getFullName()).as("Full name").isEqualTo("Clarissa Joseph");
            s.assertThat(result.getPersonality()).as("Personality").isEqualTo(Personality.NATURAL);
            s.assertThat(result.getRating()).as("Rating").isEqualTo(SolvencyRating.K);
        });
    }
}