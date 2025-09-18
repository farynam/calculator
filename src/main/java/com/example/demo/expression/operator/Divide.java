package com.example.demo.expression.operator;

import com.example.demo.expression.Expression;
import com.example.demo.expression.number.BasicNumber;


public class Divide extends OperatorObject {

    private static final int priority = 3;


    public Divide() {}

    public Divide(Expression left, Expression right) {
        super(left, right);
    }

    @Override
    public int getPriority() {
        return priority;
    }

    @Override
    public BasicNumber execute() {
        final BasicNumber resultLeft = left.execute();
        final BasicNumber resultRight = right.execute();

        return resultRight.divide(resultLeft);
    }

}
