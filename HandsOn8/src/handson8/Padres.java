package handson8;

public class Padres {
    private int [] numero_r; 
    private float [] porcentaje;
    private float [] porcentajeaux;
    
    
    public Padres(int valor) {
        porcentaje=new float[valor];
	porcentajeaux=new float[valor];
	numero_r=new int[valor];
    }
    
    public void set_padre(int posicion,int numero) {
	//System.out.println("debe tener "+  unos);
	//System.out.println(posicion);
	numero_r[posicion]=numero;
    }
    
    public void set_padre(int [] a) {
	numero_r=a;
    }
    
    public void calcular_ratio() {
        int suma=0;
	float sumaaux=0;
        float aux=0;
        for(int i=0;i<numero_r.length;i++) {
            suma+=numero_r[i];
	}
        //System.out.println("el primedio es  "+suma/100);
		
	for(int i=0;i<numero_r.length;i++) {
            porcentaje[i]=(float) numero_r[i] / (float) suma;
	}
	for(int i=0;i<numero_r.length;i++) {
            //porcentaje[i]=(float) numero_r[i] / (float) suma;
            porcentajeaux[i]=1-porcentaje[i];
            sumaaux+=porcentajeaux[i];
	}
	for(int i=0;i<numero_r.length;i++) {
            //porcentaje[i]=(float) numero_r[i] / (float) suma;
            porcentaje[i]=porcentajeaux[i]/sumaaux;
            aux+=porcentaje[i];
	}
    }
    
    public int selection_Padre() {		
	float desicion=(float)(Math.random()*1);
	float aux=0;
        for(int i=0;i<porcentaje.length;i++) {
            aux+=porcentaje[i];
            if(aux>=desicion) {
                if(i==0) {	
                    return i;
		}
                else {
                    return i-1;
		}	
            }
	}
	//System.out.println("Salida x");
        return porcentaje.length-1;
    }
    
    public void show(DataSet a) {
        for (int i=0;i<porcentaje.length;i++) {
            System.out.println("numero   "+numero_r[i]);
            System.out.println("porcentaje   "+porcentaje[i]);
            System.out.println("EL valor decimal es "+a.get_data(i));
	}
    }
}
