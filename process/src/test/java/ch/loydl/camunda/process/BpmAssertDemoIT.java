package ch.loydl.camunda.process;

import static org.camunda.bpm.engine.test.assertions.ProcessEngineTests.*;
import static org.mockito.Mockito.*;

import java.util.HashMap;
import java.util.Map;

import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.repository.ProcessDefinition;
import org.camunda.bpm.engine.runtime.ProcessInstance;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import ch.loydl.camunda.process.api.CustomerData;
import ch.loydl.camunda.process.api.Personality;
import ch.loydl.camunda.process.api.SolvencyRating;
import ch.loydl.camunda.service.api.CustomerDataService;

/**
 * @author Stefan Schulze, PENTASYS AG
 * @since 26.05.2017
 */

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {TestConfig.class, EngineConfig.class, ProcessConfig.class})
public class BpmAssertDemoIT {

    private static final String PROCESS_KEY = "credit-application";
    private static final String EXAMPLE_ID = "01234567";

    @Autowired
    private RuntimeService runtimeService;

    @Autowired
    private CustomerDataService customerDataServiceMock;

    @Test
    public void processDeployed() throws Exception {
        ProcessDefinition definition = processDefinition(PROCESS_KEY);
        assertThat(definition.getName()).isEqualTo("Credit Application");
    }

    @Test
    public void straightThroughHappyPath() throws Exception {
        CustomerData customer = new CustomerData(EXAMPLE_ID, "Dummy Corp.", Personality.JURIDICAL, SolvencyRating.A);
        when(customerDataServiceMock.findById(EXAMPLE_ID)).thenReturn(customer);

        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey(PROCESS_KEY, startFormEntries(10000L));
        assertThat(processInstance).isEnded();
    }

    private Map<String, Object> startFormEntries(long amount) {
        Map<String, Object> variables = new HashMap<>();
        variables.put(InstanceVariables.CUSTOMER_ID, EXAMPLE_ID);
        variables.put(InstanceVariables.AMOUNT_IN_EURO, amount);
        variables.put(InstanceVariables.INTEREST_RATE, "1.5");
        variables.put(InstanceVariables.LOAN_PERIOD, 24L);
        return variables;
    }
}
