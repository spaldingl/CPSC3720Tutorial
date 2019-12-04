package cpsc2150.setFun;
import java.util.*;

/**
 * ArraySet class that creates a set with an array
 * @inv - SetSize <= 100
 * @author Spalding Latham
 */
public class ArraySet<T> extends SetAbs<T> implements ISet<T>{

    Object[] arrSet = new Object[100];

    /**
     * Default Constructor
     */
    ArraySet(){

    }


    public void add(T val){

        //find where the next empty spot is
        int counter = 0;
        for(int i = 0; i < arrSet.length; i++){
            if(arrSet[i] != null){
                counter++;
            }
        }
        //if not in the set then add it to next empty spot
        if(!this.contains(val)) {
            arrSet[counter] = val;
        }
    }


    public T removePos(int pos){
        //store what will be removed
        T popped = (T) arrSet[pos];
        //remove from set
        arrSet[pos] = null;
        //create a copy of the set to fix the order of the array
        Object[] copy = new Object[100];
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
            if(j == 0){
                arrSet[j] = null;
            }
        }

        //System.out.print(popped);
        return popped;
    }

    public boolean contains(T val){
        boolean flag = false;
        for(int i = 0; i < arrSet.length; i++) {
            if (arrSet[i] != null) {
                if (arrSet[i].equals(val)) {
                    flag = true;
                    //break if true
                    break;
                }
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


}

