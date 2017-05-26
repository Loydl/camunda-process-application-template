package ch.loydl.camunda.service.impl;

import ch.loydl.camunda.service.api.DMSService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ch.loydl.camunda.process.api.CreditApplication;
import ch.loydl.camunda.process.api.CreditDecision;
import ch.loydl.camunda.process.api.CustomerData;

/**
 * Dummy implementation, writes result to the log.
 */
public class DMSServiceBean implements DMSService {

    public static final String TEMPLATE = "\n\tCustomer '{}'({}) applied for a loan of {}.- Euro.\n" +
        "\tThe application was {} by {} on {}";

    private static final Logger LOG = LoggerFactory.getLogger(DMSServiceBean.class);

    @Override
    public void publishDecision(CreditApplication application, CustomerData customerData, CreditDecision decision) {
        LOG.info(TEMPLATE,
            customerData.getFullName(),
            customerData.getCustomerId(),
            application.getAmountInEuro(),
            decision.isAccepted() ? "accepted" : "rejected",
            decision.getResposible(),
            decision.getAcceptedDate());
    }
}
