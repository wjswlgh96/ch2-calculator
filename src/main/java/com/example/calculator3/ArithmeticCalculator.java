package com.example.calculator3;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unchecked")
public class ArithmeticCalculator<T extends Number> {
    private final List<T> result = new ArrayList<>();

    public T getResult(int index) {
        return result.get(index);
    }

    public List<T> getAllResult() {
        return result;
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
        Number number = 0;
        switch (operator) {
            case PLUS: {
                if (x instanceof Double || y instanceof Double) {
                    number = x.doubleValue() + y.doubleValue();
                } else {
                    number = x.intValue() + y.intValue();
                }
                this.result.add((T) number);
                return (T) number;
            }
            case MINUS: {
                if (x instanceof Double || y instanceof Double) {
                    number = x.doubleValue() - y.doubleValue();
                } else {
                    number = x.intValue() - y.intValue();
                }
                this.result.add((T) number);
                return (T) number;
            }
            case MULTIPLY: {
                if (x instanceof Double || y instanceof Double) {
                    number = x.doubleValue() * y.doubleValue();
                } else {
                    number = x.intValue() * y.intValue();
                }
                this.result.add((T) number);
                return (T) number;
            }
            case DIVIDE: {
                if (x instanceof Double || y instanceof Double) {
                    number = x.doubleValue() / y.doubleValue();
                } else {
                    number = x.intValue() / y.intValue();
                }
                this.result.add((T) number);
                return (T) number;
            }
        }

        return null;
    }

    @Override
    public String toString() {
        return result.toString();
    }
}
