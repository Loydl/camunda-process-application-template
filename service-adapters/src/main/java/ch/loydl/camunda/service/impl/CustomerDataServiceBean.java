package ch.loydl.camunda.service.impl;

import ch.loydl.camunda.service.api.ServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ch.loydl.camunda.process.api.CustomerData;
import ch.loydl.camunda.process.api.Personality;
import ch.loydl.camunda.process.api.SolvencyRating;
import ch.loydl.camunda.service.api.CustomerDataService;

/**
 * Dummy implementation - return consistent "random" customers, no database needed.
 */
public class CustomerDataServiceBean implements CustomerDataService {

    private static final Logger LOG = LoggerFactory.getLogger(CustomerDataServiceBean.class);

    @Override
    public CustomerData findById(String customerId) {
        DataGenerator generator = new DataGenerator(customerId);
        Personality personality = createPersonality(generator);
        String fullName = Personality.NATURAL == personality ? createNaturalName(generator) : createCompanyName(generator);
        SolvencyRating rating = createRating(generator);
        CustomerData found = new CustomerData(customerId, fullName, personality, rating);
        LOG.info("Found customer with id '{}': {}", customerId, found);
        return found;
    }

    private SolvencyRating createRating(DataGenerator generator) {
        try {
            return generator.fromEnum(SolvencyRating.class);
        } catch (ReflectiveOperationException e) {
            throw new ServiceException("Failed to determine rating", e);
        }
    }

    private Personality createPersonality(DataGenerator generator) {
        try {
            return generator.fromEnum(Personality.class);
        } catch (ReflectiveOperationException e) {
            throw new ServiceException("Failed to determine rating", e);
        }
    }

    private String createNaturalName(DataGenerator generator) {
        return generator.fromList(RawData.FIRST_NAMES) + " " + generator.fromList(RawData.LAST_NAMES);
    }

    private String createCompanyName(DataGenerator generator) {
        return generator.fromList(RawData.COMPANY_NAMES) + " " + generator.fromList(RawData.COMPANY_EXT);
    }

}
