package com.example.calculator3;

import java.util.Arrays;

public enum OperatorType {
    PLUS("+"), MINUS("-"), MULTIPLY("*"), DIVIDE("/");

    private final String symbol;

    OperatorType(String symbol) {
        this.symbol = symbol;
    }

    public static OperatorType getOperatorType(String symbol) {
        for (OperatorType operatorType : OperatorType.values()) {
            if(operatorType.symbol.equals(symbol)) {
                return operatorType;
            }
        }
        throw new OperatorTypeException("OperationType ENUM 에 존재하지 않는 값입니다: [ +, -, *, / ] 중 하나를 입력해주세요.");
    }
}