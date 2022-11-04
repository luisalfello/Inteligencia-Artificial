package handson8;

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
        int size = 10;
        DataSet a = new DataSet(size);
        Genetic g = new Genetic(size,.2f,.2f);
        Padres p = new Padres(size);
        
        int generacion = 0;
        Boolean fin = true;
        int aux = 0;
        int cont = 0;
        
        public void action() {
            System.out.println("Agent 8");
            g.set_solucion(30);
            while(aux!=1) {
                g.selectPadres(a, p);
                //p.show(a);
                g.crossover(a, p);
                g.mutate(a);
                aux=g.evaluatePopulation(a.get_data());
                generacion++;	
                
            }
            System.out.println("Generacion N "+generacion);
            a.show();
            
            
            cont++;
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