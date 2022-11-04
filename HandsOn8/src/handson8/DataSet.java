package handson8;

public class DataSet {
    private String[] cromosomas;
    private int tamaño;//Tamaño de poblacion
    private int buscar;//si  es cero busca B si es 1 busca B1
    
    public DataSet(int valor) {
        tamaño = valor;
        System.out.println("Creamos..");
        cromosomas=new String[tamaño];
        String aux="";
	int intAleatorio;
        for (int i=0;i<valor;i++) {
            for(int x=0;x<6;x++) {
		intAleatorio=(int)(Math.random()*10);
		aux+=intAleatorio;
            }
            cromosomas[i]=aux;
            aux="";
	}
	buscar=0;
    }
    
    public int total(String value){
        int suma = 0;
        char[] aux;
        aux = value.toCharArray();
            
        Character.getNumericValue(aux[0]);
        suma=(Character.getNumericValue(aux[0]) + (2*Character.getNumericValue(aux[1])) - (3*Character.getNumericValue(aux[2])) + Character.getNumericValue(aux[3]) + (4*Character.getNumericValue(aux[4])) + Character.getNumericValue(aux[5]));
        
        return suma;
    }
    
    public void show() {
        int resp = 0;
	for(int i=0;i<tamaño;i++){
            resp=total(cromosomas[i]);
            System.out.println("Cromosoma: "+cromosomas[i]+"  Suma: " + resp + "  No."+i);
	}
    }
    
    public int get_lenght() {
	return cromosomas.length;
    }
    public String get_data(int posicion) {
        return cromosomas[posicion];
    }
    public String[] get_data() {
        return cromosomas;
    }
    public void set_data(String[] a) {
        cromosomas=a;
    }	
    
    
}
