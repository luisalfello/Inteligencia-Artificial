package handson7;

import jade.core.Agent;
import jade.core.behaviours.Behaviour;

public class GenericAgent extends Agent {

     /**
     *
     */
    @Override
    protected void setup() {
        System.out.println("Agent "+getLocalName()+" started.");
        addBehaviour(new MyGenericBehaviour());
    } 

    private class MyGenericBehaviour extends Behaviour {
        DataSet a = new DataSet(10);
        SLR g = new SLR(10,.20f,.20f);//Tamaño de poblacion, rango de crossover, rango de mutacion
        Padres p = new Padres(10);
        
        int generacion = 0;
        Boolean fin = true;
        int aux = 0;
        int cont = 0;
        
        public void action() {
            System.out.println("Agent 7");
            g.set_solucion(168);
            while(aux!=1) {
                g.selectPadres(a, p);
                //p.show(a);
                g.crossover(a, p);
                g.mutate(a);
                aux=g.evaluatePopulation(a.get_data());
                generacion++;	
            }
            System.out.println("Generacion N "+generacion);
            
            g.set_solucion(23);
            a.set_buscar(1);
            aux=0;
            generacion=0;
            while(aux!=1) {
                g.selectPadres(a, p);
                g.crossover(a, p);
                g.mutate(a);
                aux=g.evaluatePopulation(a.get_data());
                generacion++;	
            }
            
            System.out.println("Generacion N "+generacion);
            cont+=1;
            a.show();
            System.out.println("---------------------");
            a.show2();
        } 
    
        public boolean done() {
            if (cont == 1)
                return true;
            else
            return false;
        }
   
        public int onEnd() {
            myAgent.doDelete();
            return super.onEnd();
        } 
    } // END of inner class ...Behaviour
}