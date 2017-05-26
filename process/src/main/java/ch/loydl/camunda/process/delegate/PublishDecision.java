package ch.loydl.camunda.process.delegate;

import static ch.loydl.camunda.process.InstanceVariables.*;

import java.util.Date;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import ch.loydl.camunda.process.api.CreditApplication;
import ch.loydl.camunda.process.api.CreditDecision;
import ch.loydl.camunda.process.api.CustomerData;
import ch.loydl.camunda.service.api.DMSService;

/**
 * @author Stefan Schulze, PENTASYS AG
 * @since 26.05.2017
 */
public class PublishDecision implements JavaDelegate {

    private final DMSService dmsService;

    public PublishDecision(DMSService dmsService) {
        this.dmsService = dmsService;
    }

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        String decision = (String) execution.getVariable(DECISION);
        String responsible = (String) execution.getVariable(RESPONSIBLE);
        CreditApplication application = (CreditApplication) execution.getVariable(CREDIT_APPLICATION);
        CustomerData customer = (CustomerData) execution.getVariable(CUSTOMER_DATA);
        boolean accepted = "ACCEPT".equals(decision);

        CreditDecision creditDecision = new CreditDecision(responsible, accepted, new Date());
        dmsService.publishDecision(application, customer, creditDecision);
    }
}
