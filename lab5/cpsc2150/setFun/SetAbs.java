package cpsc2150.setFun;

public abstract class SetAbs<T> implements ISet<T>  {

    /**
     * toString function that converts the set to a readable string
     * @return - returns a readable string representing the set
     */
    public String toString(){
        String printMe = "";
        T arrSet;
        for(int i = 0; i < this.getSize(); i++){
            arrSet = this.removePos(0);
            if(arrSet != null) {
                printMe += arrSet;
                printMe += ", ";
                this.add(arrSet);
            }
            arrSet = null;
        }
        return printMe;
    }

    /**
     * equals method to compare two sets
     * @param o - object called in for comparison
     * @return - returns true if the sets are equal and false if not
     */
    public boolean equals(Object o) {
        boolean flag = true;

        if (o instanceof ISet) {
            ISet<T> temp = (ISet<T>) o;
            //if the sizes aren't equal the sets can't be equal
            if (this.getSize() != temp.getSize()) {
                flag = false;
            } else {

                for (int i = 0; i < getSize(); i++) {
                    T holder = temp.removePos(0);
                    if (!this.contains(holder)) {
                        flag = false;
                    }

                }
            }
        }

        return (flag);
      }

    }
