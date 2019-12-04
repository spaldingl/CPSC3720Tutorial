package cpsc2150.setFun;
import java.util.*;

/**
 * ListSet class that creates a set with a list
 * @inv - SetSize <= 100
 * @author Spalding Latham
 */
public class ListSet<T> extends SetAbs<T> implements ISet<T> {

    List<T> listSet;

    /**
     * default constructor
     */
    ListSet(){
        //define listSet
        listSet = new ArrayList<T>();
    }

    public void add(T val){
        //use built in list add
        if(!this.contains(val)) {
            listSet.add(val);
        }
    }

    public T removePos(int pos){
        T store = listSet.get(pos);
        //use built int list remove
        listSet.remove(listSet.get(pos));
        return store;
    }

    public boolean contains(T val){
       /* boolean flag = false;
        for(int i = 0; i < listSet.size(); i++){
            if(listSet.get(i) == val){
                flag = true;
                //break if true
                break;
            }
        }*/
        return listSet.contains(val);
    }

    public int getSize(){
        //use built in list size
        return(listSet.size());
    }


}
