package com.example.calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.example.demo.expression.number.FloatNumber;
import com.example.demo.expression.number.IntNumber;
import com.example.demo.expression.operator.Add;
import com.example.demo.expression.operator.Divide;
import com.example.demo.expression.operator.Operator;

class SimpleOperations {

    @Test
	public void testAdd() {
        Operator expr1 = new Add(new IntNumber(3), new IntNumber(1));
        assertEquals(4, expr1.execute().getNum());

        Operator expr2 = new Add(new FloatNumber(1.5f), new IntNumber(1));
        assertEquals(2.5f, expr2.execute().getNum());

        Operator expr3 = new Add(new IntNumber(1), new FloatNumber(1.5f));
        assertEquals(2.5f, expr3.execute().getNum());

        Operator expr4 = new Add(new IntNumber(-3), new IntNumber(1));
        assertEquals(-2, expr4.execute().getNum());

        Operator expr5 = new Add(new IntNumber(-1), new FloatNumber(1.5f));
        assertEquals(0.5f, expr5.execute().getNum());

        Operator expr6 = new Add(new IntNumber(-1), new FloatNumber(-1.5f));
        assertEquals(-2.5f, expr6.execute().getNum());

        Operator expr7 = new Add(new IntNumber(1), new FloatNumber(-1.5f));
        assertEquals(-0.5f, expr7.execute().getNum());
    }

    @Test
	public void testDivide() {
        Operator expr1 = new Divide(new IntNumber(3), new IntNumber(2));
        assertEquals(1.5f, expr1.execute().getNum());

        Operator expr2 = new Divide(new FloatNumber(3f), new IntNumber(2));
        assertEquals(1.5f, expr2.execute().getNum());

        Operator expr3 = new Divide(new IntNumber(3), new FloatNumber(1.5f));
        assertEquals(2f, expr3.execute().getNum());
    }
}
