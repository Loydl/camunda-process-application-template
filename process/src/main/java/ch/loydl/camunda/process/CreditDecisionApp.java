package ch.loydl.camunda.process;

import org.camunda.bpm.application.PostDeploy;
import org.camunda.bpm.application.ProcessApplication;
import org.camunda.bpm.application.ProcessApplicationInfo;
import org.camunda.bpm.engine.spring.application.SpringServletProcessApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Single entry point for a customizable process application.
 */
@ProcessApplication
public class CreditDecisionApp extends SpringServletProcessApplication {

    private static final Logger LOG = LoggerFactory.getLogger(CreditDecisionApp.class);

    @PostDeploy
    public void initProcessApplication(ProcessApplicationInfo info) {
        LOG.info("Starting process application '{}'", info.getName());
    }

}
