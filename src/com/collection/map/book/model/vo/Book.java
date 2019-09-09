package com.collection.map.book.model.vo;

import java.util.Objects;

public class Book {
	//field
	private String bNo;
	private int category;
	private String title;
	private String author;
	
	//constructor
	public Book() {
		
	}
	public Book(String bNo, int category, String title, String author) {
		this.bNo = bNo;
		this.category = category;
		this.title = title;
		this.author = author;
	}
	
	//getter & setter
	//getter
	public String getBNo() {
		return bNo;
	}
	public int getCategory() {
		return category;
	}
	public String getTitle() {
		return title;
	}
	public String getAuthor() {
		return author;
	}
	//setter
	public void setBNo(String bNo) {
		this.bNo = bNo;
	}
	public void setCategory(int category) {
		this.category = category;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	
	//TODO method
	@Override
	public String toString() {
		return "bNo = "+bNo+", category = "+category+", title = "+title+", author = "+author;
	}
	
	//도서 제목이 같다면 같은 객체로 간주하자.
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Book)) {
			return false;
		}
		// 형변환
		Book other = (Book)obj;
		if(!title.equals(other.title)) {
			return false;
		}
		
		return true;
	}
	
	@Override
	public int hashCode() {
//		return (31+title).hashCode();
		return Objects.hash(title);
	}
}
