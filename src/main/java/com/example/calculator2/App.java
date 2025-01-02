package com.example.calculator2;

import java.util.List;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Calculator calculator = new Calculator();
        while (true) {
            System.out.print("첫 번째 숫자를 입력하세요: ");
            int num1 = sc.nextInt();
            sc.nextLine();

            System.out.print("두 번째 숫자를 입력하세요: ");
            int num2 = sc.nextInt();
            sc.nextLine();

            if(num1 < 0 || num2 < 0) {
                System.out.println("양의 정수만 입력이 가능합니다!!");
                continue;
            }

            System.out.print("사칙연산 기호를 입력하세요: ");
            String operator = sc.nextLine();

            Integer result = calculator.calculate(num1, num2, operator);
            if(result == null) continue;

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

        Integer firstValue = calculator.getResult(0);
        System.out.println("firstValue = " + firstValue);

        Integer setValue = calculator.setResult(0, 999);
        System.out.println("setFirstValue = " + setValue);

        List<Integer> allResults = calculator.getAllResult();
        System.out.println("allResults = " + allResults);

        Integer removedValue = calculator.removeResult();
        System.out.println("removedValue = " + removedValue);
        System.out.println("getAllResults = " + calculator.printAllResult());

        calculator.clear();
        System.out.println("clear result = " + calculator);
    }
}
