package ch.loydl.camunda.process;

import ch.loydl.camunda.process.delegate.CopyVariablesOnStart;
import ch.loydl.camunda.process.delegate.GetSwimlaneGroup;
import ch.loydl.camunda.process.delegate.PublishDecision;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ch.loydl.camunda.process.delegate.DefaultResponsible;
import ch.loydl.camunda.process.delegate.RetrieveCustomerData;
import ch.loydl.camunda.process.delegate.UserResponsible;
import ch.loydl.camunda.service.api.CustomerDataService;
import ch.loydl.camunda.service.api.DMSService;

/**
 * @author Stefan Schulze, PENTASYS AG
 * @since 26.05.2017
 */
@Configuration
public class ProcessConfig {

    @Bean
    public CopyVariablesOnStart copyVariablesOnStart() {
        return new CopyVariablesOnStart();
    }

    @Bean
    public RetrieveCustomerData retrieveCustomerData(CustomerDataService service) {
        return new RetrieveCustomerData(service);
    }

    @Bean
    public PublishDecision publishDecision(DMSService service) {
        return new PublishDecision(service);
    }

    @Bean
    public DefaultResponsible defaultResponsible() {
        return new DefaultResponsible();
    }

    @Bean
    public UserResponsible userResponsible() {
        return new UserResponsible();
    }

    @Bean
    public GetSwimlaneGroup getSwimlaneGroup() {
        return new GetSwimlaneGroup();
    }
}
