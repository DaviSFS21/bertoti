package entities;

public class FractionUtils {
    public static int findGCD(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }

        return a;
    }

    public static int findLCM(int a, int b) {
        return (a * b) / FractionUtils.findGCD(a, b);
    }
}
