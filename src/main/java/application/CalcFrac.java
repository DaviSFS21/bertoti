package application;

import entities.Fraction;

import java.util.Scanner;

public class CalcFrac {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        boolean rpt = true;

        while (rpt) {
            System.out.println("Type the numerator of the first fraction: ");
            int num1 = sc.nextInt();
            System.out.println("Type the denominator of the first fraction: ");
            int den1 = sc.nextInt();
            while (true) {
                if (den1 == 0) {
                    System.out.println("The denominator can't be zero: ");
                    den1 = sc.nextInt();
                } else {
                    break;
                }
            }

            System.out.println("Type the numerator of the second fraction: ");
            int num2 = sc.nextInt();
            System.out.println("Type the denominator of the second fraction: ");
            int den2 = sc.nextInt();
            while (true) {
                if (den2 == 0) {
                    System.out.println("The denominator can't be zero: ");
                    den2 = sc.nextInt();
                } else {
                    break;
                }
            }

            Fraction fr1 = new Fraction(num1,den1);
            Fraction fr2 = new Fraction(num2,den2);

            Fraction result = new Fraction();

            System.out.println("Realize an operation:");
            System.out.println("1. Sum");
            System.out.println("2. Subtract");
            System.out.println("3. Multiply");
            System.out.println("4. Divide");
            System.out.println("0. Exit");
            int op = sc.nextInt();

            switch (op) {
                case 1:
                    System.out.println("Result: " + result.sum(fr1,fr2));
                    break;
                case 2:
                    System.out.println("Result: " + result.sub(fr1,fr2));
                    break;
                case 3:
                    System.out.println("Result: " + result.mult(fr1,fr2));
                    break;
                case 4:
                    System.out.println("Result: " + result.div(fr1,fr2));
                    break;
                case 0:
                    System.out.println("Ending execution...");
                    rpt = false;
                    break;
                default:
                    System.out.println("Invalid option...");
                    break;
            }
        }


        sc.close();
    }
}
