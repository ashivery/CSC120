import java.io.*;
import java.util.*;
import java.lang.Math;
//
public class ForestryManagement {
//
	private static Scanner keyboard = new Scanner(System.in);
//
	protected static Forest forest;
	protected static String fName;
	
	public static void main(String[] args) {
		
		boolean exit;
		char input;
		int reap;

		
//make a menu for the switch statements		
		exit=false;	 
		while (exit==false) {
			System.out.print("(D)isplay, (N)ew, (Y)ear, (R)eap, (S)ave,"+ " (L)oad," + " e(X)it: ");
			input = Character.toUpperCase(keyboard.next().charAt(0));
			
			switch(input) {
//case D, display method for the trees 
			case 'D':
				if (forest !=null){
					System.out.println(forest.forestName);
					for(int i=0; i < 10; i++) {
					System.out.printf("%2d: %4.2f (%2.0f%% pa)\n", i + 1, forest.trees[i].height, forest.trees[i].rate);
					}
				} else {
					System.out.println("No forest");
				}
				break;
//create a switch for new forest
			case 'N':
				System.out.print("What is the forest name:");
				String forestName = keyboard.next();
				forest = new Forest (forestName);
				break;
//create a switch for growing the trees
			case 'Y':
				forest.grow();
				break;
//create a switch for reaping the trees
			case 'R':
				reap = 0;
				try {
				System.out.print("What height to reap at:");
				reap=keyboard.nextInt();
				for(int i=0; i < 10; i++) {	
					if (forest.trees[i].height > reap) {
						System.out.printf("Cut %d : %5.2f (%2.0f%% pa) \n", i+1, forest.trees[i].height, forest.trees[i].rate);
						forest.trees[i]= new Tree(Math.random()*4+1, Math.random()*50+50);
						System.out.printf("New %d : %5.2f (%2.0f%% pa) \n", i+1, forest.trees[i].height, forest.trees[i].rate);	
					}
				}
				} catch (InputMismatchException e) {
					System.out.println ("ERROR: Invalid height");
					keyboard.nextLine();
				}
				break;
//create switch for saving forests
			case 'S':
				saveForestFile(forest.forestName, forest);
				break;
//create a switch for loading forests
			case 'L':
				System.out.print("What is the name of the forest : ");
				fName = keyboard.next();
				loadTreeFile(fName);
				break;
//switch for exiting the program
			case 'X':
				System.out.println("Goodbye");
				return;
			default:
				System.out.println("ERROR: Invalid option");
				break;
				
			}
		}
	}
//method to save the tree file
public static boolean saveForestFile(String fileName, Forest forest) {

        ObjectOutputStream treeFile = null;
        int treeNumber;

        try {
            treeFile = new ObjectOutputStream(new FileOutputStream(fileName));

            for (treeNumber = 0; treeNumber < forest.trees.length; treeNumber++) {
                if (forest.trees[treeNumber] != null) {
                    treeFile.writeObject(forest.trees[treeNumber]);
                }
            }
        } catch (IOException e) {
            System.out.println("ERROR: Saving trees: " + e.getMessage());
            return(false);
        } finally {
            try {
                if (treeFile != null) {
                    treeFile.close();
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
                return(false);
            }
        }
        return(true);
    }
//method to load the tree file
 public static boolean loadTreeFile(String fileName) {

	        ObjectInputStream treeFile = null;
	        Tree nextTree;
	        int numTrees;
	        Forest f = new Forest();
	        f.setForestName(fileName);
	        numTrees = 0;
	        
	        try {
	            treeFile = new ObjectInputStream(new FileInputStream(fileName));
	            nextTree = (Tree)treeFile.readObject();
	            while (nextTree != null) {
	                f.trees[numTrees] = nextTree;
	                numTrees++;
	                nextTree = (Tree)treeFile.readObject();
	            }
	        } catch (EOFException e) {
	        } catch (IOException e) {
	            System.out.println("ERROR: Loading trees: " + e.getMessage());
	            return(false);
	        } catch (ClassNotFoundException e) {
	            System.out.println(e.getMessage());
	            return(false);
	        } finally {
	            System.out.println(numTrees + " trees read from " + fileName);
	            try {
	                if (treeFile != null) {
	                    treeFile.close();
	                }
	            } catch (IOException e) {
	                System.out.println("ERROR: Closing file: " + e.getMessage());
	                return(false);
	            }
	        }
	        forest = f;
	        return(true);
	    }
}
