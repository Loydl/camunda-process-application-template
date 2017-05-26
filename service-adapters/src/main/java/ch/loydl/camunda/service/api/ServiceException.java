package ch.loydl.camunda.service.api;

/**
 * @author Stefan Schulze, PENTASYS AG
 * @since 15.02.2017
 */
public class ServiceException extends RuntimeException {
    private static final long serialVersionUID = -7109462112242848773L;

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}
