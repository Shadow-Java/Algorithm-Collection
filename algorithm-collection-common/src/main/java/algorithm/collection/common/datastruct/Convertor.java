package algorithm.collection.common.datastruct;

public interface Convertor<S,T>{
    T sourceConvertTarget(S s);

    S targetConvertSource(T t);
}
