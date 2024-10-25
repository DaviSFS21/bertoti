package entities;

public class Fraction {
    public int num, den;

    public Fraction(int num, int den) {
        this.num = num;
        this.den = den;
    }

    public Fraction() {
        this.num = 0;
        this.den = 1;
    }

    public String sum(Fraction fr1, Fraction fr2) {
        int LCM = FractionUtils.findLCM(fr1.den, fr2.den);

        int x = fr1.num * (LCM / fr1.den);
        int y = fr2.num * (LCM / fr2.den);
        int numRes = x + y;

        int GCD = FractionUtils.findGCD(numRes, LCM);

        this.num = numRes / GCD;
        this.den = LCM / GCD;

        return this.toString();
    }

    public String sub(Fraction fr1, Fraction fr2) {
        int LCM = FractionUtils.findLCM(fr1.den, fr2.den);

        int x = fr1.num * (LCM / fr1.den);
        int y = fr2.num * (LCM / fr2.den);
        int numRes = x - y;

        int GCD = FractionUtils.findGCD(numRes, LCM);

        this.num = numRes / GCD;
        this.den = LCM / GCD;

        return this.toString();
    }

    public String mult(Fraction fr1, Fraction fr2) {
        this.num = fr1.num * fr2.num;
        this.den = fr1.den * fr2.den;

        int GCD = FractionUtils.findGCD(this.num, this.den);

        this.num /= GCD;
        this.den /= GCD;

        return this.toString();
    }

    public String div(Fraction fr1, Fraction fr2) {
        this.num = fr1.num * fr2.den;
        this.den = fr1.den * fr2.num;

        int GCD = FractionUtils.findGCD(this.num, this.den);

        this.num /= GCD;
        this.den /= GCD;

        return this.toString();
    }

    @Override
    public String toString() {
        return num + "/" + den;
    }
}
