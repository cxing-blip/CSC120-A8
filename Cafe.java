/* This is a stub for the Cafe class */
public class Cafe extends Building implements CafeRequirements{

    private int nCoffeeOunces; // The number of ounces of coffee remaining in inventory
    private int nSugarPackets; // The number of sugar packets remaining in inventory
    private int nCreams; // The number of "splashes" of cream remaining in inventory
    private int nCups; // The number of cups remaining in inventory
    private boolean hasElevator;

    public Cafe(String name, String address, int nFloors, int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups, boolean hasElevator) {
        super(name, address, nFloors);
        this.nCoffeeOunces = nCoffeeOunces;
        this.nSugarPackets = nSugarPackets;
        this.nCreams = nCreams;
        this.nCups = nCups;
        this.hasElevator = hasElevator;
        System.out.println("You have built a cafe: ☕");
    }

    public Cafe(String name, String address, int nFloors, int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups) {
        super(name, address, nFloors);
        this.nCoffeeOunces = nCoffeeOunces;
        this.nSugarPackets = nSugarPackets;
        this.nCreams = nCreams;
        this.nCups = nCups;
        this.hasElevator = false;
        System.out.println("You have built a cafe: ☕");
    }

    public Cafe(String name, String address, int nFloors, boolean hasElevator) {
        super(name, address, nFloors);
        this.nCoffeeOunces = 0;
        this.nSugarPackets = 0;
        this.nCreams = 0;
        this.nCups = 0;
        this.hasElevator = hasElevator;
        System.out.println("You have built a cafe: ☕");
    }

    public void sellCoffee(int size, int nSugarPackets, int nCreams)
    {
        if(size<0 || nSugarPackets<0 || nCreams<0)
        {
            throw new RuntimeException("You entered a negative value, which is not valid");
        }
        this.nCoffeeOunces -= size;
        this.nSugarPackets -= nSugarPackets;
        this.nCreams -= nCreams;
        this.nCups -= 1;
    }

    private void restock(int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups)
    {
        this.nCoffeeOunces += nCoffeeOunces;
        this.nSugarPackets += nSugarPackets;
        this.nCreams += nCreams;
        this.nCups += nCups;
    }

    public void showOptions() {
        System.out.println("Available options at " + this.name + ":\n + enter() \n + exit() \n + goUp() \n + goDown()\n + goToFloor(n)\n + sellCoffee(n1, n2, n3)\n + restock(n1, n2, n3)");
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
        Cafe c1 = new Cafe("cafe1", "east", 4, 3,4,5,6, true);
        c1.sellCoffee(1, 0, 0);
        c1.restock(1,1,1,1);
        c1.showOptions();
        c1.enter();
        c1.goToFloor(3);
    }
    
}
