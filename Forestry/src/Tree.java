import java.io.*;

//Class to set the height and rate as well as math for growing the trees
public class Tree implements Serializable{
	double height;
	double rate;
//constructor that sets the height and the rate	
public Tree (double height, double rate) {
		this.height = height;
		this.rate = rate;			
	}
//method for growing
public void grow() {
		height+= height*(rate/100);
	}
}
