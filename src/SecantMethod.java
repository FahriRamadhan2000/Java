import java.util.ArrayList;
import java.lang.Math;

public class SecantMethod {

    /*
     * Initial f(x). This f(x) must be changed manually.
     */
    private double fX(double x) {
        return 4 * Math.pow(x, 3) - 15 * Math.pow(x, 2) + 17 * x - 6;
    }

    /*
     * Find new (x+1) value.
     */
    private double xNext(double xBe, double xAf) {
        return xAf - ((this.fX(xAf) * (xAf - xBe)) / (this.fX(xAf) - this.fX(xBe)));
    }

    /*
     * Find error relative value.
     */
    private double errRel(double xBe, double xAf) {
        return Math.abs(((xAf - xBe) / xAf)) * 100;
    }

    /*
     * start calculation. Assume: (x-1) = 0.02, (x) = 0.05, and epsilon = 0.0001
     */
    public void start() {
        ArrayList<Double> x = new ArrayList<Double>();
        final double epsilon = 0.000001;
        x.add(0.02);
        x.add(0.05);
        while (epsilon < this.errRel(x.get(x.size() - 2), x.get(x.size() - 1))) {
            x.add(this.xNext(x.get(x.size() - 2), x.get(x.size() - 1)));
            System.out.println("(x+" + (x.size() - 2) + ") :" + x.get(x.size() - 1));
            System.out.println("Error Relative: " + this.errRel(x.get(x.size() - 2), x.get(x.size() - 1)) + " %");
        }
    }
}
