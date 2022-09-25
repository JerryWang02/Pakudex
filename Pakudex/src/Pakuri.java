public class Pakuri implements Comparable<Pakuri> {
    //establishes the objects attributes
    private String species;
    private int attack, defense, speed;

    //constructor for Pakuri class
    public Pakuri(String species){
        //sets the default values for the species
        this.species = species;
        this.attack = (species.length() * 7) + 9;
        this.defense = (species.length() * 5) + 17;
        this.speed = (species.length() * 6) + 13;
    }

    //getter method for species
    public String getSpecies(){
        return this.species;
    }

    //getter method for attack
    public int getAttack(){
        return this.attack;
    }

    //getter method for defense
    public int getDefense(){
        return this.defense;
    }

    //getter method for speed
    public int getSpeed(){
        return this.speed;
    }

    //mutator method for attack
    public void setAttack(int newAttack){
        this.attack = newAttack;
    }

    //evolves the critter by changing the stats
    public void evolve(){
        this.attack = this.attack * 2;
        this.defense = this.defense * 4;
        this.speed = this.speed * 3;
    }

    //used to sort species by name
    @Override
    public int compareTo(Pakuri o) {
        //sort the species by name
        return this.species.compareTo(o.species);
    }
}
