package kh.java.collection.set;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Random;
import java.util.TreeSet;

import kh.java.collection.list.Student;

public class HashSetTest {
	public static void main(String[] args) {
		HashSetTest h = new HashSetTest();
//		h.test1(); //hashset 사용
//		h.test2();
//		h.test3(); //list - set 변환(중복 제거)
//		h.test4(); //저장 순서를 유지하는 LinkedHashSet
//		h.test5(); //treeset 사용(오름차순정렬 지원)
//		h.test6(); //hashset - hashing을 이용한 비교
		h.test7(); //컬랙션객체 이용하여 로또만들기
	}
	
	public void test1() {
		//객체 생성 = 다형성으로 HashSet, Set, Collection 타입으로 가능
		HashSet set = new HashSet();
//		Set set = new HashSet();
//		Collection set new HashSet();
		
		//set요소 추가
		System.out.println(set.add(123));//set.add(new Integer(123)); : autoboxing 지원
		set.add("java");
		set.add(new String("collection"));
		set.add(45.67);//set.add(new Double(45.67)); : autoboxing
		set.add(new Date());
		
		//확인 : toString()
		System.out.println(set);
		
		//중복 허용 안함
		System.out.println(set.add(123));//중복되면 add되지 않는다.
		set.add("java");
		set.add("123");
		System.out.println(set);
		
		//현재 저장된 요소수 : size()
		System.out.println(set.size());
		
		//요소 포함 여부: contains()
		boolean bool = set.contains(123);
		System.out.println("bool = "+bool);
		bool = set.contains(165123);
		System.out.println("bool = "+bool);
	}
	
	public void test2() {
		//타입추론(jdk 1.7이상)
		HashSet<Character> set = new HashSet<>();
		set.add('b');
		set.add('c');
		set.add('a');
//		set.add("abc"); // 제네릭으로 character로 지정하였기 때문에 사용 불가
						// compile-time type check
		
		System.out.println(set);
		
		System.out.println("=======================");//구분선
		
		// 요소 열람
		// 1.Object[] : Object배열로 변환 후 열람하기
		Object[] arr = set.toArray();
		for(int i=0;i<arr.length;i++) {
			System.out.println(arr[i]);
		}
		
		System.out.println("=======================");//구분선
		
		//2.Iterator(목록화) : 
		Iterator<Character> iter = set.iterator();
		while(iter.hasNext()) {
			char ch = iter.next(); //auto-unboxing
			System.out.println(ch);
		}
		
		System.out.println("=======================");//구분선
		
		//3. for each문
		for(char ch : set) {
			System.out.println(set);
		}
	}
	
	public void test3() {
		//자식 타입 객체를 부모타입 변수에 넣어 제어한다.
		ArrayList<Integer> list = new ArrayList<>();
//		List<Integer> list = new ArrayList<>();
//		Collection<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(3);
		list.add(2);
		list.add(1);
		list.add(4);
		
		System.out.println(list);
		
//		HashSet<Integer> set = new HashSet(Collection<Integer> c);
		HashSet<Integer> set = new HashSet(list);
		System.out.println(set);//리스트 요소중 중복된 요소는 제거됨.
	}
	
	//저장 순서를 유지하는 LinkedHashSet
	public void test4() {
		HashSet<Student> set = new HashSet<>();
		set.add(new Student("a",5));
		set.add(new Student("b",4));
		set.add(new Student("c",3));
		set.add(new Student("d",2));
		set.add(new Student("e",1));
		System.out.println(set); // 저장 순서를 보장하지 않는다.

		//LinkedHashSet 사용(저장순서 보장)
		HashSet<Student> linkedSet = new LinkedHashSet<>();
		linkedSet.add(new Student("a",5));
		linkedSet.add(new Student("b",4));
		linkedSet.add(new Student("c",3));
		linkedSet.add(new Student("d",2));
		linkedSet.add(new Student("e",1));
		System.out.println(linkedSet); // 저장 순서를 보장하지 않는다.

		//set 정렬하기
		//1.List 이용하여 정렬
//		List<Student> listSet = new ArrayList<>(set);
//		System.out.println(listSet);
//		Collections.sort(listSet);// Comparable.compareTo(기본 정렬 메서드) 기준으로 정렬
//		System.out.println(listSet);
		
		//2.TreeSet 이용하여 정렬
		TreeSet<Student> treeSet = new TreeSet<>(set);
		System.out.println(treeSet);
	}
	
	//오름차순 정렬을 지원하는 TreeSet
	public void test5() {
		TreeSet<String> set = new TreeSet<>();
		set.add("bacon");
		set.add("abcde");
		set.add("cake");
		set.add("developer");
		set.add("evergreen");
		//자체 comparable 사용
		System.out.println(set);
	}
	
	//HashSet - Hashing을 이용한 객체 비교
	//Hash로 시작하는 컬렉션클래스는 내부적으로 요소의 비교에 Hashing함수를 이용
	//고유의 Hashcode와 실제 객체의 주소값을 hash table로 관리하는것
	
	public void test6() {
		HashSet<Student> set = new HashSet<>();
		set.add(new Student("a",5));
		set.add(new Student("b",4));
		set.add(new Student("c",3));
		set.add(new Student("d",2));
		set.add(new Student("e",1));
		System.out.println(set);

		//학생번호, 학생이름이 같다면 동일한 객체로 취급
		//객체단위 비교연산(equals, hashCode 오버라이딩 필수
		set.add(new Student("e",1));
		System.out.println(set);
		
	}
	
	//실습문제 : 1~45사이의 중복없는 난수 6개를 생성하여
	//오름차순으로 출력하세요.
	public void test7() {
		Random rnd = new Random();
		HashSet<Integer> set = new HashSet<>();
		
		while(true) {
			if(set.size()==6) {
				break;
			}
			int input = rnd.nextInt(45)+1;
			set.add(input);
		}
		//정렬
		TreeSet<Integer> treeSet = new TreeSet<>(set);
		System.out.println(treeSet);
		
		List<Integer> list = new ArrayList<>(set);
		list.sort(null);
		System.out.println(list);
	}
	
}
