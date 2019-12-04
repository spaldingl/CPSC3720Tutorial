package cpsc2150.setFun;
import java.util.*;

/**
 * ArraySet class that creates a set with an array
 * @author Spalding Latham
 */
public class ArraySet implements ISet{

    Integer[] arrSet = new Integer[100];
    int counter = 0;

    /**
     * Default Constructor
     */
    ArraySet(){

    }


    public void add(Integer val){
        arrSet[counter] = val;
        counter++;
    }


    public Integer removePos(int pos){
        //store what will be removed
        Integer popped = arrSet[pos];
        //remove from set
        arrSet[pos] = null;
        //create a copy of the set to fix the order of the array
        Integer[] copy = new Integer[100];
        for(int i = 0; i < arrSet.length; i++){
            copy[i] = arrSet[i];
            arrSet[i] = null;
        }
        int j = 0;
        //copy all non-null values back into array
        for(int i = 0; i < copy.length; i++){
            if(copy[i] != null){
                arrSet[j] = copy[i];
                j++;
            }
        }


        return popped;
    }

    public boolean contains(Integer val){
        boolean flag = false;
        for(int i = 0; i < arrSet.length; i++){
            if(arrSet[i] == val){
                flag = true;
                //break if true
                break;
            }
        }

        return flag;
    }

    public int getSize(){
        //add up all non-null values
        int valCounter = 0;
        for(int i = 0; i < arrSet.length; i++){
            if(arrSet[i] != null){
                valCounter++;
            }
        }
        return valCounter;
    }

    public String toString(){
        String printMe = "";
        for(int i = 0; i < arrSet.length; i++){
            if(arrSet[i] != null) {
                printMe += (arrSet[i] + ", ");
            }
        }
        return printMe;
    }

}

