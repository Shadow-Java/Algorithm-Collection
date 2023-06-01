package algorithm.collection.common.datastruct.tag;

/**
 * 题型分类
 *
 * @author shadow
 * @date 2023/5/27 11:21
 * @since 1.0
 */
public enum AlgorithmCategory {

    OTHER("OTHER"),

    DYNAMIC_PROGRAMMING("DYNAMIC_PROGRAMMING"),
    DEPTH_FIRST_SEARCH("DEPTH_FIRST_SEARCH"),

    WIDTH_FIRST_SEARCH("WIDTH_FIRST_SEARCH"),

    DOUBLE_POINTER("DOUBLE_POINTER"),

    SLIDE_WINDOW("SLIDE_WINDOW");
    private String value;

    AlgorithmCategory(String level) {
        this.value = level;
    }

    public String getValue(){
        return value;
    }

    public static AlgorithmCategory fromValue(String level){
        for (AlgorithmCategory b : AlgorithmCategory.values()){
            if(b.value.equals(level)){
                return b;
            }
        }
        throw new IllegalArgumentException("Unexpected value '"+level+"'");
    }

}
