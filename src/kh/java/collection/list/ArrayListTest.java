package kh.java.collection.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class ArrayListTest {
	public static void main(String[] args) {
		ArrayListTest a = new ArrayListTest();
//		a.test(); // array 사용시 
//		a.test1(); // list 사용시
//		a.test2(); // generic 사용
//		a.test3(); // 반복문 사용 출력
//		a.test4(); //test()를 ArrayList사용하여 처리
//		a.test5(); // 정렬
		a.test6();
	}

	public void test() {
		// 학생 객체 배열 (3명)
		Student[] arr = new Student[3];
		arr[0] = new Student("a", 1);
		arr[1] = new Student("b", 2);
		arr[2] = new Student("c", 3);

		System.out.println(Arrays.toString(arr));

		// 학생 2명 추가
		Student[] arr1 = new Student[5];
		System.arraycopy(arr, 0, arr1, 0, arr.length);

		arr1[3] = new Student("d", 4);
		arr1[4] = new Student("e", 5);
		System.out.println(Arrays.toString(arr1));

		// 학생 1명 삭제
		arr1[2] = null;
		System.out.println(Arrays.toString(arr1));

		// 빈공간 지우기
		arr1[2] = arr1[3];
		arr1[3] = arr1[4];
		arr1[4] = null;
		System.out.println(Arrays.toString(arr1));

		// 학생 1명 재추가: 3번학생을 2번지에 추가
		arr1[4] = arr1[3];
		arr1[3] = arr1[2];
		arr1[2] = new Student("c", 3);
		System.out.println(Arrays.toString(arr1));

	}

	/*
	 * List 저장한 순서를 유지한다(인덱스로 관리) 요소의 중복이 가능하다.
	 */
	public void test1() {
		ArrayList list = new ArrayList(); // ArrayList<Object> list = new ArrayList<Object>();
		List list1 = new ArrayList();
		Collection list2 = new ArrayList();

		// 리스트는 저장 순서를 유지한다.
		list.add("apple");
		list.add(123);
		list.add(45.67);
		list.add(true);
		list.add(new Date());
		list.add(new Student("abc", 1));

		// toString 메서드가 오버라이딩 되어있음
		System.out.println(list);

		// 요소를 꺼내 쓸 경우 : get(index);
		System.out.println(list.get(0));
		System.out.println(list.get(1));
		System.out.println(list.get(2));
		System.out.println(list.get(3));
		System.out.println(list.get(4));
		System.out.println(list.get(5));

		// 중복을 허용한다.
		list.add("apple");

		// 삭제 : remove()는 삭제된 요소를 리턴
		Object removedItem = list.remove(1);
		System.out.println("삭제된 요소 : " + removedItem);

		// 중간 인덱스 추가 : add(추가할 인덱스, 요소)
		list.add(1, "banana");

		// 요소 수정
		list.set(1, "pineapple");

		// 리스트에 해당 요소가 있는지 여부 확인 : boolean
		boolean bool = list.contains(123);
		System.out.println("123이 list에 존재합니까? " + bool);
		bool = list.contains("apple");
		System.out.println("apple이 list에 존재합니까? " + bool);

		// indexOf = 리스트에 해당요소가 몇 번지에 있는지 확인 : int
		// 존재한다면, 해당하는 처음 만나는 요소의 인덱스를 리턴
		int index = list.indexOf("apple");
		System.out.println("apple : " + index);
		// 마지막 인덱스를 찾고싶다면
		int lastIndex = list.lastIndexOf("apple");
		System.out.println("apple : " + lastIndex);

		// 존재하지 않는다면, -1을 리턴
		index = list.indexOf("grape");
		System.out.println("grape : " + index);

		// 리스트가 비어있는지 확인(요소가 0개인 경우) : isEmpty / boolean타입
		System.out.println(list.isEmpty());
		
		// 리스트내 모든 요소 제거 : clear()
		list.clear();
		System.out.println(list.isEmpty());

		// size() : 실제 저장된 요소의 갯수
		for (int i = 0; i < list.size(); i++) {
			System.out.println(i + " : " + list.get(i));
		}
	}
	
	/*
	 * Generics : 컬렉션에서 사용할 요소의 타입을 제한할 수 있다.
	 * compile - time type check
	 * 꺼낼때 형변환이 필요없다.
	 */
	public void test2() {
		//Generic을 통한 타입 제한
		//해당 컬렉션에는 String타입의 요소만 추가할 수 있다.
		ArrayList<String> list = new ArrayList<String>();
		list.add("hello");
		list.add("java");
		list.add("hello");
		list.add("collection");
		list.add("list");
//		list.add(new Student());
		
		for(int i=0;i<list.size();i++) {
			String s = list.get(i); //요소를 가져올 때 형변환이 필요없다.
			//String 타입을 보장한다.
			System.out.println(i+" : "+s);
		}
		
		//타입 추론(jdk 1.7부터)
		List<Student> studentList = new ArrayList<>();
		studentList.add(new Student("a",1));
		studentList.add(new Student("b",2));
//		studentList.add(new String("abc"));
		
		for(int i=0;i<studentList.size();i++) {
			Student stdt = studentList.get(i);
			System.out.println((i+" : "+ stdt));
		}
		
		// 제네릭은 기본형을 요소로 가질 수 없다.
		// 기본형은 wrapper클래스를 사용해야 한다.
		// int, double, boolean... =? Integer, Double, Boolean 객체 사용
		List<Integer> intList = new ArrayList<>();
		intList.add(1); //기본형을 바로 추가 가능
		intList.add(new Integer(100)); //autoboxing 지원 = intList.add(100);
		
		int num = intList.get(0);
//		Integer iNum = intList.get(0);
//		int num = iNum.intValue();
	}
	
	//요소 열람
	public void test3() {
		List<Integer> list = new ArrayList<>();
		list.add(3);
		list.add(4);
		list.add(5);
		list.add(6);
		System.out.println(list);
		
		//1. 기존 for문 사용하는 방법
		for(int i=0;i<list.size();i++) {
			System.out.println("list("+i+")="+list.get(i));
		}
		
		//2. for each문
		for(int num : list) {
			System.out.println(num);
		}
		
		//3. iterator : 스트링토크나이즈와 유사
//		Iterator iter = list.iterator();//오브젝트 객체 타입
		Iterator<Integer> iter = list.iterator();//Integer 객체 타입
		
		while(iter.hasNext()) {
			int num = iter.next();
			System.out.println(num);
		}
	}
	
	//test()메서드에서 작동한 것을 List로 변환
	public void test4() {
		//학생 객체 배열 3명 생성
		List<Student> stuArr = new ArrayList<Student>();
		stuArr.add(new Student("a",1));
		stuArr.add(new Student("b",2));
		stuArr.add(new Student("c",3));
		//출력
		System.out.println(stuArr);
//		for(Student s : stuArr) {
//			System.out.println(s.toString());
//		}
		
		//학생 2명 추가
		stuArr.add(new Student("d",4));
		stuArr.add(new Student("e",5));
		//출력
		System.out.println(stuArr);
//		for(int i=0;i<stuArr.size();i++) {
//			System.out.println(stuArr.get(i));
//		}
		
		//학생 1명 삭제 : index2
		stuArr.remove(2);
		//출력
		System.out.println(stuArr);
		
		//학생 1명 재추가 : index2에 3번학생 재추가
		stuArr.add(2, new Student("c",3));
		//출력
		System.out.println(stuArr);
	}

	public void test5() {
		List<String> list = new ArrayList<>();
		list.add("banana");
		list.add("apple");
		list.add("mango");
		list.add("grape");
		list.add("orange");
		list.add("avocado");
		System.out.println(list);
		
		//정렬 : String, Integer, ... 
		//기본적으로 정렬메서드(Comparable.compareTo()메서드)를
		//가지고 있다.
		
		//오름차순 정렬 기본
//		Collections.sort(list);
		//comparator : 비교기준을 가진 정렬객체
//		void java.util.List.sort(Comparator<String> c)
		list.sort(null);
		System.out.println(list);
		
		//내림차순 정렬
		Comparator comp = Collections.reverseOrder();
//		Collections.sort(list,comp);
		list.sort(comp);
		System.out.println(list);
	}
	
	public void test6() {
		List<Student> list = new ArrayList<>();
		list.add(new Student("d",3));
		list.add(new Student("f",2));
		list.add(new Student("a",4));
		list.add(new Student("c",6));
		list.add(new Student("e",1));
		list.add(new Student("b",5));
		System.out.println(list);
		
		//정렬(기본정렬) : Comparable.compareTo메서드 오버라이딩
		Collections.sort(list);
		System.out.println(list);
		
		//번호 내림차순 정렬 : 별도로 비교 기준을 가진 
		//                Comparator구현 클래스 작성
		Comparator comp = new DescendingByNo();
		Collections.sort(list, comp);
		System.out.println(list);
		
		//이름 오름차순
		comp = new AscendingByName();
		Collections.sort(list,comp);
		System.out.println(list);
		
		//이름 내림차순
		comp = new DescendingByName();
//		Collections.sort(list,comp);
		list.sort(comp);
		System.out.println(list);
	}
}
