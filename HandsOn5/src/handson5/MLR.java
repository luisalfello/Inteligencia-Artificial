package handson5;

import java.util.Arrays;

public class MLR {
    double B[] = new double [3];
    private double [][]X = new double [3][3];
    private double []XY = new double [3];
    
    public MLR(){
        B[0] = 0;
        B[1] = 0;
        B[2] = 0;
        
        
    }
    
    public double [][] cal_X(double[] x1,double[] x2,double[]y){
        HelpAritmetic arit = new HelpAritmetic();
        
        double suma_x1;
        double suma_x2;
        double suma_x12;
        double suma_x22;
        double suma_x1x2;
        
        suma_x1 = arit.sum(x1);
        suma_x2 = arit.sum(x2);
        suma_x12 = arit.sumX2(x1);
        suma_x22 = arit.sumX2(x2);
        suma_x1x2 = arit.sumxy(x1, x2);
        
        X[0][0] = x1.length;
        X[0][1] = suma_x1;
        X[0][2] = suma_x2;
        X[1][0] = suma_x1;
        X[1][1] = suma_x12;
        X[1][2] = suma_x1x2;
        X[2][0] = suma_x2;
        X[2][1] = suma_x1x2;
        X[2][2] = suma_x22;
        /*
        X[0][0] = 17;
        X[0][1] = 941;
        X[0][2] = 525.3;
        X[1][0] = 941;
        X[1][1] = 54270;
        X[1][2] = 29286;
        X[2][0] = 525.3;
        X[2][1] = 29286;
        X[2][2] = 16254;
        */
        
        X = arit.inversa(X);
        
        return X;
    }
    
    public double[] calXY(double[] x1,double[] x2,double[]y){
        HelpAritmetic arit = new HelpAritmetic(); 
        
        double suma_yx1;
        double suma_yx2;
        double suma_y;
        
        suma_y = arit.sum(y);
        suma_yx1 = arit.sumxy(x1,y);
        suma_yx2 = arit.sumxy(x2,y);
        
        XY[0] = suma_y;
        XY[1] = suma_yx1;
        XY[2] = suma_yx2;
        
        /*
        XY[0] = 4902.8;
        XY[1] = 276610;
        XY[2] = 152020;
        */
        return XY;
    }
    
    public void cal_B(){
        int n = 0;
        for(int j=0;j<XY.length;j++){
            for(int k=0;k<XY.length;k++){
                B[j] += X[j][k] * XY[k];
            }            
        }
        /*for(int j=0;j<3;j++){
            System.out.println("Elemento B: " + B[j]);
        }*/
    }
    
    public void simular(double x1, double x2){
        System.out.println("b0 = " +  B[0]);
        System.out.println("b1 = " +  B[1]);
        System.out.println("b1 = " +  B[2]);
        System.out.println("x1 = " +  x1 + " x2 = " + x2);
        double y = B[0] + B[1] * x1 + B[2] * x2;
        System.out.println("y = " + y);
    }
    
    
    
    
    
    
    
}
