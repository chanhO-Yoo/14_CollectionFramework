package kh.java.collection.map;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import kh.java.collection.list.Student;

/*
 * key & value가 한 쌍으로 하나의 요소를 구성
 * 요소에 접근하려면, get(key) => value를 가져온다.
 * key값은 중복을 허용하지 않는다.
 * 동일한 key값으로 요소를 추가하면, 나중에 입력된 값으로 대체된다.
 * 
 */

public class HashMapTest {
	public static void main(String[] args) {
		HashMapTest h = new HashMapTest();
//		h.test1();
//		h.test2(); //generic을 사용한 타입제한
//		h.test3(); //map요소 열람하기
		h.test4(); //custom class를  map으로 관리
	}
	
	public void test1() {
		HashMap<Object, Object> map = new HashMap();
		Map map2 = new HashMap();
//		Collection map3 = new HashMap(); //collection에서 상속되지 않았기에 사용불가
		
		map.put("today", new Date());
		map.put(100, "일백"); //<Integer,String> auto-boxing
		map.put(true, new Student()); //<Boolean, Student>
		
		//toString, 순서를 보장하지 않는다(List만 순서 보장)
		System.out.println(map);
		
		//key는 중복 저장되지 않는다.
		//set의 경우 저장 자체가 되지 않지만, key는 동일한 key값인 경우 대체된다.
		map.put(100, "일백백");
		System.out.println(map);
		
		//1. 새로운 key값을 가진 요소 추가 : put결과로 null이 리턴됨
		System.out.println(map.put(99, "구십구"));
		//2. 존재하는 key값을 가진 요소 추가 : put결과로 삭제된 요소가 리턴됨
		System.out.println(map.put(100, "일빵빵"));
		
		//value는 중복되어도 상관이 없다.(key가 중요)
		map.put(200, "구십구");
		System.out.println(map);
		
		//요소삭제 : remove(key);
		map.remove(true);
		System.out.println(map);
	}
	
	/*
	 * Generics를 사용한 타입제한
	 * (꺼내올 때도 형변환 생략 가능)
	 * 
	 */
	public void test2() {
		HashMap<Integer, String> map = new HashMap<>();
		map.put(1, "Java");
		map.put(2, "Oracle");
		map.put(3, "JDBC");
		map.put(4, "HTML5");
		map.put(5, "CSS3");
		System.out.println(map);
		
		//요소가져오기 : get(key)
		String subject1 = map.get(1);
		System.out.println(subject1);
		map.put(3, "JavaScript");
		String subject3 = map.get(3);
		System.out.println(subject3);
	}
	
	/*
	 * 맵 요소 열람하기
	 *  - keyset
	 *  - entryset
	 */
	public void test3() {
		Map<String, Double> map = new HashMap<>();
		map.put("oracle", 90.0);
		map.put("jdbc", 80.0);
		map.put("java", 100.0);
		
		//1.keyset
		System.out.println(map.get("java"));
		System.out.println(map.get("oracle"));
		System.out.println(map.get("jdbc"));
		
		Set<String> keyset = map.keySet();
		Iterator<String> iter = keyset.iterator();
		while(iter.hasNext()) {
			String key = iter.next();
			System.out.println(map.get(key));
		}
		
		for(String k : keyset) {
			System.out.println(map.get(k));
		}
		
		//2.entryset
		//map의 요소(k,v)는 내부적으로 Node<K,V>로 관리된다.
		//Node<K,V>는 Map.Entry를 상속한다.
		Set<Map.Entry<String, Double>> entrySet= map.entrySet();
		Iterator<Map.Entry<String, Double>> iter2 = entrySet.iterator();
		
		while(iter2.hasNext()) {
			Map.Entry<String, Double> entry = iter2.next();
			String key = entry.getKey();
			Double value = entry.getValue();
			
			System.out.println(key+" = "+value);
		}
	}
	
	/*
	 * custom class를 map으로 관리
	 *  - key : 객체를 구분할 수 있는 고유필드를 
	 *  - value : 해당 객체
	 */
	public void test4() {
		Map<Integer, Student> map = new HashMap<>();
		map.put(1, new Student("abc",1));
		map.put(2, new Student("def",2));
		map.put(3, new Student("ghi",3));
		map.put(4, new Student("jkl",4));
		map.put(5, new Student("mno",5));
		
		//keyset
		Set<Integer> keyset = map.keySet();
		Iterator<Integer> iter = keyset.iterator();
		while(iter.hasNext()) {
			Integer k = iter.next();
			Student s = map.get(k);
			System.out.println(k+" = "+s);
		}
		
		//3번 학생이 존재하는가?
		System.out.println(map.containsKey(3));
		System.out.println(map.containsKey(10));
		
		
	}
}
