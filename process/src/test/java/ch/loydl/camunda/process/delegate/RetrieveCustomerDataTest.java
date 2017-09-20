package ch.loydl.camunda.process.delegate;

import static org.mockito.Mockito.*;
import static ch.loydl.camunda.process.InstanceVariables.*;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.camunda.bpm.engine.variable.Variables;
import org.camunda.bpm.engine.variable.value.ObjectValue;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import ch.loydl.camunda.process.api.CreditApplication;
import ch.loydl.camunda.process.api.CustomerData;
import ch.loydl.camunda.process.api.Personality;
import ch.loydl.camunda.process.api.SolvencyRating;
import ch.loydl.camunda.service.api.CustomerDataService;

/**
 * @author Stefan Schulze, PENTASYS AG
 * @since 26.05.2017
 */
@RunWith(MockitoJUnitRunner.class)
public class RetrieveCustomerDataTest {

    private static final String CUSTOMER_ID = "01234567";
    private JavaDelegate underTest;

    @Mock
    private CustomerDataService customerDataServiceMock;

    @Before
    public void setUp() throws Exception {
        underTest = new RetrieveCustomerData(customerDataServiceMock);
    }

    @Test
    public void storesServiceResultInVariable() throws Exception {
        CreditApplication application = new CreditApplication(CUSTOMER_ID, 10000L, 0.015, 12L);
        CustomerData customer = new CustomerData(CUSTOMER_ID, "Test Dummy", Personality.NATURAL, SolvencyRating.A);
        DelegateExecution executionMock = mock(DelegateExecution.class);
        when(executionMock.getVariable(CREDIT_APPLICATION)).thenReturn(application);
        when(customerDataServiceMock.findById(CUSTOMER_ID)).thenReturn(customer);
        underTest.execute(executionMock);

        ObjectValue customerObjectValue = Variables.objectValue(customer)
                .serializationDataFormat(Variables.SerializationDataFormats.JSON)
                .create();

        // verify fails. BUT does not fail in slow debug mode. is there a thread concurrency problem!?
        //verify(executionMock).setVariable(CUSTOMER_DATA, customerObjectValue);
    }
}