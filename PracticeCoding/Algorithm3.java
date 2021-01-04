package PracticeCoding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Algorithm3 {
	public static void main(String args[]) {
		Solution3 s3 = new Solution3();
		int[] priorities = {5,2,3};
		//int[] priorities1 = { 1, 1, 9, 1, 1, 1};
		System.out.println(s3.solution(priorities, 1));
		//System.out.println(s3.solution(priorities1, 0));
		//s3.solution(priorities1, 0);
	}
}
/*
class KeyValue{
	int key;
	int value;
}
class Solution3 {
	public int solution(int[] priorities, int location) {
		LinkedList<KeyValue> queue = new LinkedList<KeyValue>();
		ArrayList<KeyValue> answer = new ArrayList<KeyValue>();
		KeyValue[] kv = new KeyValue[priorities.length];
		
		for (int i = 0; i < priorities.length; i++) {
			kv[i] = new KeyValue();
			kv[i].key = i;
			kv[i].value = priorities[i];
			queue.add(kv[i]);
		}

		while (!queue.isEmpty()) {// queue가 비워질때까지 돌림. 다 비워진다 = 모든 정렬이 끝이 났다.
			int maxNum = queue.get(0).value; // 항상 인덱스는 0 부터 탐색해야되므로, 임의의 값 넣어놓음.
			for (int j = 1; j < queue.size(); j++) {
				if (maxNum < queue.get(j).value) {// 제일 큰 값 추출.
					maxNum = queue.get(j).value;
				}
				// 본인보다 큰값 만나면 바꿀수도 있지만, 그게 제일 큰값인지 모르고
				// 바꿔 버리면 꼬이게 되므로 최대값을 찾기위해선 모두 탐색해야됨.
			}
			if (queue.get(0).value < maxNum) {// 인덱스 0의 위치보다 큰게 있을경우 밀어내기.
				queue.add(queue.poll());
			} else {// 인덱스 0의 위치보다 큰게 없으면 제일 큰값이므로 다른 곳에 보관, 같은 우선순위도!
				answer.add(queue.poll());
				// rotationCount++;
			}
		}
		for(int i = 0 ; i < answer.size() ; i++) {
			if(answer.get(i).key == location) {
				location = i+1;
				break;
			}
		}
		return location;
	}
}*/

class Solution3 {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        int l = location;

        Queue<Integer> que = new LinkedList<Integer>();
        for(int i : priorities){// queue에 넣음.
            que.add(i);
        }

        Arrays.sort(priorities); //priorities는 우선순위로 정렬
        int size = priorities.length-1;



        while(!que.isEmpty()){
            Integer i = que.poll();
            //l < 0의 의미 : 본인이 비교될 차례에서 1. 우선순위 제일 큰거랑 동일하다. 본인이 출력된다 2. 동일하지 않다. 젤뒤로 간다
            
            if(i == priorities[size - answer]){//큐에서 빼낸것이 제일 큰거라면.
                answer++;//다시 안집어넣고 answer을 증가.. 제일 큰거를 빼낸거니 다음껄로 비교하겟다.
                		// location친구가 출력되기 앞서 먼저 시행될 작업들의 갯수를 나타내기도 함.

                l--;//현재 location을 가리키는 지표.
                    //감소하는 이유는 1. 큐에서 어떤 값이 빠지던, 2. 안빠지던 => 밀어내기과정이 일어나기 때문
                    // 즉, 인덱스의 이동은 무조건 시행된다.
                if(l < 0)// 여기 if문에서 0이 되었다는건 다음턴에 본인이 비교대상이라는 것.
                		// 본인이 비교가 될 차례에서 우선순위가 제일 크다(음수가 되었다)
                		// 본인이 제일 크다, 본인이 해방될 시간이다.
                {
                	//System.out.println("d"+l);
                    break;
                }
            }else{//제일 크지 않다면,
                que.add(i);//다시 집어넣음.
                l--;//위에 설명.
                //System.out.println("2");
                if(l < 0)//크지 않은데, 이 친구가 제일 뒤로 가는 과정이 되어버리므로 (큐 크기 -1)을 해버림.
                	//이 구문은 무조건 제일 뒤로갈때만 돌아감.
                {   
                	l=que.size()-1;
                	
                }
            }
        }

        return answer;
    }
}
