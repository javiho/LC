package my.vaadin.app;

public class User {

	private Life life;
	private String name;
	
	public User(String name){
		this.name = name;
	}

	public Life getLife() {
		return life;
	}

	public void setLife(Life life) {
		this.life = life;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
