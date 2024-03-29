import java.util.ArrayList;

public class House extends Building {
  private ArrayList<String> residents;
  private boolean hasDiningRoom;
  private boolean hasElevator;

  /**
   * Constructor for house class
   * @param name
   * @param address
   * @param nFloors
   * @param hasDiningRoom
   * @param hasElevator
   */
  public House(String name, String address, int nFloors, boolean hasDiningRoom, boolean hasElevator) {
    super(name, address, nFloors);
    this.residents = new ArrayList<String>();
    this.hasDiningRoom = hasDiningRoom; // Is this right? What you mean by pass as a parameter?
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
   * Removes a resident from a house
   * @param name
   * @return
   */
  public String moveOut(String name){
    if (isResident(name)){
      System.out.println("...........Removing " + name + "...........");
      this.residents.remove(name);
      return (name + " removed!");}
    else{
      return (name + " doesn't live in this house");}
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
    System.out.println("The residents of " + this.name + " are: ");
    for (String r:this.residents){
      System.out.println(r);}
    return("done!");

    }
    /**
     * Shows the options/methods of a class--- functions a class can perform
     */
    public void showOptions() {
      System.out.println("Available options at " + this.name + ":\nmoveIn() \nmoveOut() \nhasDiningRoom() \nhasElevator"); //hasDiningRoom sounds weird
  }
  
// Main function for testing code's functionality
  public static void main(String[] args) {
    House parsons = new House("Parsons", "19 RoundHill Road", 3, true, false);
    // System.out.println(parsons.hasDiningRoom());
    // System.out.println(parsons.nResidents());
    parsons.moveIn("Olohi");
    parsons.moveIn("Oyale");
    parsons.moveIn("Agaba");
    parsons.moveIn("x");
    parsons.moveOut("x");
    parsons.showOptions();

    System.out.println(parsons);


    

  }

}
