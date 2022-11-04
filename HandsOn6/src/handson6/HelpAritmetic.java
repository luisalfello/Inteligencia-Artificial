package handson6;

/**
 *
 * @author lui_0
 */
public class HelpAritmetic {
    public double sum(double[] x, double[] y, double b0, double  b1){
        double suma = 0;
        double temp;
        
        for(int i = 0;i< x.length;i++){
            temp = b0 + b1*x[i];
            suma += (y[i] - temp)*(y[i] - temp);
        }
         
        return suma;
    }
    
    public double sumb0(double[] x, double[] y, double b0, double  b1){
        double suma = 0;
        double temp;
        
        for(int i = 0;i< x.length;i++){
            temp = b0 + b1*x[i];
            suma += (y[i] - temp);
        }
        
        return suma;
    }
    
    public double sumb1(double[] x, double[] y, double b0, double  b1){
        double suma = 0;
        double temp;
        
        for(int i = 0;i< x.length;i++){
            temp = b0 + b1*x[i];
            suma += (y[i] - temp) * x[i];
        }
        
        return suma;
    }
    
    
    
}
