package kh.java.collection.list;

import java.util.Comparator;

/*
 * Student 객체를 no 내림차순으로 정렬한 비교 기준 객체
 */
public class DescendingByNo implements Comparator<Student> {
	@Override
	public int compare(Student s1, Student s2) {
		return s2.getNo()-s1.getNo();
	}
}
