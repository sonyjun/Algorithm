package Programmers;

import java.util.Arrays;

public class SaveBoat {
	public static void main(String[] args) {
		System.out.println(solution(new int[] { 70, 50, 80, 50 }, 100));
		System.out.println(solution(new int[] { 70, 80, 50 }, 100));
		System.out.println(solution(new int[] { 10, 20, 30, 50, 80, 90, 100 }, 100));
	}

	public static int solution(int[] people, int limit) {
		Arrays.sort(people);
		int count = 0;
		int i = 0;
		int j = people.length - 1;
		while (i <= j) {// 한 턴에
			if (people[i] + people[j] <= limit) {
				i++;
				j--;
				count++;
			} else {
				j--;
				count++;
			}
		}
		return count;
	}

	/*
	 * public static int solution(int[] people, int limit) { PriorityQueue<Integer>
	 * que = new PriorityQueue<Integer>(); for (int i = 0; i < people.length; i++) {
	 * que.add(people[i]); } int count = 0; while (!que.isEmpty()) { int pollweight
	 * = que.poll(); if (!que.isEmpty() && que.peek() + pollweight <= limit) {
	 * que.poll(); count++; } else { count++; } } return count; }
	 */
}
