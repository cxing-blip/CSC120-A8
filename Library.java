import java.util.Hashtable;

public class Library extends Building implements LibraryRequirements {

  private Hashtable<String, Boolean> collection;
  private boolean hasElevator;

    public Library(String name, String address, int nFloors, boolean hasElevator) {
      super(name, address, nFloors);
      this.collection = new Hashtable<String, Boolean>();
      this.hasElevator = hasElevator;
      System.out.println("You have built a library: 📖");
    }
  
    public void addTitle(String title)
    {
      if(this.collection.containsKey(title)) {
        throw new RuntimeException("This book is already in the library");
      } else {
        this.collection.put(title, true);
      }
    }

    public String removeTitle(String title)
    {
      if(!this.collection.containsKey(title)) {
        throw new RuntimeException("This book is not in the collection");
      } else if(!this.collection.get(title)) {
        throw new RuntimeException("This book is not returned yet");
      } else {
        this.collection.remove(title, true);
        return title;
      }
    }

    public void checkOut(String title)
    {
      if(!this.collection.containsKey(title)) {
        throw new RuntimeException("This book is not in the collection");
      } else if(!this.collection.get(title)) {
        throw new RuntimeException("This book is not returned yet");
      } else {
        this.collection.replace(title, true, false);
      }
    }

    public void returnBook(String title)
    {
      if(!this.collection.containsKey(title)) {
        throw new RuntimeException("This book is not in the collection");
      } else if(this.collection.get(title)) {
        throw new RuntimeException("This book is already returned");
      } else {
        this.collection.replace(title, false, true);
      }
    }

    public boolean containsTitle(String title)
    {
      if(this.collection.containsKey(title))
      {return true;}
      return false;
    }

    public boolean isAvailable(String title)
    {
      if(this.collection.get(title))
      {return true;}
      return false;
    }

    public void printCollection()
    {
      System.out.println(this.collection.toString());
    }

    public void showOptions() {
        System.out.println("Available options at " + this.name + ":\n + enter() \n + exit() \n + goUp() \n + goDown()\n + goToFloor(n)\n + addTitle(s)\n + removeTitle(s)\n + checkOut(s)\n + returnBook(s)\n + containsTitle(s)\n + isAvailable(s)\n + printCollection()");
    }

    public static void main(String[] args) {
      Library l1 = new Library("lib", "east", 4, true);
      l1.addTitle("book1");
      l1.addTitle("book2");
      l1.printCollection();
      l1.removeTitle("book1");
      l1.printCollection();
      l1.showOptions();
      l1.enter();
      l1.goToFloor(2);
    }
  
  }