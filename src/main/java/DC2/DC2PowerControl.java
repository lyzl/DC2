package DC2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class DC2PowerControl {
    private ArrayList<DC2CpuAgent> cpuAgentList;
    private DC2PowerManagementPolicy PMP;
    public DC2PowerControl(ArrayList<DC2CpuAgent> cpuAgentList){
        this.cpuAgentList = cpuAgentList;
    }
    private class sortingStrategy implements Comparator<DC2CpuAgent>{

        @Override
        public int compare(DC2CpuAgent o1, DC2CpuAgent o2) {
            return o1.getWorkload() < o2.getWorkload() ? 1 : 0;
        }
    }

    public void balancePower(){
        ArrayList<DC2CpuAgent> onlineCpuAgentList = new ArrayList<DC2CpuAgent>();
        ArrayList<DC2CpuAgent> offlineCpuAgentList = new ArrayList<DC2CpuAgent>();;
        for(DC2CpuAgent agent: cpuAgentList){
            if(agent.getCpuState() == CpuState.ON){
                onlineCpuAgentList.add(agent);
            }else{
                offlineCpuAgentList.add(agent);
            }
        }
        if(onlineCpuAgentList.size() > PMP.optimalCpuNum){
            Collections.sort(onlineCpuAgentList, new sortingStrategy());
            int remain = onlineCpuAgentList.size() - PMP.optimalCpuNum;
            if(remain > 0){
                for(int i = 0; i < remain; i++) {
                    onlineCpuAgentList.get(i).shutDown();
                }
            }
        }else if(onlineCpuAgentList.size() < PMP.optimalCpuNum){
            int need = PMP.optimalCpuNum - onlineCpuAgentList.size();
            need = need < offlineCpuAgentList.size() ? need : offlineCpuAgentList.size();
            for(int i = 0; i < need; i++){
                offlineCpuAgentList.get(i).powerOn();
            }
        }

    }
}