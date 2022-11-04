package handson4;

public class SLR {
    private double b0;
    private double b1;

    public SLR() {
        b1 = 0;
        b0 = 0;
    }

    public double cal_B0(double[] x, double[] y) {
        HelpAritmetic arit = new HelpAritmetic();
        double suma_y;
        double suma_x;
        suma_x = arit.sum(x);
        suma_y = arit.sum(y);
        b0 = (suma_y - b1 * suma_x) / x.length;
        return b0;
    }

    public double cal_B1(double[] x, double[] y) {
        HelpAritmetic arit = new HelpAritmetic();
        double suma_y;
        double suma_x;
        double suma_x2;
        double suma_xy;
        suma_x = arit.sum(x);
        suma_y = arit.sum(y);
        suma_x2 = arit.sumx2(x);
        suma_xy = arit.sumxy(x,y);
        b1=(suma_x*suma_y-x.length*suma_xy)/((suma_x*suma_x)-x.length*suma_x2);
        return b0;
    }
    
    public void predict(double n){
        HelpAritmetic arit = new HelpAritmetic();
        System.out.println("b0 = " +  b0);
        System.out.println("b1 = " +  b1);
        System.out.println("x = " +  n);
        double y = b0 + b1*n;
        System.out.println("y = " + y);
    }
}