package myBean;

public class HelloBeanAOPDemo implements IHello{
	private String name = "World";
	
	@Override
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
