package com.example.demo.expression.operator;

import com.example.demo.expression.number.BasicNumber;

public class Multiply extends OperatorObject {

    private static final int priority = 3;

    @Override
    public int getPriority() {
        return priority;
    }

    @Override
    public BasicNumber execute() {
        final BasicNumber resultLeft = left.execute();
        final BasicNumber resultRight = right.execute();

        return resultRight.multiply(resultLeft);
    }
}
