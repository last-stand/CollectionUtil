import java.util.*;

public class CollectionUtil{
	public static<E> List<E> map(List<E> dataList, ListMapper<E> lmap){
		List<E> result = new ArrayList<E>();
		for(int i=0; i<dataList.size(); i++){
			E element = lmap.mapper(dataList.get(i),i,dataList);
			result.add(element);
		}
		return result;
	}

	public static<E> List<E> filter(List<E> dataList, ListFilter<E> lfilter){
		List<E> result = new ArrayList<E>();
		for(int i=0; i<dataList.size(); i++){
			if(lfilter.filterFunc(dataList.get(i),i,dataList))
				result.add(dataList.get(i));
		}
		return result;
	}
}