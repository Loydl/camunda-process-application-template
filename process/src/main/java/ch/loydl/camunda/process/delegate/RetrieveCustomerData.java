package ch.loydl.camunda.process.delegate;

import ch.loydl.camunda.process.InstanceVariables;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import ch.loydl.camunda.process.api.CreditApplication;
import ch.loydl.camunda.process.api.CustomerData;
import ch.loydl.camunda.service.api.CustomerDataService;
import org.camunda.bpm.engine.variable.Variables;

import static org.camunda.spin.Spin.JSON;

/**
 * @author Stefan Schulze, PENTASYS AG
 * @since 26.05.2017
 */
public class RetrieveCustomerData implements JavaDelegate {

    private final CustomerDataService service;

    public RetrieveCustomerData(CustomerDataService service) {
        this.service = service;
    }

    public void execute(DelegateExecution execution) throws Exception {
        CreditApplication application = JSON(execution.getVariable(InstanceVariables.CREDIT_APPLICATION)).mapTo(CreditApplication.class);
        CustomerData customerData = service.findById(application.getCustomerId());
        execution.setVariable(InstanceVariables.CUSTOMER_DATA,
                Variables.objectValue(customerData)
                .serializationDataFormat(Variables.SerializationDataFormats.JSON)
                .create());
    }
}
