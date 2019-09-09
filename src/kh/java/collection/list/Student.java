package kh.java.collection.list;

import java.util.Objects;

public class Student implements Comparable<Student> {
	private String name;
	private int no;
	
	public Student() {
		
	}
	public Student(String name, int no) {
		this.name = name;
		this.no = no;
	}
	
	public int getNo() {
		return no;
	}
	public String getName() {
		return name;
	}
	
	public void setNo(int no) {
		this.no = no;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "["+name+", "+no+"]";
	}
	
	/*
	 * Collections.sort()
	 * List.sort()
	 * 내부적으로 compareTo메서드를 호출하여 정렬함
	 */
	@Override
	public int compareTo(Student other) {
		//음수 : 순서유지
		//0 : 순서유지
		//양수 : 자리교환
		return this.no - other.no;
	}
	
	//Object.equals 연산은 주소값 비교
	//필드값 비교로 오버라이딩
	//학생이름, 학생번호가 같다면 같은 객체로 간주한다.
	 @Override
	 public boolean equals(Object obj) {
		 //student타입 확인
		 if(!(obj instanceof Student)) {
			 return false;
		 }
		 
		 //객체의 필드값에 직접 접근할 수 없어 형변환 실행
		 Student other = (Student)obj;
		 
//		 if(!name.equals(other.name)) {
//			 return true;
//		 }
		 if(no != other.no) {
			 return false;
		 }
		 
		 return true;
	 }
	 
	 //학생이름, 학생번호 두 필드값을 이용해
	 //hashCode 오버라이딩
	 @Override
	 public int hashCode() {
		 //String의 hashCode 이용
//		 return (31+name+no).hashCode();//비트연산하는데 유리한 수 = 31을 사용
		 
		 //Objects.hash() : jdk1.8이상
		 return Objects.hash(no);
		 
	 }
}
