package ch.loydl.camunda.process.api;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Stefan Schulze, PENTASYS AG
 * @since 15.02.2017
 */
public class CreditDecision implements Serializable {

    static final String serialVersionUID = "CiKeBpn3VC4eNhC9jVv2";

    private final String resposible;
    private final boolean accepted;
    private final Date acceptedDate;

    public CreditDecision(String resposible, boolean accepted, Date acceptedDate) {

        this.resposible = resposible;
        this.accepted = accepted;
        this.acceptedDate = acceptedDate;
    }

    public String getResposible() {
        return resposible;
    }

    public boolean isAccepted() {
        return accepted;
    }

    public Date getAcceptedDate() {
        return acceptedDate;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CreditDecision{")
            .append("resposible='").append(resposible).append('\'')
            .append(", accepted=").append(accepted)
            .append(", acceptedDate=").append(acceptedDate)
            .append('}');
        return sb.toString();
    }
}
