import java.io.*;

//Create separate class in order to set the forest name, make/randomize, and a method to send info to grow trees
public class Forest implements Serializable {
	Tree[] trees;
	String forestName;
	
//create constructor
public Forest(){
	Tree[] trees = new Tree[10];
	this.trees = trees;
}
//constructor that will randomize the trees
public Forest (String forestName ){
		this.forestName = forestName;
		trees = new Tree [10];
		for(int i=0; i < trees.length; i++) {
			trees[i] = new Tree(Math.random()*4+1, Math.random()*50+50);	
		}

    }
//grow method when entering in Y in the switch statement, goes into tree class
public void grow () {
		for(int i=0; i < trees.length; i++) {
			trees[i].grow();
		}
	}

//method to set the forest name for the class
public void setForestName(String name){
	this.forestName = name;
}
}
