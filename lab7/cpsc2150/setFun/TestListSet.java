package cpsc2150.setFun;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TestListSet {


    private ISet<Integer> MakeASet(){

        ISet<Integer> arr = new ListSet<Integer>();
        return arr;

    }

    @Test
    public void testAdd_val0(){
        Integer val = 0;
        ISet<Integer> set = MakeASet();
        set.add(val);

        assertTrue(set.contains(val) && (set.getSize() == 1));

    }

    @Test
    public void testAdd_vals_0thru10(){
        Integer val = 0;
        boolean flag = true;
        ISet<Integer> set = MakeASet();
        for(int i = 0; i <= 10; i++){
            val = i;
            set.add(val);
        }

        for(int i = 0; i <= 10; i++){
            if(!set.contains(i)){
                flag = false;
            }
        }

        assertTrue(flag && (set.getSize() == 11));

    }

    @Test
    public void testAdd_vals_0thru5_twice(){
        Integer val = 0;
        boolean flag = true;
        ISet<Integer> set = MakeASet();
        for(int i = 0; i <= 5; i++){
            val = i;
            set.add(val);
        }
        for(int i = 0; i <= 5; i++){
            val = i;
            set.add(val);
        }

        for(int i = 0; i <= 5; i++){
            if(!set.contains(i)){
                flag = false;
            }
        }

        assertTrue(flag && (set.getSize() == 6));

    }

    @Test
    public void testContains_noValue(){
        ISet<Integer> set = MakeASet();
        assertFalse(set.contains(0));
    }

    @Test
    public void testContains_addAndRemove(){
        ISet<Integer> set = MakeASet();
        set.add(0);
        set.removePos(0);
        assertTrue(!set.contains(0));
    }

    @Test
    public void testContains_0(){
        ISet<Integer> set = MakeASet();
        set.add(0);
        assertTrue(set.contains(0));
    }

    @Test
    public void testEquals_differentSizes(){
        ISet<Integer> set1 = MakeASet();
        ISet<Integer> set2 = MakeASet();
        set1.add(0);
        set1.add(1);
        set2.add(0);


        assertFalse(set1.equals(set2));
    }

    @Test
    public void testEquals_setsOf1(){
        ISet<Integer> set1 = MakeASet();
        ISet<Integer> set2 = MakeASet();
        set1.add(0);
        set2.add(0);

        assertTrue(set1.equals(set2));
    }

    @Test
    public void testEquals_addThenRemoveFromOne(){
        ISet<Integer> set1 = MakeASet();
        ISet<Integer> set2 = MakeASet();
        set1.add(0);
        set1.removePos(0);
        set2.add(0);

        assertTrue(!set1.equals(set2));
    }

    @Test
    public void testUnion_twoVals(){
        ISet<Integer> set1 = MakeASet();
        ISet<Integer> set2 = MakeASet();
        ISet<Integer> set3 = MakeASet();
        set1.add(6);
        set2.add(7);
        set3.add(6);
        set3.add(7);


        set1.union(set2);

        assertTrue(set1.equals(set3));
    }

    @Test
    public void testUnion_unevenSets(){
        ISet<Integer> set1 = MakeASet();
        ISet<Integer> set2 = MakeASet();
        ISet<Integer> set3 = MakeASet();
        set1.add(0);
        set2.add(0);
        set2.add(1);
        set3.add(0);
        set3.add(1);
        set1.union(set2);

        assertTrue(set1.equals(set3));
    }

    @Test
    public void testUnion_addSameTwice(){
        ISet<Integer> set1 = MakeASet();
        ISet<Integer> set2 = MakeASet();
        ISet<Integer> set3 = MakeASet();

        set1.add(0);
        set2.add(0);
        set3.add(0);
        set1.union(set2);

        assertTrue(set1.equals(set3));
    }

    @Test
    public void testIntersect_oneValue(){
        ISet<Integer> set1 = MakeASet();
        ISet<Integer> set2 = MakeASet();
        ISet<Integer> set3 = MakeASet();
        set1.add(0);
        set2.add(0);
        set3.add(0);

        set1.intersect(set2);

        assertTrue(set1.equals(set3));
    }

    @Test
    public void testIntersect_addAndRemove(){
        ISet<Integer> set1 = MakeASet();
        ISet<Integer> set2 = MakeASet();
        ISet<Integer> set3 = MakeASet();

        set1.add(0);
        set1.add(2);
        set2.add(1);
        set1.removePos(0);
        set1.intersect(set2);

        assertTrue(set1.equals(set3));
    }

    @Test
    public void testIntersect_noIntersect(){
        ISet<Integer> set1 = MakeASet();
        ISet<Integer> set2 = MakeASet();
        ISet<Integer> set3 = MakeASet();
        set1.add(3);
        set2.add(4);

        set1.intersect(set2);

        assertTrue(set1.equals(set3));
    }

    @Test
    public void testDifference_emptyDifference(){
        ISet<Integer> set1 = MakeASet();
        ISet<Integer> set2 = MakeASet();
        ISet<Integer> set3 = MakeASet();

        set1.add(0);
        set2.add(0);
        set1.difference(set2);

        assertTrue(set1.equals(set3));
    }

    @Test
    public void testDifference_differentSets(){
        ISet<Integer> set1 = MakeASet();
        ISet<Integer> set2 = MakeASet();
        ISet<Integer> set3 = MakeASet();

        set1.add(1);
        set2.add(0);
        set3.add(1);
        set1.difference(set2);

        assertTrue(set1.equals(set3));
    }

    @Test
    public void testDifference_addAndRemove(){
        ISet<Integer> set1 = MakeASet();
        ISet<Integer> set2 = MakeASet();
        ISet<Integer> set3 = MakeASet();

        set1.add(0);
        set1.removePos(0);
        set1.add(1);
        set2.add(0);
        set3.add(1);
        set1.difference(set2);

        assertTrue(set1.equals(set3));
    }











}
