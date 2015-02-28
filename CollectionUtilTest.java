import org.junit.Test;
import static org.junit.Assert.*;
import java.util.*;

interface ListMapper<E> {
    E mapper(E element, int index, List<E> dataList);
}

class IntMapper implements ListMapper<Integer> {
    public Integer mapper(Integer element, int index, List<Integer> dataList){
        return element*element*element;
    }
}

class StringMapper implements ListMapper<String> {
    public String mapper(String element, int index, List<String> dataList){
        return element.toUpperCase();
    }
}


public class CollectionUtilTest {
    @Test
    public void map_returns_upperCase_of_all_elements_of_given_STRING_LIST(){
        ListMapper mapper = new StringMapper();
        List<String> str = new ArrayList<String>();
        List<String> expected = new ArrayList<String>();
        str.add("Hello");
        str.add("bye");
        str.add("but why?");

        expected.add("HELLO");
        expected.add("BYE");
        expected.add("BUT WHY?");
        List<String> result = CollectionUtil.<String>map(str,mapper);
        assertEquals(expected.get(0),result.get(0));
        assertEquals(expected.get(1),result.get(1));
        assertEquals(expected.get(2),result.get(2));
    }
    
    @Test
    public void map_returns_cube_of_all_elements_of_given_INTEGER_LIST(){
        ListMapper mapper = new IntMapper();
        List<Integer> numbers = new ArrayList<Integer>();
        List<Integer> expected = new ArrayList<Integer>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);

        expected.add(1);
        expected.add(8);
        expected.add(27);
        List<Integer> result = CollectionUtil.<Integer>map(numbers,mapper);
        assertEquals(expected.get(0),result.get(0));
        assertEquals(expected.get(1),result.get(1));
        assertEquals(expected.get(2),result.get(2));
    }
}