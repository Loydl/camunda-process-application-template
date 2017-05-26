package ch.loydl.camunda.application;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import ch.loydl.camunda.process.WebAppConfig;
import ch.loydl.camunda.service.ServiceConfig;

@Configuration
@Import({ServiceConfig.class, WebAppConfig.class})
public class ApplicationConfig {}
