import java.util.Hashtable;

public class Library extends Building {
    private Hashtable<String, Boolean> collection;
    int countBook;

    /**
     * Full constructor
     * @param name
     * @param address
     * @param nFloors
     */
    public Library(String name, String address, int nFloors) {
        super(name, address, nFloors);
        System.out.println("You have built a library: 📖");
        this.collection = new Hashtable<String, Boolean>();
    }

    /**
     * Adds a book to the libarary's collection
     * @param String title
     */
    public void addTitle(String title){ //look at making this private with removeTitle--- how I allow to enter many books
        System.out.println("-----------Adding " + title + "--------------");
        this.collection.put(title, true);
    }

    /**
     * Overloaded addTitle method to allow addding multiple books at once
     * @param t1
     * @param t2
     * @param t3
     * @param t4
     */
    public void addTitle(String t1, String t2, String t3, String t4){ //look at making this private with removeTitle
      System.out.println("------------------------------------------------");
      System.out.println("Adding " + t1 + ", " + t2 + ", " + t3 + ", and " + t4);
      this.collection.put(t1, true); //adds t to hashtable collection
      this.collection.put(t2, true); 
      this.collection.put(t3, true);
      this.collection.put(t4, true);
      System.out.println("----------------Books successfully added -----------");
  }

    /**
     * Removes book from library's collection
     * @param String title
     * @return String that indicates if the book has been removed or otherwise, if it's not present
     */
    public boolean removeTitle(String title){ //Modified removeTitle to return Boolean
      try {
      if (this.collection.get(title) == true){
        System.out.println("------------Removing " + title + "-------------");
        this.collection.remove(title);
        return true;
      }
      else{return false;}
    } catch (Exception RuntimeException) {
      System.out.println(title + " not in " + this.name); //Use throw instead
      return false;
    }
    }

    /**
     * @param t1
     * @param t2
     * @param t3
     * @param t4
     * @return String # number of books removed
     */
    public String removeTitle(String t1, String t2, String t3, String t4){
      if (removeTitle(t1)){countBook += 1;};
      if (removeTitle(t2)){countBook += 1;};
      if (removeTitle(t3)){countBook += 1;};
      if (removeTitle(t4)){countBook += 1;};
      System.out.println(countBook + " books removed!");
      return (countBook + " books removed!");
      
    
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
     * Overloads checkOut constructor to allow for checking out multiple books at once
     * @param t1
     * @param t2
     * @param t3
     * @param t4
     */
    public void checkOut(String t1, String t2, String t3, String t4){
      checkOut(t1); checkOut(t2); checkOut(t3); checkOut(t4);
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
     * Overloaded returnBook method to allow for returning multiple books at once
     * @param t1
     * @param t2
     * @param t3
     * @param t4
     */
    public void returnBook(String t1, String t2, String t3, String t4){
      returnBook(t1); returnBook(t2); returnBook(t3); returnBook(t4);
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
     * Overloaded checkOut method--- checks if multiple books are present in a library
     * @param t1
     * @param t2
     * @param t3
     * @param t4
     */
    public void containsTitle(String t1, String t2, String t3, String t4){
      containsTitle(t1); containsTitle(t2);  containsTitle(t3);  containsTitle(t4);
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

    public void showOptions() {
      System.out.println("Available options at " + this.name + ":\nreturnBook() \naddTitle() \ncheckOut() \nremoveTitle()\ncontainsTitle()");
  }

  
    public static void main(String[] args) {
        Library Neilson = new Library("Neilson", "Massachusetts", 5);
        Neilson.showOptions();
        Neilson.enter();
        Neilson.goToFloor(1);
        Neilson.addTitle("Golden Gulag", "Empower", "Inikori", "Good morning Holy Spirit");
       // Neilson.removeTitle("Golden Gulag", "Empower", "Inikori", "Good morning y Spirit");
        Neilson.containsTitle("Golden Gulag", "Empower", "Inikori", "Good morning Holy Spirit");
        
;
        // Neilson.addTitle("Golden Gulag by Rotkins");
        // Neilson.addTitle("Empower by Daniels");
        // //Neilson.checkOut("Golden Gulag by Rotkins");
        // Neilson.removeTitle("Golden Gulag by Rotkins"); // Need to "Sout" to see side effect
        // Neilson.containsTitle("Empower by Daniels");
        // Neilson.checkOut("Empower by Daniels");
        // Neilson.returnBook("Golden Gulag by Rotkins");
        // System.out.println(Neilson);

    }
  
  }
