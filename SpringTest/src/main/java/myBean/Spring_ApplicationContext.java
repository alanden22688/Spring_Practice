package myBean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Spring_ApplicationContext {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans-config.xml");
		
		HelloBean hello = (HelloBean) context.getBean("helloBean");
		System.out.println("哈囉!"+hello.getName());
		
		Object dateBean = context.getBean("dateBean");
		System.out.println("日期:"+dateBean);
	}
}
