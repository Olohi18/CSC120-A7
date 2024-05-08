import java.util.ArrayList;
//Overload moveIn and moveOut--- reasoning: should be able to add at least three at once; if less than 3, simply add individually using second constructor

public class House extends Building {
  private ArrayList<String> residents;
  private boolean hasDiningRoom;
  private boolean hasElevator;
  String removed; //Variable to add those removed successfully during massive removal

  /**
   * Constructor for house class
   * @param name
   * @param address
   * @param nFloors
   * @param hasDiningRoom
   * @param hasElevator
   */
  public House(String name, String address, int nFloors, boolean hasDiningRoom, boolean hasElevator) {
    super(name, address, nFloors, hasElevator);
    this.residents = new ArrayList<String>();
    this.hasDiningRoom = hasDiningRoom; // Is this right? What you mean by pass as a parameter?
    this.hasElevator = hasElevator;
    System.out.println("You have built a house: 🏠");
  }

  /**
   * Accessor for DiningRoom
   * @return boolean this.hasDiningRoom
   */
  public boolean hasDiningRoom(){
    return this.hasDiningRoom;
  }

  /**
   * Accessor for nResidents
   * @return boolean number of residents
   */
  public int nResidents(){
    return this.residents.size();
  }

  /**
   * Adds a resident to a house
   * @param name
   */
  public void moveIn(String name){
    if (!(isResident(name))){
    System.out.println("Adding " + name);
    this.residents.add(name);
    System.out.println("............" + name + " added............");}
    else{
      System.out.println(name + " already lives in " + this.name);
    }
  }

  /**
   * Overloaded moveIn constructor to move in more individuals at once
   * @param n1
   * @param n2
   * @param n3
   * @param n4
   * @param n5
   */

  public void moveIn(String n1, String n2, String n3){ //add a list instead
    System.out.println("------------------------------------------------");
    moveIn(n1);
    moveIn(n2);
    moveIn(n3);
  }

  /**
   * Removes a resident from a house
   * @param name
   * @return
   */
  public String moveOut(String name){
    if (isResident(name)){
      System.out.println("...........Moving out " + name + "...........");
      this.residents.remove(name);
      return (name + " removed!");}
    else{
      return (name + " doesn't live in this house");}
    }

 /**
   * Removes three residents from house at once
   * @param name
   * @return
   */
  public String moveOut(String n1, String n2, String n3){
    if (isResident(n1)){
      System.out.println("...........Moving out " + n1 + "...........");
      this.residents.remove(n1);
      removed += n1; //adds new individual to removed
    }
    else{
      System.out.println(n1 + " doesn't live in this house");
    }

    if (isResident(n2)){
      System.out.println("...........Moving out " + n2 + "...........");
      this.residents.remove(n2);
      removed += n2;
    }
    else{
      System.out.println(n2 + " doesn't live in this house");
    }  

    if (isResident(n3)){
      System.out.println("...........Moving out " + n3 + "...........");
      this.residents.remove(n3);
      removed += n3;
    }
    else{
      System.out.println(n3 + " doesn't live in this house");
    }
  
    return ("------------Removed " + removed);
  }

  /**
   * Checks if a house contains a resident
   * @param person
   * @return
   */
  public boolean isResident(String person){
    return this.residents.contains(person);
  }  


  /**
   * Prints out the residents in a house
   */
  public void printCollection(){
    String desc = super.toString();
    if (this.hasDiningRoom = true){
      desc += ". It has a dining room.";
    }
    if (this.hasElevator){
      desc += " It has an elevator.";
    }
    System.out.println(desc);
    System.out.println("---------------------------------------");
    if (!this.residents.isEmpty()){
    System.out.println("The residents of " + this.name + " are: ");
    for (String r:this.residents){
      System.out.println(r);}
    }
    else{System.out.println("There are no residents at " + this.name);}
  }
    /**
     * Shows the options/methods of a class--- functions a class can perform
     */
    public void showOptions() {
      super.showOptions();
      System.out.println("------------------------");
      System.out.println("Other available options at " + this.name + ":\nmoveIn() \nmoveOut() \nhasDiningRoom() \nhasElevator"); //hasDiningRoom sounds weird
      System.out.println("------------------------");
  }

  public void goToFloor(int floorNum) {
    if (this.hasElevator){
        if (this.activeFloor == -1) {
            throw new RuntimeException("You are not inside this Building. Must call enter() before navigating between floors.");
        }
        if (floorNum < 1 || floorNum > this.nFloors) {
            throw new RuntimeException("Invalid floor number. Valid range for this Building is 1-" + this.nFloors +".");
        }
        System.out.println("You are now on floor #" + floorNum + " of " + this.name);
        this.activeFloor = floorNum;}
    else{
    System.out.println("There are no elevators in " + this.name + ". Use the goUp(), goDown() methods instead.");
    }
}

    
  
// Main function for testing code's functionality
  public static void main(String[] args) {
    House parsons = new House("Northrop", "19 RoundHill Road", 3, true, false);
    // System.out.println(parsons.hasDiningRoom());
    // System.out.println(parsons.nResidents());
    parsons.moveIn("Olohi", "Oyale", "Agaba");
    parsons.moveOut("Olohi", "Oyale", "Agaba");
    parsons.enter();
    parsons.goToFloor(3);
    parsons.showOptions();

    // System.out.println(parsons);


    

  }

}
