package handson4;

public class HelpAritmetic {
    public int sum(double[] arreglo) {
        int suma = 0;

        for (int i = 0; i < arreglo.length; i++) {
            suma += arreglo[i];
        }
        return suma;
    }

    public int sumx2(double[] x) {
        int suma = 0;

        for (int i = 0; i < x.length; i++) {
            suma += x[i]*x[i];
        }
        return suma;
    }

    public int sumxy(double[] x, double[] y) {
        int suma = 0;

        for (int i = 0; i < x.length; i++) {
            suma += x[i] * y[i];
        }
        return suma;
    }

}
