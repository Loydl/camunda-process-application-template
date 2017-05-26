package ch.loydl.camunda.service.impl;

import java.lang.reflect.Method;
import java.util.List;
import java.util.Random;

/**
  * Creates a common context form "random" data generation.
 */
class DataGenerator {

    private Random random;

    DataGenerator(long seed) {
        this.random = new Random(seed);
    }

    public DataGenerator(String seed) {
        this(seed.hashCode());
    }

    <T> T fromList(List<T> values) {
        int index  = random.nextInt(values.size());
        return values.get(index);
    }

    @SuppressWarnings("unchecked")
    <T extends Enum<T>> T fromEnum(Class<T> type) throws ReflectiveOperationException {
        Method m = type.getMethod("values");
        T[] values = (T[]) m.invoke(null);
        int index  = random.nextInt(values.length);
        return values[index];
    }
}
