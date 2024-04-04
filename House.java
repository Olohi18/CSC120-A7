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
    System.out.println("Adding " + name);
    this.residents.add(name);
    System.out.println("............" + name + " added.............");
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
    System.out.println("Moving in " + n1 + ", " + n2 + " ," + n3);
    this.residents.add(n1);
    this.residents.add(n2); 
    this.residents.add(n3);
    System.out.println("----------------Successfully moved in -----------");
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
      return (n1 + " doesn't live in this house");
    }

    if (isResident(n2)){
      System.out.println("...........Moving out " + n2 + "...........");
      this.residents.remove(n2);
      removed += n2;
    }
    else{
      return (n2 + " doesn't live in this house");
    }  

    if (isResident(n3)){
      System.out.println("...........Moving out " + n3 + "...........");
      this.residents.remove(n3);
      removed += n3;
    }
    else{
      return (n3 + " doesn't live in this house");
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
  public String toString(){
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
    return("\n");

    }
    else{return("There are no residents at " + this.name);}
  }
    /**
     * Shows the options/methods of a class--- functions a class can perform
     */
    public void showOptions() {
      System.out.println("Available options at " + this.name + ":\nenter() \nexit() \ngoUp() \ngoDown()\ngoToFloor(n) \nmoveIn() \nmoveOut() \nhasDiningRoom() \nhasElevator"); //hasDiningRoom sounds weird
  }

    
  
// Main function for testing code's functionality
  public static void main(String[] args) {
    House parsons = new House("Northrop", "19 RoundHill Road", 3, true, true);
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
