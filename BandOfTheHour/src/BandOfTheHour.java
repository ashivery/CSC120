import java.util.Scanner;
//-----------------------------------------------------------------------------
public class BandOfTheHour{
//-----------------------------------------------------------------------------
    private static Scanner keyboard = new Scanner(System.in);
    private static final int MAX_ENTRY = 10;
    private static final int MAX_POSITION = 8;
//-----------------------------------------------------------------------------
    public static void main(String[] args) {
    	double[][] seatAssign;
    	char letters;

    	System.out.println( "Welcome to the Band of the Hour");
    	System.out.println( "-------------------------------");
    	seatAssign = inputRows();
    	menu();

// Create Switch Statements w/ separate methods, KEEP ORGANIZED
    while(true){
      letters = Character.toUpperCase(keyboard.next().charAt(0));
      
      switch(letters) {
         case 'A' :
          addMusician(seatAssign);
          menu();
          break;

        case 'R':
          removeMusician(seatAssign);
          menu();
          break;

        case 'P':
          rowPrint(seatAssign);
          menu();
          break;

        case 'X':
          return;

        default:
          System.out.print("ERROR: Invalid option, try again              : ");
      }
    }
}

// Void Method to input the print menu for Adding, Removing, and exiting
private static void menu() {
    System.out.println();
    System.out.print( "(A)dd, (R)emove, (P)rint,              e(X)it : "); 
  }

// Make Void Method to add a musician
private static void addMusician(double[][] seatAssign) {
    int rowLetter, rowSeat;
    double musicianWeight = 0.0;
    double sum;
    
    System.out.print("Please enter row letter                       : ");
    rowLetter = (int)(Character.toUpperCase(keyboard.next().charAt(0))) - (int) 'A';
    
    while (rowLetter > MAX_ENTRY || rowLetter < 0){
      System.out.print("ERROR: Out of range, try again                : ");
      rowLetter = (int)(Character.toUpperCase(keyboard.next().charAt(0))) - (int) 'A';
    }

    System.out.print("Please enter position number (1 to " + seatAssign[rowLetter].length + ")         : ");
    rowSeat = keyboard.nextInt();
    rowSeat -= 1;
    
    while (rowSeat > seatAssign[rowLetter].length || rowSeat < 0){
      System.out.print("ERROR: Out of range, try again                : ");
      rowSeat = keyboard.nextInt();
      rowSeat -= 1;
    }
    if(seatAssign[rowLetter][rowSeat] > 0){
      System.out.print("ERROR: There is already a musician there.");
      System.out.println();
      return;
    }

    System.out.print("Please enter weight (45.0 to 200.0)           : ");
    musicianWeight = keyboard.nextDouble();

    while (musicianWeight < 45 || musicianWeight > 200) {
      System.out.print("ERROR: Out of range, try again                : ");
      musicianWeight = keyboard.nextDouble();
    }

    sum = addingRows(seatAssign[rowLetter], musicianWeight);

    if(sum > 100 * (seatAssign[rowLetter].length + 1)) {
      System.out.print("ERROR: That would exceed the average weight limit.");
      System.out.println();
      return;
    }

    seatAssign[rowLetter][rowSeat] = (int) musicianWeight;
    
    System.out.println("****** Musician added.");
  }
  
// Make void method to remove a musician
private static void removeMusician(double[][] seatAssign)  {
    int rowSeatPos, rowLetter;

    System.out.print("Please enter row letter                       : ");
    rowLetter = (int) (Character.toUpperCase(keyboard.next().charAt(0))) - (int) 'A';

    while (rowLetter > MAX_ENTRY || rowLetter < 0){
      System.out.print("Error: Out of range, try again : ");
      rowLetter = (int)(Character.toUpperCase(keyboard.next().charAt(0))) - (int) 'A';
    }
    
    System.out.print("Please enter position number (1 to " + seatAssign[rowLetter].length + ")         : ");
    rowSeatPos = keyboard.nextInt();
    rowSeatPos -= 1;
    
    while (rowSeatPos > seatAssign[rowLetter].length || rowSeatPos < 0){
      System.out.print("Error: Out of range, try again : ");
      rowSeatPos = keyboard.nextInt();
      rowSeatPos -= 1;
    }

    if(seatAssign[rowLetter][rowSeatPos] == 0){
      System.out.print("ERROR: That position is vacant.");
      System.out.println();
      return;
    }
    
    seatAssign[rowLetter][rowSeatPos] = (int) 0.0;
    System.out.print("****** Musician removed.");
    System.out.println();
  }
  
// Make Method to input the rows
private static double[][] inputRows() {
	  int numRows = 0;
	  int numPeople, i, j;
	  double[][] seatAssign;
	
    System.out.print("Please enter number of rows                   : ");
    numRows =  keyboard.nextInt();
    
    while (numRows > MAX_ENTRY || numRows < 0){
      System.out.print("ERROR: Out of range, try again                : ");
      numRows =  keyboard.nextInt();
    }
    seatAssign = new double [numRows][];  

    for (i = 0; i < seatAssign.length; i++) {
      System.out.print("Please enter the number of positions in row " + (char)(i + (char) 'A') + " : ");
      numPeople = keyboard.nextInt();
      
      while (numPeople > MAX_POSITION || numPeople < 0){
        System.out.print("ERROR: Out of range, try again                : ");
        numPeople =  keyboard.nextInt();
      }
      seatAssign[i]= new double [numPeople];
      for (j = 0; j < numPeople; j++)
        seatAssign[i][j]= 0;
    }
	return seatAssign;
  }
  
// Make void Method to print out the row, sum, and average
private static void rowPrint(double[][] seatAssign) {
	  double sum;
	  for (int i = 0; i < seatAssign.length; i++) {
		System.out.printf("%c: ", (char)((int)'A' + i));
	  	
		
		for (int j = 0; j < seatAssign[i].length; j++) {
			System.out.printf("%5.1f ", seatAssign[i][j]);
	  	}
		for (int j = 0; j < MAX_POSITION - seatAssign[i].length; j++ ) {
			System.out.print("      ");
		}
		sum = 0.0;
		sum = addingRows(seatAssign[i], sum);
	  	System.out.printf("[ %6.1f, %6.1f]\n", sum, sum/(double)(seatAssign[i].length));
	  }
  }
  
// Make Method to calculate sum of the row
private static double addingRows(double[] seatAssign, double sum){
    for(int i = 0; i < seatAssign.length; i++){
      sum += seatAssign[i];
    }
    return sum;
  }
// Ending Bracket
}