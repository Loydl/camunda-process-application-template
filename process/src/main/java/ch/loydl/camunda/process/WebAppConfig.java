package ch.loydl.camunda.process;

import org.camunda.bpm.BpmPlatform;
import org.camunda.bpm.engine.ProcessEngine;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Web-app specific config entry-point.
 */
@Configuration
@Import({EngineConfig.class, ProcessConfig.class})
public class WebAppConfig {


    /**
     * Retrieve a shared process engine (internally via JNDI).
     *
     * @return the default process engine
     */
    @Bean(destroyMethod = "toString")
    public ProcessEngine processEngine() {
        return BpmPlatform.getDefaultProcessEngine();
    }

    /**
     * The process application itself. The bean name (i.e. "creditDecisionApplication") MUST be unique within
     * the shared process engine.
     *
     * @return a customized process application
     */
    @Bean
    public CreditDecisionApp creditDecisionApplication() {
        return new CreditDecisionApp();
    }
}
