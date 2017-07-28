package ch.loydl.camunda.process.api;

import java.io.Serializable;

/**
 * @author Stefan Schulze, PENTASYS AG
 * @since 15.02.2017
 */
public class CustomerData {

    private String customerId;
    private String fullName;
    private Personality personality;
    private SolvencyRating rating;

    public CustomerData() {
    }

    public CustomerData(String customerId, String fullName, Personality personality, SolvencyRating rating) {
        this.customerId = customerId;
        this.fullName = fullName;
        this.personality = personality;
        this.rating = rating;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Personality getPersonality() {
        return personality;
    }

    public void setPersonality(Personality personality) {
        this.personality = personality;
    }

    public SolvencyRating getRating() {
        return rating;
    }

    public void setRating(SolvencyRating rating) {
        this.rating = rating;
    }

    public String toString() {
        final StringBuilder sb = new StringBuilder("CustomerData{")
            .append("customerId='").append(customerId).append('\'')
            .append(", fullName='").append(fullName).append('\'')
            .append(", personality=").append(personality)
            .append(", rating=").append(rating)
            .append('}');
        return sb.toString();
    }
}
