package com.example.demo.expression.operator;

import com.example.demo.expression.Expression;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class OperatorObject implements Operator {

    protected Expression left;
    protected Expression right;
}
