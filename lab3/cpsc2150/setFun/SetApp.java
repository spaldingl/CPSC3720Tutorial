package cpsc2150.setFun;
import java.util.*;

public class SetApp {
    public static void main(String [] args){
        //declare mySet of type Iset
        ISet mySet = new ArraySet();
        Scanner in = new Scanner(System.in);
        System.out.println("Enter 1 for an array implementation or 2 for a list implementation");

        int inputType = in.nextInt();
        //change mySet to type ArraySet
        if(inputType == 1){
            mySet = new ArraySet();
        }
        //change mySet to type ListSet
        if(inputType == 2){
            mySet = new ListSet();
        }

        int inputOp = 0;

        while(inputOp != 3) {
            System.out.println("1. Add a value to the set\n" +
                    "2. Remove a value from the set\n" +
                    "3. Exit");

            inputOp = in.nextInt();

            if (inputOp == 1) {
                //don't allow size to go over 100
                if (mySet.getSize() == 100){
                    System.out.println("Set can't have more than 100 values!");
                } else {
                    System.out.println("What value to add to set?");
                    int inputVal = in.nextInt();
                    //reprompt if already in the set
                    if(mySet.contains(inputVal)){
                        System.out.println("That value is already in the set");
                        System.out.println(mySet);
                    } else {
                        mySet.add(inputVal);
                        System.out.println(mySet);

                    }
                }
            }

            if(inputOp == 2){
                int inputPos = 0;
                //don't allow removal from empty set
                if(mySet.getSize() == 0){
                    System.out.println("Can't remove from an empty set!");
                } else {
                    boolean validPos = false;

                    while(validPos == false) {
                        System.out.println("What position should be removed from the set?");
                        inputPos = in.nextInt();
                        //don't allow invalid position
                        if (inputPos < 0) {
                            System.out.println("That's not a valid position");
                        } else {
                            validPos = true;
                        }
                    }

                    validPos = false;
                    int popped = mySet.removePos(inputPos);
                    System.out.println(mySet);

                }
            }

            if(inputOp == 3){
                System.exit(0);
            }
        }

    }
}
