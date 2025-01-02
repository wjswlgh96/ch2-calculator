package com.example.calculator3;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unchecked")
public class ArithmeticCalculator<T extends BigDecimal> {
    private final List<T> result = new ArrayList<>();

    public T getResult(int index) {
        return result.get(index);
    }

    public List<T> getAllResult() {
        return result;
    }

    public List<T> getBiggerResult(T number) {
        return result.stream().filter(num -> num.compareTo(number) > 0).toList();
    }

    public T setResult(int index, T value) {
        if (result.isEmpty()) {
            result.add(value);
            return value;
        } else if (result.size() - 1 < index) {
            System.out.println("인덱스 범위를 초과했습니다.");
            return null;
        }

        return result.set(index, value);
    }

    public void clear() {
        result.clear();
    }

    public String printAllResult() {
        return result.toString();
    }

    public T removeResult() {
        return result.remove(0);
    }

    public T calculate(T x, T y, OperatorType operator) {
        BigDecimal value;
        switch (operator) {
            case PLUS: {
                value = x.add(y);
                result.add((T) value);
                return (T) value;
            }
            case MINUS: {
                value = x.subtract(y);
                result.add((T) value);
                return (T) value;
            }
            case MULTIPLY: {
                value = x.multiply(y);
                result.add((T) value);
                return (T) value;
            }
            case DIVIDE: {
                if(y.doubleValue() == 0.0 || y.intValue() == 0) {
                    System.out.println("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다.");
                    return null;
                }

                value = x.divide(y, 32, RoundingMode.HALF_UP);
                result.add((T) value);
                return (T) value;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return result.toString();
    }
}
