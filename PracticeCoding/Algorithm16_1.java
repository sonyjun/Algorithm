package PracticeCoding;

import java.util.LinkedList;
import java.util.Queue;

public class Algorithm16_1 {
	public static void main(String args[]) {
		Solution16_1 s16 = new Solution16_1();

		int bridge_length = 3;
		int weight = 5;
		int[] truck_weights = { 2,1,4,5 };
		System.out.println(s16.solution(bridge_length, weight, truck_weights));
	}
}

class Solution16_1 {
    class Truck {
        int weight;
        int entry;
        
        Truck(int weight, int entry){
            this.weight = weight;
            this.entry = entry;
        }
    }
    
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Truck> waiting = new LinkedList<>();
        Queue<Truck> bridge = new LinkedList<>();
        
        for(int i = 0 ; i < truck_weights.length ; ++i){
            waiting.offer(new Truck(truck_weights[i], 0));//대기 큐에 일단 다 넣음.
        }
        
        int time = 0;
        int totalWeight = 0;
        while(!waiting.isEmpty() || !bridge.isEmpty()){ // 대기 큐와 진행 큐가 비어질때까지.
        	time++;//시간 역할.
        	if(!bridge.isEmpty()) {//브리지가 비어있지 않다면, 시간이 흘러가도록 해야지.
        		Truck t = bridge.peek();//제일 빨리 들어간놈이 제일 빨리 나올테니까 그 친구만 탐색.
        		if(time - t.entry >= bridge_length) {//1초에 한칸씩 가므로, 현재 시간에서 들어간 시간을 빼면
        											//큐에 얼마나 있었는지 알 수 있음.
        			totalWeight -= t.weight;// 한놈이 나왔으므로 무게 줄여줘야지.
        			bridge.poll(); //나갈 차례의 친구 빼줌.
        		}
        	}
        	
        	if(!waiting.isEmpty()) {//대기큐가 비어있지 않다면, 들어갈 수 있으면 브리지로 들어감.
        		if(totalWeight + waiting.peek().weight <= weight) {
        			Truck t = waiting.poll();
        			totalWeight += t.weight;
        			
        			bridge.offer(new Truck(t.weight, time));
        		}
        	}
        }//즉 시간이 지날때마다 브리지 큐, 대기 큐의 상태를 확인하고 업데이트 시켜주는 구조.
        return time;
    }
}
