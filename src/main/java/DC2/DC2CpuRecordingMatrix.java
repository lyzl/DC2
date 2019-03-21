package DC2;

import java.util.LinkedList;
import java.util.Queue;

public class DC2CpuRecordingMatrix {
    DC2CpuAgent agent;
    Queue<Float> occupationHistoryQueue;
    DC2CpuRecordingMatrix(DC2CpuAgent agent){
        this.agent = agent;
        occupationHistoryQueue = new LinkedList<>();
    }
}
