package learncollections;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;


/*
Set Properties:
1. Does not allow duplicate entries

 */

public class LearnSet {

	public static void main(String[] args) {
        //Set<String> mySet = new HashSet<String>();  // HashSet does not maintain any ordering of input values
        //Set<String> mySet = new LinkedHashSet<String>(); // LinkedHashSet maintains the order of insertion in set
        Set<String> mySet = new TreeSet<String>();    // Sorts set entries in natural order


        // 0. Check is set is empty
        System.out.println("-------------");
        System.out.println("Is set empty when not added anything = "+ mySet.isEmpty());

        mySet.add("ThirtyTwo"); //32
        mySet.add("TwentyTwo"); //22
        mySet.add("Twelve"); //12
        mySet.add("Two"); // 2

        System.out.println("is set Empty after adding = " + mySet.isEmpty());

        System.out.println(mySet);

        //1.  Does not allow duplicate entries
        System.out.println("--------------");
        mySet.add("ThirtyTwo");
        System.out.println(mySet);

        // 2. Iterating over Set
        System.out.println("-------------------");
        for(String val:mySet) {
            System.out.println(val);
        }

        // 3. Check if set contains an element
        System.out.println("-----------------------");
        System.out.println(mySet.contains("ThirtyTwo"));
        System.out.println(mySet.contains("Six"));


        // 4. Set Union
        System.out.println("-------------------");
        Set<String> mySet2 = new TreeSet<String>();
        mySet2.add("ThirtyTwo");
        mySet2.add("TwentyTwo");
        mySet2.add("Nine");
        mySet2.add("Eight");

        // create copy of mySet
        Set<String> intersection = new HashSet<String>(mySet);
        System.out.println(intersection);

        intersection.retainAll(mySet2);
        System.out.println(intersection);

        // Set Difference
        System.out.println("--------------------");
        Set<String> difference  = new HashSet<String>(mySet);
        System.out.println(difference);
        difference.removeAll(mySet2);
        System.out.println(difference);


		
	}

}
