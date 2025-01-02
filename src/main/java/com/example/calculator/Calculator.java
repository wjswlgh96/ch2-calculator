package com.example.calculator;

import java.util.ArrayList;
import java.util.List;

public class Calculator {
    private final List<Integer> result = new ArrayList<>();

    public Integer getResult(int index) {
        return result.get(index);
    }

    public List<Integer> getAllResult() {
        return result;
    }

    public Integer setResult(int index, int value) {
        if(result.isEmpty()) {
            result.add(value);
            return value;
        }  else if(result.size() - 1 < index) {
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

    public Integer removeResult() {
        return result.remove(0);
    }

    public Integer calculate(int x, int y, String operator) {
        switch (operator) {
            case "+": {
                result.add(x + y);
                return x + y;
            }
            case "-": {
                result.add(x - y);
                return x - y;
            }
            case "*": {
                result.add(x * y);
                return x * y;
            }
            case "/": {
                if(y == 0) {
                    System.out.println("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다.");
                    break;
                }

                result.add(x / y);
                return x / y;
            }
            default: {
                System.out.println("제대로된 부호가 입력되지 않았습니다");
                break;
            }
        }

        return null;
    }

    @Override
    public String toString() {
        return result.toString();
    }
}
