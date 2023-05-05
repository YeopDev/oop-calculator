package calculator;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.regex.Pattern;

import static java.util.stream.Collectors.toList;

public class Calculator {
    private static final Pattern pattern1 = Pattern.compile("[+\\-*/]");
    private static final Pattern pattern2 = Pattern.compile("(\\d)+");

    public int calculate(String input) {
        Queue<Integer> operand = new LinkedList<>(getOperand(input));
        Queue<Operator> operator = new LinkedList<>(getOperator(input));

        int result = operator.poll().func.apply(operand.poll(), operand.poll());
        while (!operand.isEmpty() && !operator.isEmpty()) {
            result = operator.poll().func.apply(result, operand.poll());
        }

        return result;
    }

    public List<Integer> getOperand(String input) {
        return Arrays.stream(pattern1.split(input))
                .map(Integer::parseInt)
                .collect(toList());
    }

    public List<Operator> getOperator(String input) {
        return Arrays.stream(pattern2.split(input))
                .filter(op -> !op.isBlank())
                .map(Operator::stringValueOf)
                .collect(toList());
    }
}