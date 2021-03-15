 package com.brms.book.service;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;

import com.brms.book.Book;
import com.brms.book.dao.BookDao;

// 인터페이스를 적용하여, 빈 객체 생성 및 소멸 시 메서드 구현 가능 
public class BookRegisterService implements InitializingBean, DisposableBean {

	@Autowired
	private BookDao bookDao;
	
	public BookRegisterService() { }
	
	public void register(Book book) {
		bookDao.insert(book);
	}
	
	public void initMethod() {
		System.out.println("BookRegisterService 빈(Bean)객체 생성 단계");
	}
	
	public void destroyMethod() {
		System.out.println("BookRegisterService 빈(Bean)객체 소멸 단계");
	}


	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("bean 객체 생성");       
	}
	
	public void destroy() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("bean 객체 소멸");       
		
	}

} 