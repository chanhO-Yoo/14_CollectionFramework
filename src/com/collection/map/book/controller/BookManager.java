package com.collection.map.book.controller;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import com.collection.map.book.model.vo.Book;

public class BookManager {
	//field
	private Map<String,Book> bookMap = new HashMap<>();
	{
		Book b1 = new Book("200", 2, "나미야 잡화점의 기적", "히가시노 게이고");
		bookMap.put(b1.getBNo(),b1);
		
		Book b2 = new Book("100", 3, "파리의 아파트", "기욤 뮈소");
		bookMap.put(b2.getBNo(),b2);
		
		Book b3 = new Book("400", 1, "ABCDE", "도레미");
		bookMap.put(b3.getBNo(),b3);
		
		Book b4 = new Book("300", 2, "미중전쟁", "김진명");
		bookMap.put(b4.getBNo(),b4);
		
		Book b5 = new Book("500", 1, "JAVA 삽질하기", "김동현");
		bookMap.put(b5.getBNo(),b5);
	}
	
	
	//constructor
	public BookManager() {
//		bookList = new ArrayList<>();
	}
	public BookManager(Map<String,Book> bookMap) {
		this.bookMap = bookMap;
	}
	
	//method
	public void addBook(Book book) {
		bookMap.put(book.getBNo(),book);
	}
	
	public void deleteBook(Book book) {
		Set<String> keyset = bookMap.keySet();
		Iterator<String> iter = keyset.iterator();
		while(iter.hasNext()) {
			String key = iter.next();
			if(key.equals(book.getBNo())) {
				bookMap.remove(bookMap.get(key));
			}
		}
		
	}
	
	public int searchBook(String title) {
		Book userSearchBook = new Book();
		userSearchBook.setTitle(title);
		
		System.out.println("------------");
		System.out.println("userSearchBook : "+userSearchBook);
		System.out.println("------------");

		//-----------------------------------------
		int index = -1;
		
		for(int i=0;i<bookMap.size();i++) {
			Book book = bookMap.get(i);
			//문자열 비교
			//if(title.equals(book.getTitle())) {
			//Book객체 비교
			if(userSearchBook.equals(book)) {
				index = i;
				break;
			}
			else {
				index = -1;
			}
		}
		return index;
		
		//---------------------------------
		
//		
//		for(int i=0;i<bookList.size();i++) {
//			Book book = bookList.get(i);
//			//문자열 비교
//			//if(title.equals(book.getTitle())) {
//			//Book객체 비교
//			if(userSearchBook.equals(book)) {
//				return i;
//			}
//		}
//		return -1;
		
		//---------------------------------------
//		return bookList.indexOf(userSearchBook);
	}
	
	public void printBook(int index) {
		System.out.println(bookMap.get(index));
	}
	
	public void printAll() {
		System.out.println(bookMap);
	}
	
//	public Book[] sortedBookList() {
//		Book[] bookArr = new Book[bookMap.size()];
////		for(int i=0;i<bookList.size();i++) {
////			bookArr[i] = bookList.get(i);
////		}
//		
//		bookMap.toArray(bookArr);
//		Comparator comp = new AscCategory();
//		Arrays.sort(bookArr,comp);
//		return bookArr;
//	}
//	public void printBookList(Book[] br) {
//		for(Book book : br) {
//			System.out.println(book);
//		}
//	}
}
