package handson5;

public class HelpAritmetic {
    public double sum(double[] arreglo){
        double suma = 0;
        
        for(int i = 0;i < arreglo.length;i++){
            suma += arreglo[i];
        }
        return suma;
    }
    
    public double sumX2(double[] x){
        double suma = 0;
        
        for (int i = 0; i < x.length; i++) {
            suma += x[i]*x[i];
        }
        return suma;
    }
    
    public double sumxy(double[] val1, double[] val2) {
        double suma = 0;
        
        for (int i = 0; i < val1.length; i++) {
            //System.out.println(suma);
            suma += val1[i] * val2[i]; 
        }
       
        return suma;
    }
    
    public double [][]inversa(double[][]B){
        double [][]C=new double [3][3];
        double determinante,x00,x01,x02,x10,x11,x12,x20,x21,x22;
        
        determinante=(B[0][0]*((B[1][1]*B[2][2])-(B[1][2]*B[2][1])))-(B[0][1]*((B[1][0]*B[2][2])-(B[2][0]*B[1][2])))+(B[0][2]*((B[1][0]*B[2][1])-(B[2][0]*B[1][1])));
        if(determinante!=0){
            x00=((B[1][1]* B[2][2] - B[2][1]* B[1][2]))/determinante;
            x01=(-(B[1][0]* B[2][2] - B[2][0]* B[1][2]))/determinante;
            x02=((B[1][0]* B[2][1] - B[2][0]* B[1][1]))/determinante;
            x10=(-(B[0][1]* B[2][2] - B[2][1]* B[0][2]))/determinante;
            x11=((B[0][0]* B[2][2] - B[2][0]* B[0][2]))/determinante;
            x12=(-(B[0][0]* B[2][1] - B[2][0]* B[0][1]))/determinante;
            x20=((B[0][1]* B[1][2] - B[1][1]* B[0][2]))/determinante;
            x21=(-(B[0][0]* B[1][2] - B[1][0]* B[0][2]))/determinante;
            x22=((B[0][0]* B[1][1] - B[1][0]* B[0][1] ))/determinante;
            // Hacemos el intercambio de que las filas pasen como columnas
            C[0][0]=x00;
            C[0][1]=x10;
            C[0][2]=x20;
            C[1][0]=x01;
            C[1][1]=x11;
            C[1][2]=x21;
            C[2][0]=x02;
            C[2][1]=x12;
            C[2][2]=x22;
            // Mostramos la matriz inversa
            /*for(int i=0;i<3;i++){
                for(int j=0;j<3;j++){
                    System.out.print("|"+ C[i][j] +"|");
                }
                System.out.println();
            } */
        }
        else{
            System.out.print("Erros la matriz no tiene inversa");
        }
        
        
        return C;
    }
    
    
}
