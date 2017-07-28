package ch.loydl.camunda.process.delegate;

import ch.loydl.camunda.process.InstanceVariables;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import ch.loydl.camunda.process.api.CreditApplication;
import ch.loydl.camunda.process.api.CustomerData;
import ch.loydl.camunda.service.api.CustomerDataService;

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
        CreditApplication application = (CreditApplication) execution.getVariable(InstanceVariables.CREDIT_APPLICATION);
        CustomerData customerData = service.findById(application.getCustomerId());
        execution.setVariable(InstanceVariables.CUSTOMER_DATA, customerData);
    }
}
