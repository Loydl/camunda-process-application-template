package ch.loydl.camunda.service;

import ch.loydl.camunda.service.api.CustomerDataService;
import ch.loydl.camunda.service.api.DMSService;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

/**
 * Checks local Spring configuration.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ServiceConfig.class)
@TestExecutionListeners(listeners = DependencyInjectionTestExecutionListener.class, inheritListeners = false)
public class ServiceConfigIT {

    @Autowired
    private DMSService dmsService;

    @Autowired
    private CustomerDataService customerDataService;

    @Test
    public void dmsServiceAvailable() throws Exception {
        Assertions.assertThat(dmsService).isNotNull();
    }

    @Test
    public void customerDataServiceAvailable() throws Exception {
        Assertions.assertThat(customerDataService).isNotNull();
    }
}