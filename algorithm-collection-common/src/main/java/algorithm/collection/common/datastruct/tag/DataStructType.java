package algorithm.collection.common.datastruct.tag;

/**
 * 使用的什么数据结构
 *
 * @author shadow
 * @date 2023/5/27 11:24
 * @since 1.0
 */
public enum DataStructType {

    UNIVERSAL_TREE("UNIVERSAL_TREE"),
    ARRAY("ARRAY"),
    UNIVERSAL_STACK("UNIVERSAL_STACK"),
    MONOTONIC_STACK("MONOTONIC_STACK"),
    BINARY_TREE("BINARY_TREE"),
    UNIVERSAL_QUEUE("UNIVERSAL_QUEUE"),
    //双端队列
    DEDED_DOUBLE_QUEUE("DEDED_DOUBLE_QUEUE"),
    UNIVERSAL_LIST("UNIVERSAL_LIST"),
    SINGLE_LIST("SINGLE_LIST");

    private String value;

    DataStructType(String level) {
        this.value = level;
    }

    public String getValue(){
        return value;
    }

    public static DataStructType fromValue(String level){
        for (DataStructType b : DataStructType.values()){
            if(b.value.equals(level)){
                return b;
            }
        }
        throw new IllegalArgumentException("Unexpected value '"+level+"'");
    }

}
