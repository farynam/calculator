package com.example.calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.tuple.Pair;
import org.junit.jupiter.api.Test;

import com.example.demo.expression.Expression;
import com.example.demo.input.ArgsParser;

public class Expressions {



    @Test
    public void testIt() {
        List<Pair<String, String>> expressions = new ArrayList<>();

        expressions.add(Pair.of("1 + 1 + 1", "3"));
        expressions.add(Pair.of("-1 - 1 - 1", "-3"));
        expressions.add(Pair.of("-1 + -1 + -1", "-3"));
        expressions.add(Pair.of("-1 * -1 * -1", "-1"));

        expressions.add(Pair.of("3 / 2 + 3 / 2 + 3 / 2", "4.5"));
        expressions.add(Pair.of("3 / 2 - 3 / 2 - 3 / 2", "-1.5"));

        expressions.add(Pair.of("3 / -2 + 1 + 1 + 1", "1.5"));
        expressions.add(Pair.of("2 + 3", "5"));
        expressions.add(Pair.of("3 * 2", "6"));
        expressions.add(Pair.of("3 * -2 + 6", "0"));
        expressions.add(Pair.of("3 * 2 + 6 - 6 / 2 + 1", "10.0"));
        expressions.add(Pair.of("3 * -2 + 6 - 6 / 2 + 1", "-2.0"));
        expressions.add(Pair.of("3 * -2 + 6 * 1 - 6 / 2 + 1", "-2.0"));


        for (Pair<String, String> expr: expressions) {
            testExpression(expr.getLeft(), expr.getRight());
        }
    }

    
    public void testExpression(String expr, String expected) {
        ArgsParser argsParser = new ArgsParser();
        Expression result = argsParser.parse(expr);
        assertEquals(expected, result.execute().toString());
    }
}
