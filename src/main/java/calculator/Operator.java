package calculator;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum Operator {
    PLUS("+", (a, b) -> a + b),
    MINUS("-", (a, b) -> a - b),
    MULTIPLY("*", (a, b) -> a * b),
    DIVIDE("/", (a, b) -> a / b);

    final String value;
    final BiFunction<Integer, Integer, Integer> func;

    Operator(String value, BiFunction<Integer, Integer, Integer> func) {
        this.value = value;
        this.func = func;
    }

    public static Operator stringValueOf(String value) {
        return Arrays.stream(values())
                .filter(op -> op.value.equals(value))
                .findFirst()
                .orElseThrow();
    }
}
