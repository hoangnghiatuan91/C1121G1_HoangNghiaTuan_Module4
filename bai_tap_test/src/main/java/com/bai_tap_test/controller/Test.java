package com.bai_tap_test.controller;

import java.util.Scanner;

public class Test {
    public static void drawHollowLozenge(int a, int b) {

        for (int i = 0; i < a - b; i++) System.out.print(" ");
        System.out.print(b + 1);
        for (int i = 0; i < 2 * b; i++) System.out.print(" ");
        System.out.print(b + 1);
        System.out.println();
    }

    public static void main(String[] args) throws java.lang.Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập độ dài bạn muốn tạo hình thoi");
        int N = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < N; i++) {
            drawHollowLozenge(N, i);
        }
        for (int i = N - 1; i >= 0; i--) {
            drawHollowLozenge(N, i);
        }
    }
}
