package Sort;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class SortByAge {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Person[] personArr = new Person[n];
		StringTokenizer st;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int age = Integer.parseInt(st.nextToken());
			String name = st.nextToken();
			personArr[i] = new Person(age, name);
		}
		Arrays.sort(personArr, new Comparator<Person>() {

			@Override
			public int compare(Person o1, Person o2) {
				// TODO Auto-generated method stub
				if (o1.age > o2.age) {
					return 1;
				} else if (o1.age < o2.age) {
					return -1;
				} else {
					return 0;
				}
			}
		});
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < personArr.length; i++) {
			sb.append(personArr[i].age + " " + personArr[i].name + "\n");
		}
		System.out.println(sb);
	}
}

class Person {
	int age;
	String name;

	public Person(int age, String name) {
		this.age = age;
		this.name = name;
	}
}
