package com.example.demo.expression.operator;



import com.example.demo.expression.Expression;

public interface Operator extends Expression {
    int getPriority();
}
