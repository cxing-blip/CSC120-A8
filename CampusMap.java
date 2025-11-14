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
        myMap.addBuilding(new Building("Ford Hall", "100 Green Street Northampton, MA 01063", 4));
        myMap.addBuilding(new Building("Bass Hall", "4 Tyler Court Northampton, MA 01063", 4));
        System.out.println(myMap);

        Library Neilson = new Library("Neilson", "7 Neilson Drive, Northampton, MA 01063", 4, true);
        Library Hillyer = new Library("Hillyer", "22 Elm St, Northampton, MA 01063", 2);
        House Morris = new House("Morris", "101 Green St, Northampton, MA 01063", 4);
        House Lawrence = new House("Lawrence", "99 Green St, Northampton, MA 01060", 4);
        House Tyler = new House("Tyler", "164 Green St, Northampton, MA 01060", 4, true, false);
        House Gillett = new House("Gillett", "47 Elm St, Northampton, MA 01060", 5, true, true);
        Building McConnell = new Building("McConnell", "2 Tyler Ct, Northampton, MA 01060", 3);
        Building Burton = new Building("Burton", "46 College Ln, Northampton, MA 01063");
        Building Wright = new Building("5 Chapin Way, Northampton, MA 01063");
        Cafe CC = new Cafe("Campus Center Cafe", "Smith College Campus Center, 100 Elm St, Northampton, MA 01063", 1);
        Cafe Compass = new Cafe("Compass Cafe", "7 Elm St, Northampton, MA 01063", 100, 90, 80, 100);
        Cafe FakeCafe = new Cafe("A fake cafe made up to show method overload", "10 Elm St", 1, 50, 50, 50, 50);

        myMap.addBuilding(Neilson);
        myMap.addBuilding(Hillyer);
        myMap.addBuilding(Morris);
        myMap.addBuilding(Lawrence);
        myMap.addBuilding(Tyler);
        myMap.addBuilding(Gillett);
        myMap.addBuilding(McConnell);
        myMap.addBuilding(Burton);
        myMap.addBuilding(Wright);
        myMap.addBuilding(CC);
        myMap.addBuilding(Compass);
        myMap.addBuilding(FakeCafe);
        System.out.println("\n" + myMap);

        Student s1 = new Student("Lily", "991487754", 2029);
        Student s2 = new Student("Tom", "991472942", 2029);
        Student s3 = new Student("Cindy", "991469283", 2029);
        Morris.moveIn(s1);
        Morris.moveIn(s2, s3);
        System.out.println("Number of residents in Morris: "+ Morris.nResidents());
        System.out.println("Is Lily in Morris: "+ Morris.isResident(s1));
        System.out.println("Is Tom in Morris: "+ Morris.isResident(s2));
        System.out.println("Is Cindy in Morris: "+ Morris.isResident(s3));

        Neilson.addTitle("Pride and Prejudice");
        Neilson.addTitle("Gone with the Wind");
        Neilson.addTitle("Harry Potter");
        System.out.println("Is 'Gone with the Wind' in Neilson: " + Neilson.containsTitle("Gone with the Wind"));
        System.out.println("Is 'Pride and Prejudice' in Neilson: " + Neilson.containsTitle("Pride and Prejudice"));
        System.out.println("Is 'Harry Potter' in Neilson: " + Neilson.containsTitle("Harry Potter"));
        Neilson.checkOut("Pride and Prejudice");
        Neilson.checkOut("Gone with the Wind");
        Neilson.checkOut("Harry Potter");
        Neilson.returnBook("Pride and Prejudice", "Gone with the Wind");
        System.out.println("Is 'Gone with the Wind' available in Neilson: " + Neilson.isAvailable("Gone with the Wind"));
        System.out.println("Is 'Pride and Prejudice' available in Neilson: " + Neilson.isAvailable("Pride and Prejudice"));
        System.out.println("Is 'Harry Potter' available in Neilson: " + Neilson.isAvailable("Harry Potter"));
        Neilson.returnBook("Harry Potter");
        System.out.println("Is 'Harry Potter' available in Neilson: " + Neilson.isAvailable("Harry Potter"));

    }
    
}
