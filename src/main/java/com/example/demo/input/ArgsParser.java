package com.example.demo.input;

import java.util.Optional;

import com.example.demo.expression.Expression;
import com.example.demo.expression.number.IntNumber;
import com.example.demo.expression.operator.OperatorObject;

public class ArgsParser {

    InputIterator inputIterator;

    // 3 * -2 + 6
    public Expression parse(String input) {
        inputIterator = new InputIterator(input);

        final Expression left = inputIterator.findNumber();

        Optional<OperatorObject> operatorOpt = inputIterator.findOperator();

        if (!operatorOpt.isPresent()) {
            return left;
        }

        OperatorObject operator = operatorOpt.get();
        operator.setLeft(left);

        if (!inputIterator.hasNext()) {
            throw new RuntimeException("expression not complete");
        }

        return expand(operator, operator);
    }

    private Expression expand(OperatorObject prev, OperatorObject root) {
        IntNumber num = inputIterator.findNumber();
        Optional<OperatorObject> operatorOpt = inputIterator.findOperator();

        if (!operatorOpt.isPresent()) {
            prev.setRight(num);
            return root;
        }

        OperatorObject operator = operatorOpt.get();

        if (operator.getPriority() == prev.getPriority()) {
            prev.setRight(num);
            operator.setLeft(prev);
            return expand(operator, operator);
        }

        // 2 + 3 * 1 * 2
        if (operator.getPriority() > prev.getPriority()) {
            operator.setLeft(num);
            prev.setRight(operator);
            return expand(operator, prev);
        }

        // 2 * 3 + 1
        prev.setRight(num);
        operator.setLeft(root);

        return expand(operator, operator);
    }
}
