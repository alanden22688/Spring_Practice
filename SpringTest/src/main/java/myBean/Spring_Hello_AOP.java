package myBean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Spring_Hello_AOP {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans-config.xml");
//		myBean.HelloBean hello = (HelloBean) context.getBean("helloBean");
		myBean.IHello hello = (IHello) context.getBean("helloBean2");
		System.out.println("哈囉!"+hello.getName());
	}
}
