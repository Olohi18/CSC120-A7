public class Cafe extends Building{
    private int nCoffeeOunces;
    private int nSugarPackets;
    private int nCreams;
    private int nCups;

    /**
     * Overloaded constructor for cafe--- sets amount of ingredients available to default values
     * @param name
     * @param address
     */
    public Cafe(String name,String address) {
        this(name, address, 1, 50, 50, 50, 50);
        System.out.println("You have built a cafe: ☕");
    }
    
    /**
     * Full constructor for Cafe class
     * @param name
     * @param address
     * @param nFloors
     * @param nCoffeeOunces
     * @param nSugarPackets
     * @param nCreams
     * @param nCups
     */
    public Cafe(String name,String address, int nFloors, int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups) {
        super(name, address, nFloors, false);
        //System.out.println("You have built a cafe: ☕");
        this.nCoffeeOunces = nCoffeeOunces;
        this.nSugarPackets = nSugarPackets;
        this.nCreams = nCreams;
        this.nCups = nCups;
    }

    
    /**
     * Full sellCoffee method: decreases the items in inventory by amount of each material needed to make requested coffee
     * @param size
     * @param nSugarPackets 
     * @param nCreams
     */
    public void sellCoffee(int size, int nSugarPackets, int nCreams){
        if (this.nCoffeeOunces < size | this.nSugarPackets < nSugarPackets | this.nCreams < nCreams | this.nCups < 1){ //checks if materials in invenory are sufficient to make the given amount of coffee
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
    
    
    /**
     * sellCoffee non-Sugar method
     * @param size
     * @param nCreams
     */
    public void sellCoffee(int size, int nCreams){
        sellCoffee(size, 0,  nCreams); //Calls the sellCoffee full method
        
    }
    /**
     * Default restock method: Restocks the cafe's inventory
     * @param nCoffeeOunces
     * @param nSugarPackets
     * @param nCreams
     * @param nCups
     */
    private void restock(){
        restock(50, 50, 50);
    }

    /**
     * Full restock method
     * @param size
     * @param nCreams
     * @param nSugarPackets
     */
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
        System.out.println("\nCafe restocked!");

    }

    /**
     * Overrides goToFloor in Building-- Cafe doesn't need it
     * @param floorNum
     */
    public void goToFloor(int floorNum) {
        throw new RuntimeException("No elevators in a Cafe! It has just one floor");
    }

    /**
     * Prints the cafe's inventory
     */
    public String toString(){
        System.out.println();
        return (this.name + " has " + this.nCoffeeOunces + " ounces of coffee, " + this.nSugarPackets + " packs of sugar, " + this.nCreams + " splashes of cream, and " + this.nCups + " cups.");
    }

    /**
     * Prints the functionalities of the Cafe class
     */
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
       // neilson.goToFloor(1);
        //cc.showOptions(); neilson.showOptions(); 
        System.out.println(cc); System.out.println(neilson);
        cc.sellCoffee(16, 30, 2); cc.sellCoffee(6, 30, 2); cc.sellCoffee(6, 2); 
        System.out.println(cc); System.out.println(neilson);
        neilson.restock();
        System.out.println(neilson);
        System.out.println(neilson.getClass());
        
  

    }
    
}
