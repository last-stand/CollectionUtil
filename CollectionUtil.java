import java.util.*;

public class CollectionUtil{
	public static<E> List<E> map(List<E> dataList, ListMapper lmap){
		List<E> result = new ArrayList();
		for (E data : dataList) {
			E element = (E)lmap.mapper(data,0,dataList);
			result.add(element);
		}
		return result;
	}
}