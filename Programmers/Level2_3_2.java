package Programmers;

import java.util.LinkedList;
import java.util.Queue;

public class Level2_3_2 {
	public static void main(String[] args) {
		int bridge_length1 = 2;
		int bridge_length2 = 100;
		int bridge_length3 = 100;
		// int bridge_length4 = 4;

		int weight1 = 10;
		int weight2 = 100;
		int weight3 = 100;
		// int weight4 = 2;

		int[] truck_weights1 = { 7, 4, 5, 6 };
		int[] truck_weights2 = { 10 };
		int[] truck_weights3 = { 10, 10, 10, 10, 10, 10, 10, 10, 10, 10 };
		int[] truck_weights4 = { 1, 1, 1, 1 };

		System.out.println(solution(bridge_length1, weight1, truck_weights1));
		System.out.println(solution(bridge_length2, weight2, truck_weights2));
		System.out.println(solution(bridge_length3, weight3, truck_weights3));
		System.out.println(solution(4, 2, truck_weights4));
	}

	public static int solution(int bridge_length, int weight, int[] truck_weights) {
		Queue<Truck> waiting = new LinkedList<>();
		Queue<Truck> bridge = new LinkedList<>();

		for (int i = 0; i < truck_weights.length; ++i) {
			waiting.offer(new Truck(truck_weights[i], 0));
		}

		int time = 0;
		int totalWeight = 0;
		while (!waiting.isEmpty() || !bridge.isEmpty()) {
			time++;// 시간을 계속 흘러감.
			if (!bridge.isEmpty()) {
				Truck t = bridge.peek();
				if (time - t.startTime == bridge_length) { // 현재시간이랑 비교해서 시간이 다 지났다면,
					totalWeight -= t.weight;
					bridge.poll();
				}
			}

			if (!waiting.isEmpty()) {
				if (totalWeight + waiting.peek().weight <= weight) {// 무게가 들어갈 수 있는 무게라면
					Truck t = waiting.poll();
					totalWeight += t.weight;

					bridge.offer(new Truck(t.weight, time));// 들어간 시간 기록.
				}
			}
		}
		return time;
	}
}

class Truck {
	int startTime;
	int weight;

	public Truck(int weight, int startTime) {
		this.startTime = startTime;
		this.weight = weight;
	}
}