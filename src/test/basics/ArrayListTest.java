package test.basics;

import main.basics.SampleArrayList;
import org.junit.Assert;
import org.junit.Test;

import java.util.Collection;

import static org.junit.Assert.assertEquals;

public class ArrayListTest {

    @Test
    public void testIntialization() {
        SampleArrayList<Integer> testList = new SampleArrayList<Integer>();
        assertEquals(0, testList.size());
        testList.add(10);
        testList.add(11);
        testList.add(20);
        assertEquals(3, testList.size());

        SampleArrayList testList2 = new SampleArrayList((Collection<? extends Integer>) testList);
        assertEquals(3, testList2.size());
        assertEquals(Integer.valueOf(testList.get(2).toString()), Integer.valueOf(20));
    }

    @Test
    public void testArrayExpansion() {
        SampleArrayList<Integer> testList = new SampleArrayList<Integer>();
        for (int i=0; i< 20; i++) {
            testList.add(i);
        }
        assertEquals(20, testList.size());

        assertEquals("5", testList.get(5).toString());
    }

}
