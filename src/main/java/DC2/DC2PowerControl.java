package DC2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class DC2PowerControl {
    private ArrayList<DC2CpuAgent> cpuAgentList;
    private DC2PowerManagementPolicy PMP;
    public int agentlistSize;
    public boolean setValue;
    public int r;
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
        ArrayList<DC2CpuAgent> offlineCpuAgentList = new ArrayList<DC2CpuAgent>();
        if(PMP.optimalCpuNum < 0){
            throw new IllegalArgumentException("optimal CPU number illegal");
        }
        for(DC2CpuAgent agent: cpuAgentList){
            if(agent.getCpuState() == DC2CpuState.ON){
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

    public void balancePower(ArrayList<DC2CpuAgent> cpuAgentList, DC2PowerManagementPolicy PMP) {
        ArrayList<DC2CpuAgent> onlineCpuAgentList = new ArrayList<DC2CpuAgent>();
        ArrayList<DC2CpuAgent> offlineCpuAgentList = new ArrayList<DC2CpuAgent>();

        for (DC2CpuAgent agent : cpuAgentList) {
            if (agent.getCpuState() == DC2CpuState.ON) {
                onlineCpuAgentList.add(agent);
                System.out.println("Agent added to the Online List");
            } else {
                offlineCpuAgentList.add(agent);
                System.out.println("Agent added to the Offline  List");
            }
        }
        if (onlineCpuAgentList.size() > PMP.optimalCpuNum) {
//                Collections.sort(onlineCpuAgentList, new sortingStrategy());

            int remain = onlineCpuAgentList.size() - PMP.optimalCpuNum;
            if (remain > 0) {
                for (int i = 0; i < remain; i++) {
                    onlineCpuAgentList.get(i).shutDown();
                }
            }
            System.out.println("Shutting down CPU's");
        } else if (onlineCpuAgentList.size() < PMP.optimalCpuNum) {
            int need = PMP.optimalCpuNum - onlineCpuAgentList.size();
            need = need < offlineCpuAgentList.size() ? need : offlineCpuAgentList.size();
            for (int i = 0; i < need; i++) {
                offlineCpuAgentList.get(i).powerOn();
            }
            System.out.println("Powering On CPU's");
        }
    }

    public void balancePower(String value,DC2PowerManagementPolicy PMP) {
        ArrayList<DC2CpuAgent> onlineCpuAgentList = new ArrayList<DC2CpuAgent>();
        ArrayList<DC2CpuAgent> offlineCpuAgentList = new ArrayList<DC2CpuAgent>();

        if (value == "ON") {
            System.out.println("Agent added to the Online List");

        } else {
            System.out.println("Agent added to the Offline List");
            int size = 3;
            if (size > PMP.optimalCpuNum) {
                int remain = size - PMP.optimalCpuNum;
                if (remain > 0) {
                    System.out.println("Shutting down Online Agents");
                }
            }
            else
            {
                System.out.println("Powering on the Agents");

            }
        }
    }


    public void balancePower(ArrayList<DC2CpuAgent> cpuAgentList,String value, DC2PowerManagementPolicy PMP,String state) {
        ArrayList<DC2CpuAgent> onlineCpuAgentList = new ArrayList<DC2CpuAgent>();
        ArrayList<DC2CpuAgent> offlineCpuAgentList = new ArrayList<DC2CpuAgent>();

        if (cpuAgentList != null){
            for (DC2CpuAgent agent : cpuAgentList) {
                if (value == "OFF"|| value == "ON" || state == "OFF" || state == "ON" ){
                    if (value == state) {
                        onlineCpuAgentList.add(agent);
                        agentlistSize = onlineCpuAgentList.size();
                    } else {
                        offlineCpuAgentList.add(agent);
                        agentlistSize = offlineCpuAgentList.size();
                    }
                }
                else
                {
                    setValue = false;
                }
            }
        }

        if (PMP.optimalCpuNum != null && onlineCpuAgentList != null ){
            if (onlineCpuAgentList.size() > PMP.optimalCpuNum) {
                int remain = onlineCpuAgentList.size() - PMP.optimalCpuNum;
                if (remain > 0) {
                    r=remain;
                    System.out.println("Shut down " +remain+" CPU");
                    for (int i = 0; i < remain; i++) {
                        onlineCpuAgentList.get(i).shutDown();
                    }
                }
            } else if (onlineCpuAgentList.size() < PMP.optimalCpuNum) {
                int need = PMP.optimalCpuNum - onlineCpuAgentList.size();
                need = need < offlineCpuAgentList.size() ? need : offlineCpuAgentList.size();
                System.out.println("Power on "+need+" CPU's");
                for (int i = 0; i < need; i++) {
                    offlineCpuAgentList.get(i).powerOn();
                }
            }
        }
        else{
            setValue = false;
        }
    }

}
