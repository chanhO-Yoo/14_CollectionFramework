package kh.java.collection.map.properties;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesTest {
	public static void main(String[] args) {
		PropertiesTest t = new PropertiesTest();
//		t.test();
		t.test2();
	}
	
	//properties
	public void test() {
		//k, v는 String, String으로 제한된 타입
		//환경설정파일, 속성정의 등에 최적화 되어있다.
		Properties prop = new Properties();
		prop.setProperty("abc", "알파벳");
		prop.setProperty("hello", "properties");
		prop.setProperty("kh", "java");
		System.out.println(prop);
		
		//파일에 쓰기
		try {
			//File에 작성
//			prop.store(new FileOutputStream("info.properties"), "Properties test");
			//XML파일에 작성(사용자 정의 태그 파일)
			//<kh> java </kh>
			prop.storeToXML(new FileOutputStream("info.xml"), "XML test");
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void test2() {
		Properties prop = new Properties();
		try {
//			prop.load(new FileInputStream("info.properties"));
			
			prop.loadFromXML(new FileInputStream("info.xml"));
			System.out.println(prop);
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}
