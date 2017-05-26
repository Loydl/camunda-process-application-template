package ch.loydl.camunda.service.api;

import ch.loydl.camunda.process.api.CreditApplication;
import ch.loydl.camunda.process.api.CreditDecision;
import ch.loydl.camunda.process.api.CustomerData;

/**
 * @author Stefan Schulze, PENTASYS AG
 * @since 15.02.2017
 */
public interface DMSService {

    void publishDecision(CreditApplication application, CustomerData customerData, CreditDecision decision);

}
