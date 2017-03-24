package bwf.teaching.book.web.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;


import bwf.teaching.book.service.CategoryService;


@WebListener
@Component
public class BookWebAppListener implements ServletContextListener, ApplicationContextAware {

	@Override
	public void contextInitialized(ServletContextEvent event) {		
		CategoryService categoryService = (CategoryService) BookWebAppListener.ctx.getBean("cgService");
		event.getServletContext().setAttribute("allCategories", categoryService.getAllCategories());
		System.out.println("\n******************BwfBook网站启动时，向appliation作用域中设置了属性：allCategories******************\n");		
	}


	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		
	}


	
	private static ApplicationContext ctx;

	@Override
	public void setApplicationContext(ApplicationContext ctx) throws BeansException {		
		BookWebAppListener.ctx = ctx;
	}

	
}
