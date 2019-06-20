
public class Person {
	
	// Make Properties
	String name;
	int age;
	
	// Create default constructor
	public Person() {
	}
	
	// Create constructor
	public Person(String inName, int inAge){
		setName(inName);
		setAge(inAge);
	}
	
	// Method to increase age by one
	public void incrementAge() {
		age +=1;
	}
	
	// Getter method -- Name
	public String getName() {
		return name;
	}
	
	// Getter method -- age
	public int getAge() {
		return age;
	}
	
	// Setter method -- name
	public void setName(String inName) {
		name = inName;
	}
	
	// Setter method -- age
	public void setAge (int inAge) {
		age = inAge;
	}
	
	// to String
	public String toString() {
		return name + " is " + age + " years old";
	}

}