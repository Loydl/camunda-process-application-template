package ch.loydl.camunda.service.impl;

import org.assertj.core.api.SoftAssertions;
import org.junit.Test;
import ch.loydl.camunda.process.api.Personality;
import ch.loydl.camunda.process.api.SolvencyRating;

/**
 * @author Stefan Schulze, PENTASYS AG
 * @since 15.02.2017
 */
public class DataGeneratorTest {
    private static final String ID = "87654321";

    private DataGenerator underTest = new DataGenerator(ID);

    @Test
    public void generatesValueFromList() throws Exception {
        String first = underTest.fromList(RawData.FIRST_NAMES);
        String last = underTest.fromList(RawData.LAST_NAMES);
        SoftAssertions.assertSoftly(s -> {
            s.assertThat(first).isEqualTo("Emil");
            s.assertThat(last).isEqualTo("Kaiser");
        });
    }

    @Test
    public void generatesValueFromEnum() throws Exception {
        SolvencyRating rating = underTest.fromEnum(SolvencyRating.class);
        Personality personality = underTest.fromEnum(Personality.class);
        SoftAssertions.assertSoftly(s -> {
            s.assertThat(rating).isEqualTo(SolvencyRating.A);
            s.assertThat(personality).isEqualTo(Personality.NATURAL);
        });
    }
}