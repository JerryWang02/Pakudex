import java.util.Arrays;

public class Pakudex{

    //declares the pakudex array
    private Pakuri[] pakudexArray;

    //default constructor that sets the array size to 20
    public Pakudex() {
        pakudexArray = new Pakuri[20];
    }

    //constructor that initializes array with length of capacity
    public Pakudex(int capacity){
        pakudexArray = new Pakuri[capacity];
    }

    //returns the number of critters currently being stored in the Pakudex
    public int getSize(){
        int counter = 0;
        for(int i = 0; i < pakudexArray.length; i++){
            if(pakudexArray[i] != null){
                counter++;
            }
        }
        return counter;
    }

    //returns the number of critters that the Pakudex has the capacity to hold at most
    public int getCapacity(){
        int counter = 0;
        for(int i = 0; i < pakudexArray.length; i++){
            if(pakudexArray[i] == null){
                counter++;
            }
        }
        return counter;
    }

    //returns a string array containing the species of the critters as ordered in the pakudex. Returns null if there
    //are no species added yet
    public String[] getSpeciesArray(){
        //checks to see if there has been any critters added yet
        if(getSize() == 0){
            return null;
        }
        else{
            //creates array of correct length
            String [] species = new String[getSize()];
            //fills the new array with the species names in order which they appear in the original array
            for(int i = 0; i < species.length; i++){
                species[i] = pakudexArray[i].getSpecies();
            }
            return species;
        }
    }

    //returns an int array containing the attack, defense, and speed statistics of species. Returns null if species
    //is not in the pakudex
    public int[] getStats(String species){
        int counter = 0;
        int test = 0;
        for(int i = 0; i < getSize(); i++){
            //sees if the desired species exists within the array
            if(pakudexArray[i].getSpecies().equals(species)){
                counter++;
                test = i;
                break;
            }
        }
        //species was not found in the pakudex
        if(counter == 0){
            return null;
        }
        else{
            //creates the stats array
            int[] stats = new int[3];
            //fills in the data into the array
            stats[0] = pakudexArray[test].getAttack();
            stats[1] = pakudexArray[test].getDefense();
            stats[2] = pakudexArray[test].getSpeed();
            return stats;
        }
    }

    //sorts the Pakuri objects in this Pakudex according to Java standard lexicographically ordering of species name
    public void sortPakuri(){
        Arrays.sort(pakudexArray, 0, getSize());
    }

    //Adds species to the Pakudex; if successful, return true, and false if not
    public boolean addPakuri(String species){
        //checks if there are any duplicates
        int counter = 0;
        for(int i = 0; i < getSize(); i++){
            //sees if the desired species exists within the array
            if(pakudexArray[i].getSpecies().equals(species)){
                counter++;
            }
        }
        //makes sure that there is still space in the pakudex
        if(getCapacity() == 0){
            return false;
        }
        //duplicates present
        else if(counter > 0){
            return false;
        }
        //adds species to the pakudex
        else{
            for(int i = 0; i < pakudexArray.length; i++){
                //finds the first open spot and adds
                if(pakudexArray[i] == null){
                    pakudexArray[i] = new Pakuri(species);
                    break;
                }
            }
            return true;
        }
    }

    //attempts to evolve species within the Pakudex; if successful, return true, and false if not
    public boolean evolveSpecies(String species){
        int counter = 0;
        for(int i = 0; i < getSize(); i++){
            //sees if the desired species exists within the array
            if(pakudexArray[i].getSpecies().equals(species)){
                pakudexArray[i].evolve();
                counter++;
                break;
            }
        }
        //checks to see if a species was evolved
        if(counter == 1){
            return true;
        }
        else{
            return false;
        }
    }
}
