import java.util.ArrayList;

public class Family {
	
	//Array list of people in family
	protected ArrayList<Person> fmembers = new ArrayList<Person>();
	
	// Method for adding a person to family
	public boolean addPerson(String inName, int inAge){
		if (fmembers.size() < 10) {
			Person newperson = new Person(inName, inAge);
			fmembers.add(newperson);
			return true;
		}
		else {
			return false;
		}
		
	}
	
	// Create default constructor
	public Family() {
	}
	
	// Method for Getting Number of People
	public int getNumberOfPeople () {
		return fmembers.size();
	}
	
	// Display method for the family
	public void display() {
		for (int i =0; i<fmembers.size();i++){
			System.out.println(fmembers.get(i));
		}
	}
	
	// Total age
	public int getTotalAge() {
		int total_age = 0;
		for (int i =0; i<fmembers.size();i++){
			total_age += fmembers.get(i).getAge();
		}
		return total_age;
	}
	
	// Birthday Method
	public void birthday(String inName) {
		for (int i = 0; i < fmembers.size(); i++) {
			Person person_find = fmembers.get(i);
			
			if (inName.equals(person_find.getName())) {
				fmembers.get(i).incrementAge();
			}
			
			else {
				continue;
			}
		}
	}
}
