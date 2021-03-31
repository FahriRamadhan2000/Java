import java.lang.Math;

public class FalsePosition {

    /*
     * Initial f(x). This f(x) must be changed manually.
     */
    private double fX(double x) {
        return Math.pow(x, 3) + Math.pow(x, 2) - 3 * x - 3;
    }

    /*
     * Find new w value.
     */
    private double w(double a, double b) {
        return ((fX(a) / (fX(a) - fX(b))));
    }

    /*
     * Find new c value.
     */
    private double c(double a, double b) {
        return a + w(a, b) * (b - a);
    }

    /*
     * Check number variable positive or negative.
     */
    private boolean isPositive(double x) {
        return (x < 0) ? false : true;
    }

    /*
     * Find error relative value.
     */
    private double errRel(double b, double c) {
        return Math.abs(((c - b) / c)) * 100;
    }

    /*
     * start calculation.
     */
    public void start() {
        double a = 1;
        double b = 2;
        double c = 0;
        int iteration = 1;
        while (true) {
            double fa = this.fX(a);
            double fb = this.fX(b);
            if (c == this.c(a, b)) {
                break;
            }
            c = this.c(a, b);
            double fc = this.fX(c);
            double errRel = this.errRel(b, c);
            if (errRel == 0) {
                break;
            }
            System.out.println("Iterasi ke-" + iteration);
            System.out.println("a = " + a);
            System.out.println("b = " + b);
            System.out.println("c = " + c);
            System.out.println("fa = " + fa);
            System.out.println("fb = " + fb);
            System.out.println("fc = " + fc);
            System.out.println("errRel = " + errRel + "%");
            System.out.println("_____________________________________");
            if (this.isPositive(fc) == this.isPositive(fa)) {
                a = c;
            }
            iteration++;
        }
    }
}
