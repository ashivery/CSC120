import java.util.Scanner;
//=============================================================================
public class UseFamily {
//-----------------------------------------------------------------------------
    private static Scanner keyboard = new Scanner(System.in);

    private static final String SENTINEL = "STOP";
//-----------------------------------------------------------------------------
    public static void main(String[] args) {

        Family myFamily = new Family();
        String name;
        int age;

//----Get family information
        do {
            System.out.print("Enter name of next person : ");
            name = keyboard.nextLine();
            if (!name.equalsIgnoreCase(SENTINEL)) {
                System.out.print("How old is that person    : ");
                age = keyboard.nextInt();
                keyboard.nextLine();
                if (!myFamily.addPerson(name,age)) {
                    System.out.println("ERROR: Cannot add person");
                    name = SENTINEL;
                }
            } 
        } while (!name.equalsIgnoreCase(SENTINEL));

//----Print family information
        System.out.println("There are " + myFamily.getNumberOfPeople() +
" people in the family, with a total age of " + myFamily.getTotalAge());
        myFamily.display();

//----Let one person have a birthday
        System.out.print("Whos birthday is it?      : ");
        name = keyboard.nextLine();
        myFamily.birthday(name);

//----Print family information
        System.out.println("There are " + myFamily.getNumberOfPeople() +
" people in the family, with a total age of " + myFamily.getTotalAge());
        myFamily.display();
    }
//-----------------------------------------------------------------------------
}
//=============================================================================