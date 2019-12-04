package cpsc2150.setFun;
import java.util.*;

/**
 * @description Main set interface that provides functions for the set
 * @author Spalding Latham
 *
 * Defines: Set interface for ListSet and ArraySet
 * Constraints: None
 *
 * Initialization Ensures: Set with below functions is created
 */
public interface ISet<T> {

    /**
     * add function that adds the inputted value to the set
     * @param val - user inputted value
     */
    void add(T val);

    /**
     * removePos function that removes the value at a certain position
     * @param pos - user inputted position
     * @precondition - pos must be between 0 and 99
     * @postconditon - removes the value at the inputted position
     * @return - returns the removed element
     */
    T removePos(int pos);

    /**
     * contains function that checks if the user inputted value is in the set
     * @param val - user inputted value
     * @precondition - value must be in the set
     * @postconditon - returns true if the value is in the set and false if not
     * @return - returns true if the value is in the set and false if not
     */
    boolean contains(T val);

    /**
     * getSize function that gets the size of the set
     * @return - returns the size of the set
     */
    int getSize();

    /**
     * Changes the current set (this) to be the union of this and unionWith
     * @param unionWith - second set for comparison
     * @pre - sets are initialized
     * @post - changes values in mySet1 to the union of the sets
     */
    default void union(ISet unionWith){
        int size1 = this.getSize();
        int size2 = unionWith.getSize();

        for(int i = 0; i < size2; i++){
            T checkVal = (T) unionWith.removePos(0);
            for(int j = 0; j < size1; j++){
                if(!this.contains(checkVal)){
                    this.add(checkVal);
                }

            }
        }
    }

    /**
     * Changes the current set (this) to be the intersection of this and intWith
     * @param intWith - second set for comparison
     * @pre - sets are filled with data
     * @post - mySet1 will now be the intersection of the two sets
     */
    default void intersect(ISet intWith){
        int size1 = this.getSize();
        int counter = 0;
        int size2 = intWith.getSize();
        Object[] holder = new Object[100];
        //store intersection values in holder array
        for(int i = 0; i < size2; i++){
            //check at 0 every time because the removePos resizes array
            T checkVal = (T) intWith.removePos(0);
            //System.out.println("CHecking for " + checkVal);
                if((this.contains(checkVal) && (checkVal != null))){
                    System.out.print("Adding " + checkVal + " to holder spot " + counter);
                    holder[counter] = checkVal;
                    counter++;
                }
        }
        //clear mySet1
        for(int i = 0; i < size1; i++){
            this.removePos(0);

        }

        int holderSize = 0;
        //get holder size
        for(int i = 0; i < holder.length; i++){
            if(holder[i] != null){
                holderSize++;
            }
        }

        //transfer from holder array to mySet1
        for(int i = 0; i < holderSize; i++){
            if(holder[i] != null) {
                this.add((T) holder[i]);
            }
        }





    }

    /**
     * Changes the current set (this) to be the difference of this and diffWith
     * @param diffWith - second set for comparison
     * @pre - sets have data in them
     * @post - mySet1 will contain mySet1 - mySet2
     */
    default void difference(ISet diffWith){

        Object[] holder = new Object[100];
        int counter = 0;
        int size = this.getSize();

        for(int i = 0; i < size; i++){
            T check = this.removePos(0);
            if(!diffWith.contains(check)){
                holder[counter] = check;
                counter++;
            }
        }
        int holderSize = 0;
        for(int i = 0; i < holder.length; i++){
            if(holder[i] != null){
                holderSize++;
            }
        }

        for(int i = 0; i < holderSize; i++){
            this.add((T) holder[i]);
        }

    }


}




