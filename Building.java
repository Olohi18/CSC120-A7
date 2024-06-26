public class Building {

    protected String name;
    protected String address;
    protected int nFloors;
    protected int activeFloor = -1; // Default value indicating we are not inside this building
    public boolean hasElevator;

    /* Default constructor */
    public Building() {
        this("<Name Unknown>", "<Address Unknown>", 1, false);
    }

    /**
     * Overloaded constructor with address only 
     * @param address
     */
    public Building(String address) {
        this(); // Call default constructor
        this.address = address; // Override address
    }

    /**
     * Overloaded constructor with name, address 
     * @param name
     * @param address
     */
    public Building(String name, String address) {
        this(name, address, 1, false); // Call full constructor with hard-coded # floors and automatically sets hasElevator option to false
    }

    /**
     * Full constructor 
     * @param name
     * @param address
     * @param nFloors
     */
    public Building(String name, String address, int nFloors, boolean hasElevator) {
        if (name != null) { this.name = name; }
        if (address != null) { this.address = address; } 
        if (nFloors < 1) {
            throw new RuntimeException("Cannot construct a building with fewer than 1 floor.");
        }
        this.nFloors = nFloors;
        this.hasElevator = hasElevator;
    }

    /**
     * Accessor for name attribute
     * @return name 
     */
    public String getName() {
        return this.name;
    }

    /**
     * Accessor for address attribute
     * @return address
     */
    public String getAddress() {
        return this.address;
    }


    /**
     * Accessor to get number of floors 
     * @return nFloors
     */
    public int getFloors() {
        return this.nFloors;
    }

    /* Navigation methods */

    
    /**
     * Allows an individual to enter a building if they aren't already in it
     * @return 
     */
    public Building enter() {
        if (activeFloor != -1) {
            throw new RuntimeException("You are already inside this Building.");
        }
        this.activeFloor = 1;
        System.out.println("You are now inside " + this.name + " on the ground floor.");
        return this; // Return a pointer to the current building
    }

    /**
     * Allows an individual to leave if they're alerady on the first floor
     * @return
     */
    public Building exit() {
        if (this.activeFloor == -1) {
            throw new RuntimeException("You are not inside this Building. Must call enter() before exit().");
        }
        if (this.activeFloor > 1) {
            throw new RuntimeException("You have fallen out a window from floor #" + this.activeFloor + "!");
        }
        System.out.println("You have left " + this.name + ".");
        this.activeFloor = -1; // We're leaving the building, so we no longer have a valid active floor
        return null; // We're outside now, so the building is null
    }

    /**
     * Allows to move between floors since there's always an elevator
     * @param floorNum
     */
    public void goToFloor(int floorNum) {
            if (this.activeFloor == -1) {
                throw new RuntimeException("You are not inside the Library. Must call enter() before navigating between floors.");
            }
            if (floorNum < 1 || floorNum > this.nFloors) {
                throw new RuntimeException("Invalid floor number. Valid range for this Building is 1-" + this.nFloors +".");
            }
            System.out.println("You are now on floor #" + floorNum + " of " + this.name);
            this.activeFloor = floorNum;}


    /**
     * Moves up an occupant by one floor
     */
    public void goUp() {
        this.goToFloor(this.activeFloor + 1);
    }


    /**
     * Moves down an occupant by one floor
     */
    public void goDown() {
        this.goToFloor(this.activeFloor - 1);
    }

    /**
     * Prints out the options functionalities offered by a building
     */
    public void showOptions() {
        System.out.println("Available options at " + this.name + ":\n + enter() \n + exit() \n + goUp() \n + goDown()\n + goToFloor(n)");
    }

    //Prints out information about a building
    public String toString() {
        return this.name + " is a " + this.nFloors + "-story building located at " + this.address + ".";
    }

    //Tests functionality of methods
    public static void main(String[] args) {
        System.out.println("------------------------------------");
        System.out.println("Test of Building constructor/methods");
        System.out.println("------------------------------------");
        
        Building fordHall = new Building("Ford Hall", "100 Green Street Northampton, MA 01063", 4, true);
        System.out.println(fordHall);
        fordHall.showOptions(); 

        System.out.println("-----------------------------------");
        System.out.println("Demonstrating enter/exit/navigation");
        System.out.println("-----------------------------------");
        fordHall.enter(); 
        fordHall.goUp();
        fordHall.goDown();
        fordHall.goToFloor(3);
        fordHall.goDown();
        fordHall.goDown();
        fordHall.exit();
        
        // Building ford = new Building("Parsons", "Green Street", 5);
        // System.out.println(ford);
        
    }

}
