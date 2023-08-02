package algorithm.collection.common.datastruct;

public interface RandomGenerator <T>{
    /**
     * 数据结构生成器
     * @return
     */
    T generator();

    /**
     * 打印数据结构
     * @param t
     */
    void print(T t);
}
