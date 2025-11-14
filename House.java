import java.util.ArrayList;

public class House extends Building implements HouseRequirements{
  
  private ArrayList<Student> residents;
  private boolean hasDiningRoom;

  public House(String name, String address, int nFloors, boolean hasDiningRoom) {
    super(name, address, nFloors);
    this.residents = new ArrayList<Student>();
    this.hasDiningRoom = hasDiningRoom;
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

  public static void main(String[] args) {
    House h1 = new House("house1", "east", 3, false);
    Student s1 = new Student("lily", "324", 2029);
    Student s2 = new Student("Tom", "324", 2029);
    h1.moveIn(s1);
    System.out.println("nResidents: "+ h1.nResidents());
    System.out.println("Is Lily in the house: "+ h1.isResident(s1));
    System.out.println("Is Tom in the house: "+ h1.isResident(s2));
    h1.showOptions();
  }

}