package com.example.calculator3;

import java.util.List;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArithmeticCalculator<Number> calculator = new ArithmeticCalculator<>();
        while (true) {
            System.out.print("첫 번째 숫자를 입력하세요: ");
            Number num1 = parseNumber(sc.nextLine());

            System.out.print("두 번째 숫자를 입력하세요: ");
            Number num2 = parseNumber(sc.nextLine());

            OperatorType operation = null;
            try {
                System.out.print("사칙연산 기호를 입력하세요(+, -, *, /): ");

                String operatorInput = sc.nextLine();
                operation = OperatorType.getOperatorType(operatorInput);
            } catch (OperatorTypeException e) {
                System.out.println("에러 메세지: " + e.getMessage());
                continue;
            } catch (Exception e) {
                System.out.println("알 수 없는 오류가 발생했습니다: " + e.getMessage());
                continue;
            }

            Number result = calculator.calculate(num1, num2, operation);
            if (result == null) {
                continue;
            }

            System.out.println();

            System.out.println("결과: " + result);
            System.out.println("현재까지의 계산 과정: " + calculator.printAllResult());

            System.out.println();

            System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
            System.out.println("아무키나 눌러주시면 더 계산합니다.");
            if(sc.nextLine().equals("exit")) {
                break;
            }
        }
        System.out.print("결과 목록에서 입력 값보다 큰 값 가져오기(숫자 입력): ");
        Number n = parseNumber(sc.nextLine());
        System.out.println("결과: " + calculator.getBiggerResult(n));

        System.out.println();

        Number firstValue = calculator.getResult(0);
        System.out.println("firstValue = " + firstValue);

        Number setValue = calculator.setResult(0, 999);
        System.out.println("setFirstValue = " + setValue);

        List<Number> allResults = calculator.getAllResult();
        System.out.println("allResults = " + allResults);

        Number removedValue = calculator.removeResult();
        System.out.println("removedValue = " + removedValue);
        System.out.println("getAllResults = " + calculator.printAllResult());

        calculator.clear();
        System.out.println("clear result = " + calculator);
    }

    private static Number parseNumber(String input) {
        if(input.contains(".")) {
            return (Double) Double.parseDouble(input);
        } else {
            return (Integer) Integer.parseInt(input);
        }
    }
}
