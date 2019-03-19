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
         if(state){
             if(tickCount >= timeInterval){
                 mainTask();
                 tickCount = 0;
             }else{
                 tickCount++;
             }
         }
     }
     abstract void mainTask();
}
