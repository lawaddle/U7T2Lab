import java.util.ArrayList;
import java.util.Arrays;

public class RunnerButLikeAgainThough {
    public static void main(String[] args)
    {
// create an array with the known types
        Integer[] intsArray = {1, 2, 3, 4, 5};

// use the Arrays.asList utility method to convert the array to a list "inline"
        ArrayList<Integer> intList = new ArrayList<Integer>(Arrays.asList(intsArray));
        System.out.println(intList);

        Car beep = new Car("Bus" , 21541);
        Car vroom = new Car("Honda Civic 2005", 51561681);
        Car honk = new Car("Truck", 2);

        Car[] carPluralButArray = {beep, honk, vroom};
        ArrayList<Car>  carPluralButList = new ArrayList<Car>(Arrays.asList(carPluralButArray));
        System.out.println(carPluralButList);

        System.out.println();
        System.out.println(carPluralButList.get(0));
    }
}
