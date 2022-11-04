package handson8;

public class Genetic {
    private int pSize;
    private float crossoverRate;
    private float mutRate;
    private int solucion;
    

    public Genetic(int s, float c, float m) {
        this.pSize = s;
        this.crossoverRate = c;
        this.mutRate = m;
        this.solucion = 0;
    }
    
    public void set_solucion(int a) {
        solucion=a;
    }
    
    public int evaluatePopulation(String[] crom) {
        int respuesta;
        char []aux;
        for(int i=0;i<pSize;i++) {
            aux = crom[i].toCharArray();
            respuesta=(Character.getNumericValue(aux[0]) + (2*Character.getNumericValue(aux[1])) - (3*Character.getNumericValue(aux[2])) + Character.getNumericValue(aux[3]) + (4*Character.getNumericValue(aux[4])) + Character.getNumericValue(aux[5]));
            if(respuesta==solucion) {
                System.out.println("La solucion es  "+respuesta+" que se encuntra en "+i);
                return 1;
            }
        }
        return 0;
    }
    
    public void selectPadres(DataSet a,Padres p) {
        String[] generation=a.get_data();
        int [] gen=new int[pSize];
        int aux=0;
        for (int i=0;i<generation.length;i++) {
            aux=Integer.parseInt(generation[i]);
             p.set_padre(i, aux);
            aux=0;	
        }
        p.calcular_ratio();
    }
    
    public void crossover(DataSet a,Padres p) {
	String[] generation=a.get_data();
	String[] newGeneration= new String [pSize];
	String secondParent="";
	String aux="";
        for(int i=0;i<generation.length;i++) {
            if(crossoverRate>(float)(Math.random()*1)) {//El if selecciona al primer padre
                //System.out.println("EL resulado es "+generation[1]);
                secondParent= generation[p.selection_Padre()];//llamamos la funcion para seleccionar un segundo padre
		aux=crossover2(generation[i],secondParent);//iniciamos el cruzamiento
                newGeneration[i]=aux;
            }
            else {
                newGeneration[i]=generation[i];
            }
	}
        a.set_data(newGeneration);	
    }
    
    public String crossover2(String a, String b) {
	String des1="";
	String des2="";
	char[] cad;
	char[] cad2;
	char[] cad3=new char[6];
	char[] cad4=new char[6];
	int intAletorio=(int)(Math.random()*4+2);//De manera aleatoria seleccionamos donde se hara el cruzamiento
	int aux,aux2;
	cad  = a.toCharArray();//convertmos el primer padre a cadena de caracteres
	cad2 =b.toCharArray();//convertmos el segundo padre a cadena de caracteres
	for(int i=0;i<a.length();i++) {
       	    if(i<intAletorio) {
                cad3[i]=cad[i];
            }
            else {
                cad3[i]=cad2[i];
            }
            if(i>=intAletorio) {
                cad4[i]=cad[i];
            }		
	}
	for (int i=0;i<intAletorio;i++) {
            cad4[i]=cad2[i];
	}
		
	des1=String.valueOf(cad3);
	des2=String.valueOf(cad4);
        aux=Integer.parseInt(des1)-solucion;
	aux2=Integer.parseInt(des2)-solucion;
	if(aux<0) {
	    aux=aux*-1;
	}
        if(aux2<0) {
	    aux2=aux2*-1;
	}		
	if(aux<aux2) {
	    return des1;
	}
        else {
	    return des2;
	}
    }
    
    public void mutate(DataSet a) {
	char[] cad=new char[6];
	String des1="";
	String[] generation=a.get_data();
	String[] newGeneration= new String [pSize];
	for (int i=0;i<generation.length;i++) {
            if(mutRate>(float)(Math.random()*1)) {
                int intAletorio=(int)(Math.random()*6);//Aleatoreamente se selecciona una posicion a mutar
                int intAletorio2=(int)(Math.random()*10);//Aleatoreamente se cambia por otro elemento

                cad=generation[i].toCharArray();
                cad[intAletorio]= (char)(intAletorio2 + '0');
                newGeneration[i]=String.valueOf(cad);

            }
            else {
                newGeneration[i]=generation[i];
            }
	}
	a.set_data(newGeneration);
    }
    
    
    
    
    
    
    
    

}