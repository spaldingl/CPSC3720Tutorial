package cpsc2150.setFun;
import java.util.*;

/**
 * ListSet class that creates a set with a list
 * @author Spalding Latham
 */
public class ListSet implements ISet {

    List<Integer> listSet;

    /**
     * default constructor
     */
    ListSet(){
        //define listSet
        listSet = new ArrayList<Integer>();
    }

    public void add(Integer val){
        //use built in list add
        listSet.add(val);

    }

    public Integer removePos(int pos){
        int store = listSet.get(pos);
        //use built int list remove
        listSet.remove(listSet.get(pos));
        return store;
    }

    public boolean contains(Integer val){
        boolean flag = false;
        for(int i = 0; i < listSet.size(); i++){
            if(listSet.get(i) == val){
                flag = true;
                //break if true
                break;
            }
        }
        return flag;
    }

    public int getSize(){
        //use built in list size
        return(listSet.size());
    }

    public String toString(){
        String printMe = "";
        for(int i = 0; i < listSet.size(); i++){
            printMe += (listSet.get(i) + ", ");
        }
        return printMe;
    }

}
