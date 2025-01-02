package com.example.calculator3;

import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArithmeticCalculator<BigDecimal> calculator = new ArithmeticCalculator<>();
        while (true) {
            System.out.print("첫 번째 숫자를 입력하세요: ");
            BigDecimal num1 = sc.nextBigDecimal();
            sc.nextLine();

            System.out.print("두 번째 숫자를 입력하세요: ");
            BigDecimal num2 = sc.nextBigDecimal();
            sc.nextLine();

            if(num1.compareTo(BigDecimal.ZERO) < 0 || num2.compareTo(BigDecimal.ZERO) < 0) {
                System.out.println("음수는 입력할 수 없습니다!!");
                continue;
            }

            OperatorType operation;
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

            BigDecimal result = calculator.calculate(num1, num2, operation);
            if(result == null) {
                System.out.println("결과값을 가져올 수 없습니다. 처음으로 돌아갑니다.");
                continue;
            };

            System.out.println();

            System.out.println("결과: " + result);
            System.out.println("현재까지의 계산 과정: " + calculator.printAllResult());

            System.out.println();

            System.out.print("더 계산하시겠습니까? 아무키나 입력해주세요. (exit 입력 시 종료): ");
            if(sc.nextLine().equals("exit")) {
                break;
            }
        }
        System.out.print("결과 목록에서 입력 값보다 큰 값 가져오기(숫자 입력): ");
        BigDecimal n = sc.nextBigDecimal();
        System.out.println("결과: " + calculator.getBiggerResult(n));

        System.out.println();

        BigDecimal firstValue = calculator.getResult(0);
        System.out.println("firstValue = " + firstValue);

        BigDecimal setValue = calculator.setResult(0, BigDecimal.valueOf(999));
        System.out.println("setFirstValue = " + setValue);

        List<BigDecimal> allResults = calculator.getAllResult();
        System.out.println("allResults = " + allResults);

        BigDecimal removedValue = calculator.removeResult();
        System.out.println("removedValue = " + removedValue);
        System.out.println("getAllResults = " + calculator.printAllResult());

        calculator.clear();
        System.out.println("clear result = " + calculator);
    }
}
