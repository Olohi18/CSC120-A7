
public class Cafe extends Building{
    private int nCoffeeOunces;
    private int nSugarPackets;
    private int nCreams;
    private int nCups;

    /**
     * Constructor for the cafe class
     * @param name
     * @param address
     * @param nFloors
     * @param nCoffeeOunces
     * @param nSugarPackets
     * @param nCreams
     * @param nCups
     */

    //Default constructor for Cafe class
    public Cafe(String name,String address) {
        super(name, address);
        //System.out.println("You have built a cafe: ☕");
        this.nFloors = 1;
        this.nCoffeeOunces = 50;
        this.nSugarPackets = 50;
        this.nCreams = 50;
        this.nCups = 50;
    }

    //Full construcotr for Cafe class
    public Cafe(String name,String address, int nFloors, int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups) {
        super(name, address, nFloors);
        //System.out.println("You have built a cafe: ☕");
        this.nCoffeeOunces = nCoffeeOunces;
        this.nSugarPackets = nSugarPackets;
        this.nCreams = nCreams;
        this.nCups = nCups;
    }

    
    /**
     * Decreases the items in inventory by amount of ingredients needed to make requested coffee
     * @param size
     * @param nSugarPackets //why won't it show error if I do not define it within a method
     * @param nCreams
     */
    //Full method for sellCoffee
    public void sellCoffee(int size, int nSugarPackets, int nCreams){
        if (this.nCoffeeOunces < size | this.nSugarPackets < nSugarPackets | this.nCreams < nCreams | this.nCups < 1){
            System.out.println("You need to restock. One of your items isn't enough to make the requested amount of coffee");
            this.restock(size, nSugarPackets, nCreams);
        }
        System.out.println("----------------Selling Coffee!-------------");
        this.nCoffeeOunces -= size;
        this.nSugarPackets -= nSugarPackets;
        this.nCreams -= nCreams;
        this.nCups -= 1;
        System.out.println("Coffee sold!");
        }
    
    //Overloaded non-Sugar method for sellCoffee
    public void sellCoffee(int size, int nCreams){
        //checks if items contained in inventory is sufficient to make a cup of coffee
        if (this.nCoffeeOunces < size | this.nCreams < nCreams | this.nCups < 1){
            System.out.println("You need to restock. One of the items is out of stock");
            this.restock(size, nCreams); //Restocks items out of stock
        }
        System.out.println("----------------Selling Coffee!-------------");
        //Reduces the amount of each item in the inventory by the amount needed to make the coffee
        this.nCoffeeOunces -= size; this.nCreams -= nCreams; this.nCups -= 1; //this.nSugarPackets -=nSugarPackets;
        System.out.println("Coffee sold!");
    }
    
    /**
     * Restocks the cafe's inventory
     * @param nCoffeeOunces
     * @param nSugarPackets
     * @param nCreams
     * @param nCups
     */

    //Default restock method
    private void restock(){
        this.nCoffeeOunces = 50;
        this.nSugarPackets = 50;
        this.nCreams = 50;
        this.nCups = 50;
        System.out.println("\nCafe restocked! Proceeding to delivering requested amount of coffee");
    }

    //Overloaded non-sugar restock method
    private void restock(int size, int nCreams){
        if (this.nCoffeeOunces < size){
            this.nCoffeeOunces = 50;
            System.out.println("Coffee ounces now in stock");
        }
        if (this.nCreams < nCreams){
            this.nCreams = 50;
            System.out.println("Cream now in stock");
        }
        if (this.nCups < nCups){
            this.nCups = 20;
            System.out.println("Cups now in stock");
        }
        System.out.println("\nCafe restocked! Proceeding to delivering requested amount of coffee");
    }

    //Full restock method
    private void restock(int size, int nCreams, int nSugarPackets){
        if (this.nCoffeeOunces < size){
            this.nCoffeeOunces = 50;
            System.out.println("Coffee ounces now in stock");
        }
        if (this.nCreams < nCreams){
            this.nCreams = 50;
            System.out.println("Cream now in stock");
        }
        if (this.nSugarPackets < nSugarPackets){
            this.nSugarPackets = 50;
            System.out.println("Sugar packets now in stock");
        }
        if (this.nCups < nCups){
            this.nCups = 50;
            System.out.println("Cups now in stock");
        }
        System.out.println("\nCafe restocked! Proceeding to delivering requested amount of coffee");
    }

    /**
     * Prints the cafe's inventory
     */
    public String toString(){
        System.out.println();
        return (this.name + " has " + this.nCoffeeOunces + " ounces of coffee, " + this.nSugarPackets + " packs of sugar, " + this.nCreams + " splashes of cream, and " + this.nCups + " cups.");
    }
    
        public void showOptions() {
        System.out.println("------------------------");
        System.out.println("Available options at " + this.name + ":\nsellCoffee");
        System.out.println("------------------------");
    }

    // Main function to test Cafe class' functionality
    public static void main(String[] args) {
        //Make another constructor that just gives name and address
        Cafe cc = new Cafe("Campus Cafe", "Neilson Drive", 3, 5, 3, 3, 7);
        Cafe neilson = new Cafe("Compass Cafe", "Neilson Drive");
        cc.showOptions(); neilson.showOptions(); 
        System.out.println(cc); System.out.println(neilson);
        neilson.sellCoffee(6, 3, 2); cc.sellCoffee(6, 3, 2); cc.sellCoffee(6, 3, 2); 
        System.out.println(cc); System.out.println(neilson);
        
  

    }
    
}
