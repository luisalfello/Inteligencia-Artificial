package handson6;

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
        
        int cont=0;
        DataSet a;
        
        public void action() {
            System.out.println("Agent 6");
            DataSet a = new DataSet();
            GD g = new GD();
            
            
            
            for(int i = 0; i < 10;i++){
                g.step2(a.get_x(), a.get_y());
            }
            
            
            cont+=1;
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