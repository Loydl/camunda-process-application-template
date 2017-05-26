package ch.loydl.camunda.process;

import static org.assertj.core.api.Assertions.*;
import static ch.loydl.camunda.process.InstanceVariables.*;

import java.io.InputStream;
import java.util.Arrays;

import org.camunda.bpm.dmn.engine.DmnDecision;
import org.camunda.bpm.dmn.engine.DmnDecisionResult;
import org.camunda.bpm.dmn.engine.DmnEngine;
import org.camunda.bpm.dmn.engine.test.DmnEngineRule;
import org.camunda.bpm.engine.variable.VariableMap;
import org.camunda.bpm.engine.variable.Variables;
import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ch.loydl.camunda.process.api.CreditApplication;
import ch.loydl.camunda.process.api.CustomerData;
import ch.loydl.camunda.process.api.Personality;
import ch.loydl.camunda.process.api.SolvencyRating;

/**
 * @author Stefan Schulze, PENTASYS AG
 * @since 26.05.2017
 */
@RunWith(Parameterized.class)
public class CheckRiskRulesIT {

    @ClassRule
    public static DmnEngineRule dmnEngineRule = new DmnEngineRule();

    private static DmnEngine dmnEngine;

    private static DmnDecision underTest;

    private final String expected;

    private VariableMap fixture;

    @Parameterized.Parameters(name = "Amount {0}, Rating {1} ==> {2}")
    public static Iterable<Object[]> testCases() {
        return Arrays.asList(new Object[][] {
            { 10000L, SolvencyRating.E, "ACCEPT"},
            { 1000L, SolvencyRating.H, "ESCALATE"},
            { 1000L, SolvencyRating.I, "REJECT"},
            { 100000L, SolvencyRating.C, "ACCEPT"},
            { 10001L, SolvencyRating.F, "ESCALATE"},
            { 10001L, SolvencyRating.G, "REJECT"},
            { 100001L, SolvencyRating.A, "ESCALATE"},
        });
    }

    @BeforeClass
    public static void deployModel() throws Exception {
        dmnEngine = dmnEngineRule.getDmnEngine();
        InputStream dmnResource = CheckRiskRulesIT.class.getResourceAsStream("/processes/check-risk.dmn");
        underTest = dmnEngine.parseDecision("checkRisk", dmnResource);
    }

    public CheckRiskRulesIT(long amount, SolvencyRating rating, String expected) {
        CreditApplication application = new CreditApplication("01234567", amount, 0.018, 12L);
        CustomerData customerData = new CustomerData("01234567", "Test Dummy", Personality.NATURAL, rating);
        this.expected = expected;

        fixture = Variables.createVariables();
        fixture.put(CREDIT_APPLICATION, application);
        fixture.put(CUSTOMER_DATA, customerData);
    }

    @Test
    public void checkRating() throws Exception {
        DmnDecisionResult result = dmnEngine.evaluateDecision(underTest, fixture);
        assertThat(result.getSingleResult().get("DECISION")).isEqualTo(expected);
    }
}
