import java.util.ArrayList;
import java.lang.Math;

public class NewtonRaphson {

    /*
     * Initial f(x). This f(x) must be changed manually.
     */
    private double fX(double x) {
        return 1 * Math.pow(x, 3) - 2 * Math.pow(x, 2) + 3 * x - 6;
    }

    /*
     * Initial f(x) accent. This f(x) accent must be changed manually.
     */
    private double fXAccent(double x) {
        return 3 * Math.pow(x, 2) - 4 * x + 3;
    }

    /*
     * Find new (x+1) value.
     */
    private double xNext(double xBe) {
        return xBe - (fX(xBe) / fXAccent(xBe));
    }

    /*
     * Find error relative value.
     */
    private double errRel(double xBe, double xAf) {
        return Math.abs(((xAf - xBe) / xAf)) * 100;
    }

    /*
     * start calculation. Assume: (x) = 0.05, and epsilon = 0.0001
     */
    public void start() {
        ArrayList<Double> x = new ArrayList<Double>();
        final double epsilon = 0.000001;
        x.add(0.05);
        do {
            x.add(this.xNext(x.get(x.size() - 1)));
            System.out.println("(x+" + x.size() + ") :" + x.get(x.size() - 1));
            System.out.println("Error Relative: " + this.errRel(x.get(x.size() - 2), x.get(x.size() - 1)) + " %");
        } while (epsilon < this.errRel(x.get(x.size() - 2), x.get(x.size() - 1)));
    }
}
