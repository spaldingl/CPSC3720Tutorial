package cpsc2150.setFun;
import java.util.Scanner;

public class DoubleSetApp {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        ISet<Double> mySet1;
        ISet<Double> mySet2;

        int input = 0;
        boolean isDone = false;
        boolean validInput = false;

        while (isDone == false){
            //reset sets
            mySet1 = new ArraySet();
            mySet2 = new ArraySet();
            while (validInput == false) {
                System.out.println("Make a selection\n1. Find the Union of Two Sets\n2. Find the Intersection of Two Sets\n3. Find the Difference of Two Sets\n4. See if two sets are equal\n5. Exit");
                input = in.nextInt();
                if ((input > 0) && (input < 6)) {
                    if(input == 5){
                        System.exit(0);
                    }
                    validInput = true;
                }
            }

            validInput = false;
            //validate input
            while (validInput == false) {
                System.out.println("Make Set 1\nEnter 1 for an array implementation or 2 for a list implementation");
                int implementation = in.nextInt();
                if (implementation == 1 || implementation == 2) {
                    if (implementation == 2) {
                        //if list implementation convert myset1 to list
                        mySet1 = new ListSet();
                    }
                    validInput = true;
                }
            }
            //initialize addToSet
            String addToSet = "1";

            while (addToSet.charAt(0) != 'q') {
                System.out.println("Enter a value to add to the set. Enter q to stop adding to the set");
                addToSet = in.next();
                if (addToSet.charAt(0) != 'q') {
                    double addMe = Double.parseDouble(addToSet);
                    mySet1.add(addMe);
                }
            }

            //reset input validator
            validInput = false;
            while (validInput == false) {
                System.out.println("Make Set 2\nEnter 1 for an array implementation or 2 for a list implementation");
                int implementation = in.nextInt();
                if (implementation == 1 || implementation == 2) {
                    //if list implementation convert myset2 to list
                    if (implementation == 2) {
                        mySet2 = new ListSet();
                    }
                    validInput = true;
                }
            }

            validInput = false;
            addToSet = "1";
            while (addToSet.charAt(0) != 'q') {
                System.out.println("Enter a value to add to the set. Enter q to stop adding to the set");
                addToSet = in.next();
                if (addToSet.charAt(0) != 'q') {
                    double addMe = Double.parseDouble(addToSet);
                    mySet2.add(addMe);
                }
            }
            /*UNION*/
            if (input == 1) {
                System.out.println("Set 1 is :\n" + mySet1 + "\nSet 2 is: " + mySet2);
                mySet1.union(mySet2);
                System.out.println("The Union is:\n" + mySet1);


            }
            /*INTERSECTION*/
            if (input == 2) {
                System.out.println("Set 1 is :\n" + mySet1 + "\nSet 2 is: " + mySet2);
                mySet1.intersect(mySet2);
                System.out.println("The Intersection is:\n" + mySet1);

            }
            /*DIFFERENCE*/
            if (input == 3) {
                System.out.println("Set 1 is :\n" + mySet1 + "\nSet 2 is: " + mySet2);
                mySet1.difference(mySet2);
                System.out.println("The Difference is:\n" + mySet1);

            }

            /*EQUALS*/
            if(input == 4){
                System.out.println("Set 1 is :\n" + mySet1 + "\nSet 2 is: " + mySet2);
                boolean flag = mySet1.equals(mySet2);
                if(flag == true){
                    System.out.println("The sets are equal!");
                } else {
                    System.out.println("The sets are not equal!");
                }
            }

        }

    }
}
