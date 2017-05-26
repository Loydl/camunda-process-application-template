package ch.loydl.camunda.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ch.loydl.camunda.service.api.CustomerDataService;
import ch.loydl.camunda.service.api.DMSService;
import ch.loydl.camunda.service.impl.CustomerDataServiceBean;
import ch.loydl.camunda.service.impl.DMSServiceBean;

/**
 * Spring configuration for this module.
 */
@Configuration
public class ServiceConfig {

    @Bean
    public CustomerDataService customerDataService() {
        return new CustomerDataServiceBean();
    }

    @Bean
    public DMSService dmsService() {
        return new DMSServiceBean();
    }
}
