package com.example.calculator;

import java.util.Scanner;

public class Calculator {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print("첫 번째 숫자를 입력하세요: ");
            int x = sc.nextInt();
            sc.nextLine();

            System.out.print("두 번째 숫자를 입력하세요: ");
            int y = sc.nextInt();
            sc.nextLine();

            System.out.print("사칙연산 기호를 입력하세요: ");
            String operator = sc.nextLine();

            int result = 0;
            switch (operator.charAt(0)) {
                case '+' : {
                    result = x + y;
                    break;
                }
                case '-': {
                    result = x - y;
                    break;
                }
                case '*': {
                    result = x * y;
                    break;
                }
                case '/': {
                    if (y == 0) {
                        System.out.println("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다.");
                        continue;
                    }

                    result = x / y;
                    break;
                }
                default: {
                    System.out.println("잘못된 기호를 입력하셨습니다. 처음으로 돌아갑니다.");
                    break;
                }
            }

            System.out.println("결과: " + result);

            System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
            System.out.println("아무키나 눌러주시면 더 계산합니다.");
            if(sc.nextLine().equals("exit")) {
                break;
            };
        }
    }
}
