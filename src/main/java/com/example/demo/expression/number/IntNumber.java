package com.example.demo.expression.number;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class IntNumber implements BasicNumber {
    private Integer number;

    @Override
    public Integer getNum() {
        return number;
    }

    @Override
    public BasicNumber execute() {
        return this;
    }

    @Override
    public BasicNumber add(FloatNumber otherNumber) {
        return new FloatNumber(number + otherNumber.getNum());
    }

    @Override
    public BasicNumber add(IntNumber otherNumber) {
        return new IntNumber(number + otherNumber.getNum());
    }

    @Override
    public BasicNumber add(BasicNumber otherNumber) {
        return otherNumber.add(this);
    }

    @Override
    public BasicNumber substract(BasicNumber otherNumber) {
        return otherNumber.substract(this);
    }

    @Override
    public BasicNumber substract(FloatNumber otherNumber) {
        return new FloatNumber(otherNumber.getNum() - number);
    }

    @Override
    public BasicNumber substract(IntNumber otherNumber) {
        return new IntNumber(otherNumber.getNum() - number);
    }

    @Override
    public BasicNumber divide(FloatNumber otherNumber) {
        return new FloatNumber(number / otherNumber.getNum());
    }

    @Override
    public BasicNumber divide(IntNumber otherNumber) {
        return new FloatNumber(((float) number) / otherNumber.getNum());
    }

    @Override
    public BasicNumber divide(BasicNumber otherNumber) {
        return otherNumber.divide(this);
    }

    @Override
    public BasicNumber multiply(BasicNumber otherNumber) {
        return otherNumber.multiply(this);
    }

    @Override
    public BasicNumber multiply(FloatNumber otherNumber) {
        return otherNumber.multiply(this);
    }

    @Override
    public BasicNumber multiply(IntNumber otherNumber) {
        return new IntNumber(number * otherNumber.getNum());
    }

    @Override
    public String toString() {
        return number.toString();
    }
}
