import java.util.Scanner; //imports the scanner class

public class PakuriProgram {
    public static void main(String[] args){

        //creates the scanner object
        Scanner scnr = new Scanner(System.in);

        //variable to determine whether the program continues or not
        boolean program = true;

        //displays welcome message and prompts for user input
        System.out.println("Welcome to Pakudex: Tracker Extraordinaire!");
        System.out.print("Enter max capacity of the Pakudex: ");
        String size = scnr.next();
        boolean isNumber = true;

        //ensures the users input was an int
        for(int i = 0; i < size.length(); i++){
            if(size.charAt(i) > 47 && size.charAt(i) < 58){
                isNumber = true;
            }
            else{
                isNumber = false;
                break;
            }
        }

        while(!isNumber){
            System.out.println("Please enter a valid size.");
            System.out.print("Enter max capacity of the Pakudex: ");
            size = scnr.next();
            //ensures the users input was an int
            for(int i = 0; i < size.length(); i++){
                if(size.charAt(i) > 47 && size.charAt(i) < 58){
                    isNumber = true;
                }
                else{
                    isNumber = false;
                    break;
                }
            }
        }

        //calls the constructor of pakudex class by creating an instance of the class to initialize the array of objects
        //to the correct size
        System.out.println("The Pakudex can hold " + size + " species of Pakuri.");
        int numberSize = Integer.parseInt(size);
        Pakudex pakudexArray = new Pakudex(numberSize);

        //keeps track of the number of species added
        int numSpecies = 0;

        //while loop that runs the whole program
        while(program) {
            //prints out the menu and accepts user input
            System.out.println();
            System.out.println("Pakudex Main Menu");
            System.out.println("-----------------");
            System.out.println("1. List Pakuri");
            System.out.println("2. Show Pakuri");
            System.out.println("3. Add Pakuri");
            System.out.println("4. Evolve Pakuri");
            System.out.println("5. Sort Pakuri");
            System.out.println("6. Exit");
            System.out.println();
            System.out.print("What would you like to do? ");
            String userInput = scnr.next();
            boolean validSelection = true;

            //ensures the user input a valid selection
            if(userInput.length() > 1){
                validSelection = false;
            }
            else {
                if(Integer.parseInt(userInput) > 6 || Integer.parseInt(userInput) < 1){
                    validSelection = false;
                }
                else{
                    validSelection = true;
                }
            }

            while (!validSelection) {
                System.out.println("Unrecognized menu selection!");
                System.out.println();
                System.out.print("Pakudex Main Menu ");
                System.out.println("-----------------");
                System.out.println("1. List Pakuri");
                System.out.println("2. Show Pakuri");
                System.out.println("3. Add Pakuri");
                System.out.println("4. Evolve Pakuri");
                System.out.println("5. Sort Pakuri");
                System.out.println("6. Exit");
                System.out.println();
                System.out.print("What would you like to do? ");
                userInput = scnr.next();
                //ensures the user input a valid selection
                if(userInput.length() > 1){
                    validSelection = false;
                }
                else {
                    if(Integer.parseInt(userInput) > 6 || Integer.parseInt(userInput) < 1){
                        validSelection = false;
                    }
                    else{
                        validSelection = true;
                    }
                }
            }

            //user wants to list Pakuri (selects option 1)
            if (userInput.equals("1")) {
                //checks to see if any pakuri have been added yet
                int list = pakudexArray.getSize();
                //no species yet
                if (list == 0) {
                    System.out.println("No Pakuri in Pakudex yet!");
                }
                //prints out the list
                else {
                    String[] species = pakudexArray.getSpeciesArray();
                    int number = 1;
                    System.out.println("Pakuri In Pakudex:");
                    for (int i = 0; i < species.length; i++) {
                        System.out.println(number + ". " + species[i]);
                        number++;
                    }
                }
            }

            //user wants to show a specific Pakuri's info (selects option 2)
            if (userInput.equals("2")) {
                System.out.print("Enter the name of the species to display: ");
                String species = scnr.next();
                int[] info = pakudexArray.getStats(species);
                //species did not exist
                if (info == null) {
                    System.out.println("Error: No such Pakuri!");
                }
                //species did exist
                else {
                    System.out.println();
                    System.out.println("Species: " + species);
                    System.out.println("Attack: " + info[0]);
                    System.out.println("Defense: " + info[1]);
                    System.out.println("Speed: " + info[2]);
                }
            }

            //user wants to add a pakuri to the pakudex (selects option 3)
            if (userInput.equals("3")) {
                //Pakudex is full
                if(numSpecies == numberSize){
                    System.out.println("Error: Pakudex is full!");
                }
                else{
                    System.out.print("Enter the name of the species to add: ");
                    String addPakuri = scnr.next();
                    //variable to keep track if the pakuri was added successfully
                    boolean add = pakudexArray.addPakuri(addPakuri);
                    //there is a duplicate
                    if (!add) {
                        System.out.println("Error: Pakudex already contains this species!");
                    }
                    //successfully added
                    else{
                        System.out.println("Pakuri species " + addPakuri + " successfully added!");
                        numSpecies++;
                    }
                }
            }

            //user wants to evolve a species (selects option 4)
            if (userInput.equals("4")) {
                System.out.print("Enter the name of the species to evolve: ");
                String evolve = scnr.next();
                boolean xEvolve = pakudexArray.evolveSpecies(evolve);
                //evolve was not successful
                if (!xEvolve) {
                    System.out.println("Error: No such Pakuri!");
                }
                //evolve was successful
                else {
                    System.out.println(evolve + " has evolved!");
                }
            }

            //user wants to sort the Pakudex (selects option 5)
            if (userInput.equals("5")) {
                pakudexArray.sortPakuri();
                System.out.println("Pakuri have been sorted!");
            }

            //user wants to exit the program (selects option 6)
            if (userInput.equals("6")) {
                System.out.println("Thanks for using Pakudex! Bye!");
                program = false;
            }
        }
    }
}
