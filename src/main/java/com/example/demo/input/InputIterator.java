package com.example.demo.input;

import java.util.Optional;

import com.example.demo.expression.number.IntNumber;
import com.example.demo.expression.operator.Add;
import com.example.demo.expression.operator.Divide;
import com.example.demo.expression.operator.Multiply;
import com.example.demo.expression.operator.OperatorObject;
import com.example.demo.expression.operator.Substract;

public class InputIterator {
    
    private int index;
    private char [] charArray;

    public InputIterator(String text) {
        this.charArray = text.trim().toCharArray();
    }

    public Optional<OperatorObject> findOperator() {
        Optional<Character> signOpt = findSign();
        return signOpt.map((sign) -> convert(sign));
    }

    public IntNumber findNumber() {
        Optional<Character> signOpt = findSign();

        for (int i = index; i < charArray.length; i++) {
            char chr = charArray[i];

            if (isBlank(chr)) {//skip
                index = i + 1;
                continue;
            }

            if (Character.isDigit(chr)) {
                index = i + 1;
                return parseIntNumber(i, signOpt.isPresent());
            }
        }

        throw new RuntimeException("Number index not found");
    }

    public boolean hasNext() {
        return index < charArray.length;
    }

    private Optional<Character> findSign() {
        for (int i = index; i < charArray.length; i++) {
            char chr = charArray[i];

            if (isBlank(chr)) {//skip
                index = i + 1;
                continue;
            }

            if (isSign(chr)) {
                index = i + 1;
                return Optional.of(charArray[i]);
            }

            index = i;

            return Optional.empty();
        }

        return Optional.empty();
    }

    private IntNumber parseIntNumber(int index, boolean signed) {
        final int begin = index;

        final int signBegin = signed ? begin - 1 : begin;

        for (int i = begin + 1; i < charArray.length; i++) {
            char chr = charArray[i];
            if (!Character.isDigit(chr)) {
                index = i;
                return createNumber(signBegin, i, charArray);
            }
            index = i;
        }

        return createNumber(signBegin, index + 1, charArray);
    }

    private IntNumber createNumber(int begin, int endExcl, char[] exprChars) {
        char[] charNum = new char[endExcl - begin];

        System.arraycopy(exprChars, begin, charNum, 0, charNum.length);

        String strNum = new String(charNum);

        return new IntNumber(Integer.parseInt(strNum));
    }

    private boolean isBlank(char chr) {
        return chr == ' ';
    }

    private boolean isNumberSign(char chr) {
        return chr == '-' || chr == '+';
    }

    private boolean isSign(char chr) {
        return isNumberSign(chr) || chr == '/' || chr == '*';
    }

    private OperatorObject convert(char sign) {
        switch (sign) {
            case '+' -> {
                return new Add();
            }
            case '-' -> {
                return new Substract();
            }
            case '*' -> {
                return new Multiply();
            }
            case '/' -> {
                return new Divide();
            }
            default -> {
                throw new RuntimeException("Unsupported operation sign:" + sign);
            }
        }
    }
    
}
