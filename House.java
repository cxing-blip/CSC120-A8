import java.util.ArrayList;

public class House extends Building implements HouseRequirements{
  
  private ArrayList<Student> residents;
  private boolean hasDiningRoom;
  private boolean hasElevator;

  public House(String name, String address, int nFloors, boolean hasDiningRoom, boolean hasElevator) {
    super(name, address, nFloors);
    this.residents = new ArrayList<Student>();
    this.hasDiningRoom = hasDiningRoom;
    this.hasElevator = hasElevator;
    System.out.println("You have built a house: 🏠");
  }

  public House(String name, String address, int nFloors)
  {
    super(name, address, nFloors);
    this.residents = new ArrayList<Student>();
    this.hasDiningRoom = false;
    this.hasElevator = false;
    System.out.println("You have built a house: 🏠");
  }

  public boolean hasDiningRoom()
  {
    return this.hasDiningRoom;
  }

  public int nResidents()
  {
    return this.residents.size();
  }

  public void moveIn(Student s)
  {
    if(isResident(s)) {
      throw new RuntimeException("This resident is already in the house");
    } else {
      residents.add(s);
    }
  }

  public void moveIn(Student s, Student s2)
  {
    if(isResident(s)) {
      throw new RuntimeException("This resident is already in the house");
    } else {
      residents.add(s);
    }
    if(isResident(s2)) {
      throw new RuntimeException("This resident is already in the house");
    } else {
      residents.add(s2);
    }
  }

  public Student moveOut(Student s)
  {
    if(isResident(s)) {
      residents.remove(s);
      return s;
    } else {
      throw new RuntimeException("This resident is not in the house");
    }
  }  

  public boolean isResident(Student s)
  {
    if(residents.contains(s)){
      return true;
    } else{
      return false;
    }
  }

  public void showOptions() {
        System.out.println("Available options at " + this.name + ":\n + enter() \n + exit() \n + goUp() \n + goDown()\n + goToFloor(n)\n + hasDiningRoom()\n + nResidents()\n + moveIn(S)\n + moveOut(S)\n + isResident(S)");
  }

  public void goToFloor(int floorNum) {
        if (this.activeFloor == -1) {
            throw new RuntimeException("You are not inside this Building. Must call enter() before navigating between floors.");
        }
        if (floorNum < 1 || floorNum > this.nFloors) {
            throw new RuntimeException("Invalid floor number. Valid range for this Building is 1-" + this.nFloors +".");
        }
        if(!this.hasElevator && Math.abs(floorNum - activeFloor)>1) {
            throw new RuntimeException("This building does not have an elevator. You cannot move between non-adjacent floors in a single action");
        }
        System.out.println("You are now on floor #" + floorNum + " of " + this.name);
        this.activeFloor = floorNum;
    }

  public static void main(String[] args) {
    House h1 = new House("house1", "east", 3, false, false);
    Student s1 = new Student("lily", "324", 2029);
    Student s2 = new Student("Tom", "324", 2029);
    h1.moveIn(s1, s2);
    System.out.println("nResidents: "+ h1.nResidents());
    System.out.println("Is Lily in the house: "+ h1.isResident(s1));
    System.out.println("Is Tom in the house: "+ h1.isResident(s2));
    h1.showOptions();
    h1.enter();
    h1.goToFloor(2);
  }

}