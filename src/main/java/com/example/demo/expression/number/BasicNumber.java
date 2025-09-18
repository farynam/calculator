package com.example.demo.expression.number;

import com.example.demo.expression.Expression;


public interface BasicNumber extends Expression {
    Number getNum();


    BasicNumber add(BasicNumber otherNumber);
    BasicNumber add(FloatNumber otherNumber);
    BasicNumber add(IntNumber otherNumber);

    BasicNumber substract(BasicNumber otherNumber);
    BasicNumber substract(FloatNumber otherNumber);
    BasicNumber substract(IntNumber otherNumber);

    BasicNumber divide(BasicNumber otherNumber);
    BasicNumber divide(FloatNumber otherNumber);
    BasicNumber divide(IntNumber otherNumber);

    BasicNumber multiply(BasicNumber otherNumber);
    BasicNumber multiply(FloatNumber otherNumber);
    BasicNumber multiply(IntNumber otherNumber);
}
