import org.junit.Test;
import static org.junit.Assert.*;
import java.util.*;

interface ListMapper<E> {
    E mapper(E element, int index, List<E> dataList);
}

interface ListFilter<E>{
    boolean filterFunc(E element, int index, List<E> dataList);
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

class IntFilter implements ListFilter<Integer> {
    public boolean filterFunc(Integer element, int index, List<Integer> dataList){
        return element%2 == 0;
    }
}

class StringFilter implements ListFilter<String> {
    public boolean filterFunc(String element, int index, List<String> dataList){
        return element.length() > 4;
    }
}

public class CollectionUtilTest {
    @Test
    public void map_returns_upperCase_of_all_elements_of_given_STRING_LIST(){
        ListMapper<String> mapper = new StringMapper();
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
        ListMapper<Integer> mapper = new IntMapper();
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

    @Test
    public void filter_returns_all_even_numbers_from_given_INTEGER_LIST(){
        ListFilter<Integer> lfilter = new IntFilter();
        List<Integer> numbers = new ArrayList<Integer>();
        List<Integer> expected = new ArrayList<Integer>();
        numbers.add(11);
        numbers.add(2);
        numbers.add(3);
        numbers.add(88);

        expected.add(2);
        expected.add(88);
        List<Integer> result = CollectionUtil.<Integer>filter(numbers,lfilter);
        assertEquals(expected.get(0),result.get(0));
        assertEquals(expected.get(1),result.get(1));
    }

     @Test
    public void filter_returns_list_of_string_whose_length_greater_than_4_from_given_String_LIST(){
        ListFilter<String> lfilter = new StringFilter();
        List<String> str = new ArrayList<String>();
        List<String> expected = new ArrayList<String>();
        str.add("Jai");
        str.add("India");
        str.add("Bharat");
        str.add("Hind");

        expected.add("India");
        expected.add("Bharat");
        List<String> result = CollectionUtil.<String>filter(str,lfilter);
        assertEquals(expected.get(0),result.get(0));
        assertEquals(expected.get(1),result.get(1));
    }
}