package com.example.calculator;

import java.util.Scanner;
public class App {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

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

            int result = 0;
            switch (operator.charAt(0)) {
                case '+' : {
                    result = num1 + num2;
                    break;
                }
                case '-': {
                    result = num1 - num2;
                    break;
                }
                case '*': {
                    result = num1 * num2;
                    break;
                }
                case '/': {
                    if (num2 == 0) {
                        System.out.println("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다.");
                        continue;
                    }

                    result = num1 / num2;
                    break;
                }
                default: {
                    System.out.println("잘못된 기호를 입력하셨습니다. 처음으로 돌아갑니다.");
                    continue;
                }
            }

            System.out.println("결과: " + result);
            System.out.print("더 계산하시겠습니까? 아무키나 입력해주세요. (exit 입력 시 종료): ");

            if(sc.nextLine().equals("exit")) {
                break;
            };
        }
    }
}
