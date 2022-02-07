import java.util.ArrayList;

/**
 * This class represents a used car lot (a collection of cars that can be acquired or sold).
 *
 * @author Lawer Nyako
 */

public class UsedCarLot {

    /** ArrayList of cars (cars in the lot)*/
    private  ArrayList<Car> inventory;


    /**
     * Instantiates a UsedCarLot object.
     */
    public UsedCarLot()
    {
        inventory = new ArrayList<Car>();
    }

    /**
     * Returns the inventory of the car lot
     *
     * @return The cars in the lot as an array list
     */
    public ArrayList<Car> getInventory() {
        return inventory;
    }

    /**
     * Adds a new car to the inventory of the car lot
     *
     * @param newCar The new car being added to lot
     */
    public void addCar(Car newCar)
    {
        inventory.add(newCar);
    }

    /**
     * Returns whether the car swap was successful or not
     * <p>
     * If the number inputted for either car is lower than 0 or higher than or equal to the size of the inventory,
     * then the swap is unsuccessful and false is returned.
     * Otherwise, the swap would work and true is returned
     *
     * @param car1 The 1st car being swapped
     * @param car2 The 2nd car being swapped
     * @return If the car swap was successful or not
     */
    public boolean swap(int car1, int car2)
    {
        if((car1 < 0) || (car1 >= inventory.size()) || (car2 < 0) || (car2 >= inventory.size()) )
        {
            return  false;
        } else
        {
            Car temp = inventory.get(car1);
            inventory.set(car1 , inventory.get(car2));
            inventory.set(car2, temp);
            return true;
        }
    }

    /**
     *  Adds a Car to the inventory list at the index specified
     *  by indexToAdd; this method increases the size of inventory by 1
     * <p>
     *  PRECONDITION: 0 &lt;= indexToAdd &lt; inventory.size()
     * @param indexToAdd The index at which the car will be added
     * @param carToAdd The car being added to inventory
     */
    public void addCar(int indexToAdd, Car carToAdd)
    {
        inventory.add(indexToAdd, carToAdd);
    }

    /**
     * "sells" the Car located at indexOfCarToSell which
     * removes it from the inventory list and shifting the remaining
     * Cars in the inventory list to the left to fill in the gap;
     * this method reduces the size of inventory by 1
     * <p>
     * Returns the Car that is being "sold" (removed from lot)
     * <p>
     * PRECONDITION: indexOfCarToSell &lt; inventory.size()
     * @param indexOfCarToSell The index of the car that will be sold
     * @return Returns the Car that is being "sold" (was removed from lot)
     */
    public Car sellCarShift(int indexOfCarToSell)
    {
        return inventory.remove(indexOfCarToSell);
    }


    /**
     * "sells" the Car located at indexOfCarToSell,
     * but instead of removing it and shifting the inventory
     * list to the left, REPLACE the Car at indexOfCarToSell
     * with NULL, thus creating an "empty parking spot" on the lot;
     * this method does NOT reduce the size of inventory by 1
     * <p>
     * This method returns the Car that is being "sold" (replaced with null)
     * <p>
     * PRECONDITION: indexOfCarToSell &lt; inventory.size()
     * @param indexOfCarToSell The index of the car that will be sold
     * @return Returns the Car that is being "sold" (replaced with null)
     */
    public Car sellCarNoShift(int indexOfCarToSell)
    {
        Car sold;
        sold = inventory.get(indexOfCarToSell);
        inventory.set(indexOfCarToSell, null);
        return sold;
    }

    /* moves Car located at index indexOfCarToMove to index destinationIndex;
       if destinationIndex > indexOfCarToMove, moves the Car to the right in
       inventory; if destinationIndex < indexOfCarToMove, moves the
       Car to the left in the inventory. All other cars in the inventory
       should shift accordingly

       PRECONDITIONS: indexOfCarToMove < inventory.size()
                      destinationIndex < inventory.size()
     */

    /**
     * moves Car located at index indexOfCarToMove to index destinationIndex;
     * if destinationIndex > indexOfCarToMove, moves the Car to the right in
     * inventory; if destinationIndex &lt; indexOfCarToMove, moves the
     * Car to the left in the inventory. All other cars in the inventory
     * should shift accordingly
     * <p>
     * PRECONDITIONS: indexOfCarToMove &lt; inventory.size()
     *                destinationIndex &lt; inventory.size()
     *
     * @param indexOfCarToMove initial index of the car you want to move
     * @param destinationIndex the index of where you want the car to end up
     */
    public void moveCar(int indexOfCarToMove, int destinationIndex)
    {
        Car move = sellCarShift(indexOfCarToMove);
        inventory.add(destinationIndex, move);

    }

}
