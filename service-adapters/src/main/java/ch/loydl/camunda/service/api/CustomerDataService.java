package ch.loydl.camunda.service.api;


import ch.loydl.camunda.process.api.CustomerData;

/**
 *
 */
public interface CustomerDataService {

    CustomerData findById(String customerId);

}
