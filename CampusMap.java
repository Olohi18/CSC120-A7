import java.util.ArrayList;

public class CampusMap {

    ArrayList<Building> buildings;

    /* Default constructor, initializes empty ArrayList */
    public CampusMap() {
        buildings = new ArrayList<Building>();
    }

    /**
     * Adds a Building to the map
     * @param b the Building to add
     */
    public void addBuilding(Building b) {
        System.out.println("Adding building...");
        buildings.add(b);
        System.out.println("-->Successfully added " + b.getName() + " to the map.");
    }

    /**
     * Removes a Building from the map
     * @param b the Building to remove
     * @return the removed Building
     */
    public Building removeBuilding(Building b) {
        System.out.println("Removing building...");
        buildings.remove(b);
        System.out.println("-->Successfully removed " + b.getName() + " to the map.");
        return b;
    }

    public String toString() {
        String mapString = "DIRECTORY of BUILDINGS";

        for (int i = 0; i < this.buildings.size(); i ++) {
            mapString += "\n  " + (i+1) + ". "+ this.buildings.get(i).getName() + " (" + this.buildings.get(i).getAddress() + ")";
        }
        return mapString;
    }

    public static void main(String[] args) {
        CampusMap myMap = new CampusMap();
        myMap.addBuilding(new Building("Ford Hall", "100 Green Street Northampton, MA 01063", 4, true));
        myMap.addBuilding(new Building("Bass Hall", "4 Tyler Court Northampton, MA 01063", 4, true));
        myMap.addBuilding(new Building("Seelye Hall", "2 Seelye Dr, Northampton, MA 01063", 4, true));
        myMap.addBuilding(new Building("Ainsworth Gym", "102 College Lane, Northampton, MA 01063", 4, true));
        myMap.addBuilding(new Building("Sage Hall", "144 Green St, Northampton, MA 01063", 4, true));
        myMap.addBuilding(new Building("Helen Hills Chapel", "123 Elm Street, Northampton, MA 01063", 4, true));
        myMap.addBuilding(new Cafe("Campus Cafe", "Neilson Drive", 3, 5, 3, 3, 7));
        myMap.addBuilding(new Cafe("Compass Cafe", "Neilson Drive"));
        myMap.addBuilding(new House("Northrop", "19 RoundHill Road", 3, true, true));
        myMap.addBuilding(new House("Parsons House", "24 Henshaw Ave, Northampton, MA 01063", 4, true, true));
        myMap.addBuilding(new House("Parsons Annex", "19 Round Hill Road, Northampton, MA 01063", 4, true, false));
        myMap.addBuilding(new Library("Neilson", "100 Elm Street, Northampton, MA 01063", 4, true));
        System.out.println(myMap);
        
    }
    
}
