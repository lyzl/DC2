package DC2;

public abstract class DC2Facility {
     Long timeInterval = Long.MAX_VALUE;
     Long tickCount = 1L;
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
     DC2Facility(Long timeInterval){
         this.timeInterval = timeInterval;
         state = true;
     }
     abstract void mainTask();
}
