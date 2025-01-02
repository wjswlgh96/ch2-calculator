package com.example.calculator3;

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

        throw new OperatorTypeException("존재하지 않는 기호입니다: " + symbol);
    }
}
