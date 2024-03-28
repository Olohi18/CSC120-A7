import java.util.Hashtable;

public class Library extends Building {
    private Hashtable<String, Boolean> collection;

    public Library(String name, String address, int nFloors) {
        super(name, address, nFloors);
        System.out.println("You have built a library: 📖");
        this.collection = new Hashtable<String, Boolean>();
    }

    /**
     * Adds a book to the libarary's collection
     * @param String title
     */
    public void addTitle(String title){
        System.out.println("-----------Adding " + title + "--------------");
        this.collection.put(title, true);
    }

    /**
     * Removes book from library's collection
     * @param String title
     * @return String that indicates if the book has been removed or otherwise, if it's not present
     */
    public String removeTitle(String title){
      if (this.collection.get(title) == true){
        System.out.println("------------Removing " + title + "-------------");
        this.collection.remove(title);
        return (title + " removed from library"); 
      }
      else{
        return(title + " not in library.");
      }
    }

    /**
     * Updates the value of the book's title if available in hashtable from true to false
     * @param String title
     */
    public void checkOut(String title){
      //System.out.println(this.collection.keySet());
      if (this.collection.containsKey(title)){
        if (this.collection.get(title) == true){
          System.out.println("Checking out " + title);
          this.collection.replace(title, true, false);
        
          System.out.println(title + " checked out of library");
        }
        else{
          System.out.println(title + " not available now");
        }
      }
      else{
        System.out.println(this.name + " does not have " + title);
      }
    }

    /**
     * Returns a book and updates its associated boolean in the library's hashtable to true
     * @param String title
     */
    public void returnBook(String title){
      if (this.collection.containsKey(title)){
        System.out.println("Checking in " + title);
        this.collection.replace(title, false, true);
        System.out.println(title + " returned to library");
      }
      else{
        System.out.println(title + " not in library.");
      }
    }

    /**
     * Checks if the library contains a specific book
     * @param String title
     * @return
     */
    public boolean containsTitle(String title){
      if (this.collection.containsKey(title)){
        System.out.println(title + " is available at " + this.name);
        return true;
      }
      else{
        System.out.println(title + " is not available at " + this.name);
        return false;
      }
    }


    /**
     * Prints out the books in the library
     * @return String library
     */
    public String toString(){
      this.collection.keys();
      System.out.println();
      String library = "The books at " + this.name + " are: ";
      for (String book : this.collection.keySet()){
        library += "\n" + book;
      }
      return library;
    }

  
    public static void main(String[] args) {
        Library Neilson = new Library("Neilson", "Massachusetts", 5);
        Neilson.addTitle("Golden Gulag by Rotkins");
        Neilson.addTitle("Empower by Daniels");
        //Neilson.checkOut("Golden Gulag by Rotkins");
        Neilson.removeTitle("Golden Gulag by Rotkins"); // Need to "Sout" to see side effect
        Neilson.containsTitle("Empower by Daniels");
        Neilson.checkOut("Empower by Daniels");
        Neilson.returnBook("Golden Gulag by Rotkins");
        System.out.println(Neilson);

    }
  
  }
