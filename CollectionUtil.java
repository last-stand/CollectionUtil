import java.util.*;

public class CollectionUtil{

	public static<E,K> List<K> map(List<E> dataList, ListMapper<E,K> lmap){
		List<K> result = new ArrayList<K>();
		for(int i=0; i<dataList.size(); i++){
			K element = lmap.mapper(dataList.get(i),i,dataList);
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

	public static<E,K> K reduce(List<E> dataList, ListReducer<E,K> lreducer, K initial){
		K previous = initial;
		for(int i=0; i<dataList.size(); i++){
			previous = lreducer.reduceFunc(previous,dataList.get(i),i,dataList);
		}
		return previous;
	};
}