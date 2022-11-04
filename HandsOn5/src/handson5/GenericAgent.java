package handson5;

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
            System.out.println("Comienza...");
            DataSet a = new DataSet();
            MLR m = new MLR();
            
            m.cal_X(a.get_x1(),a.get_x2(),a.get_y());
            m.calXY(a.get_x1() ,a.get_x2() ,a.get_y());
            m.cal_B();
            
            m.simular(165349.2, 136897.8);
            //m.simular(41.9,29.1);
            
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