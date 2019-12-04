package cpsc2150.setFun;
import java.util.*;

/**
 * Main set interface that provides functions for the set
 * @author Spalding Latham
 */
public interface ISet {
    /**
     * add function that adds the inputted value to the set
     * @param val - user inputted value
     */
    void add(Integer val);

    /**
     * removePos function that removes the value at a certain position
     * @param pos - user inputted position
     * @precondition - pos must be between 0 and 99
     * @postconditon - removes the value at the inputted position
     * @return - returns the removed element
     */
    Integer removePos(int pos);

    /**
     * contains function that checks if the user inputted value is in the set
     * @param val - user inputted value
     * @precondition - value must be in the set
     * @postconditon - returns true if the value is in the set and false if not
     * @return - returns true if the value is in the set and false if not
     */
    boolean contains(Integer val);

    /**
     * getSize function that gets the size of the set
     * @return - returns the size of the set
     */
    int getSize();


}
