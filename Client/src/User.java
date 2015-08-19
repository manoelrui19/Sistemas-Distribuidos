import java.io.Serializable;


public class User implements Serializable{
	
	
	private String name;
	private float weight;
	private int age;
	
	public User(String name, float weight, int age) {
		this.name = name;
		this.weight = weight;
		this.age = age;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getWeight() {
		return weight;
	}
	public void setWeight(float weight) {
		this.weight = weight;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
	
	

}
