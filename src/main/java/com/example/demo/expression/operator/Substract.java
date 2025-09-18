package com.example.demo.expression.operator;

import com.example.demo.expression.Expression;
import com.example.demo.expression.number.BasicNumber;

public class Substract extends OperatorObject {
    
    private static final int priority = 2;

    public Substract() {}

    public Substract(Expression left, Expression right) {
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
        
        return resultLeft.substract(resultRight);
    }
}
