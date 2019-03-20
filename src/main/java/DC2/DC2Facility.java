package DC2;

public abstract class DC2Facility {
     Integer timeInterval = Integer.MAX_VALUE;
     Integer tickCount = 0;
     Boolean state = false;
     void start(){
         state = true;
     }
     void stop(){
         state = false;
     }
     void tick(){
         if(tickCount % timeInterval == 0 && state){
             mainTask();
         }
         tickCount++;
     }
     abstract void mainTask();
}
