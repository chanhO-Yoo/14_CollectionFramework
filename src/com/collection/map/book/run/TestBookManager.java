package com.collection.map.book.run;

import java.util.Scanner;
import com.collection.map.book.controller.BookManager;
import com.collection.map.book.model.vo.Book;

public class TestBookManager {
	private Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		TestBookManager tbm = new TestBookManager();
		tbm.menu();
	}
	
	public void menu() {
		BookManager bm = new BookManager();
		outer:
		while(true) {
			System.out.println("*** 도서 관리 프로그램 ***");
			System.out.println("1. 새 도서 추가");
			System.out.println("2. 도서정보 정렬 후 출력");
			System.out.println("3. 도서 삭제");
			System.out.println("4. 도서 검색 출력");
			System.out.println("5. 전체 출력");
			System.out.println("6. 끝내기");
			System.out.print(">> ");
			
			int input = Integer.parseInt(sc.nextLine());
			switch(input) {
			case 1:
				Book book = inputBook();
				bm.addBook(book);
				break;
			case 2:
				Book[] bookArr = bm.sortedBookList();
				bm.printBookList(bookArr);
				break;
			case 3:
				String title = inputBookTitle();
				int index = bm.searchBook(title);
				if(index != -1) {
					bm.deleteBook(index);
					break;
				}
				else {
					System.out.println("찾을 수 없습니다.");
					break;
				}
			case 4:
				title = inputBookTitle();
				index = bm.searchBook(title);
				if(index != -1) {
					bm.printBook(index);
					break;
				}
				else {
					System.out.println("찾을 수 없습니다.");
					break;
				}
			case 5:
				bm.printAll();
				break;
			case 6:
				break outer;
			default :
				System.out.println("잘못입력하셨습니다.");
				break;
			}
			
		}
	}
	
	public Book inputBook() {
		System.out.print("도서번호를 입력하세요 : ");
		String bNo = sc.nextLine();
		System.out.print("도서분류코드를 입력하세요 (1.인문 / 2.자연과학 / 3.의료 / 4.기타) : ");
		int category = sc.nextInt();
		sc.nextLine();
		System.out.print("도서제목을 입력하세요 : ");
		String title = sc.nextLine();
		System.out.print("저자를 입력하세요 : ");
		String author = sc.nextLine();
		
		Book book = new Book(bNo, category, title, author);
		return book;
	}
	
	public String inputBookTitle() {
		System.out.print("도서 제목을 입력하세요 : ");
		String title = sc.nextLine();
		return title;
	}
}
