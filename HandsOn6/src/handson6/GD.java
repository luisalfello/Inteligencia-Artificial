package handson6;


public class GD {
    private double b0;
    private double b1;
    private double aprendizaje;
    
    public GD(){
        b0 = 1;
        b1 = 1;
        aprendizaje = 0.05;
    }
    
    public void step4(double[]x,double[]y){
        HelpAritmetic arit = new HelpAritmetic();
        double temp  = 0;
        
        temp = arit.sumb0(x, y, b0, b1);
        temp = ((double)2/x.length)*temp;
        b0 = b0 - aprendizaje * temp;
        
        temp = arit.sumb1(x, y, b0, b1);
        temp = ((double)2/x.length)*temp;
        b1 = b1 - aprendizaje * temp;
        
    }
    
    public void step2(double[]x, double[] y){
        HelpAritmetic arit = new HelpAritmetic();
        double error;
        double temp;
        
        System.out.println("B0: " + b0);
        System.out.println("B1: " + b1);
        
        
        temp = arit.sum(x, y, b0, b1);
        
        error = ((double)1/40)*(temp);
        
        System.out.println("Error: " + error);
        System.out.println("------------------------");
        if(error != 0){
            step4(x,y);
        }
    }
    
    
    
    
}
