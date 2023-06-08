package algorithm.collection.common.datastruct.tag;

/**
 * 时间复杂度
 *
 * @author shadow
 * @date 2023/5/27 11:16
 * @since 1.0
 */
public enum TimeComplexity {
    O_LOG_N("O(logN)"),
    O_N("O(N)"),
    O_N_LOG_N("O(N(logN))"),
    O_N_2_N_1("O(N*2^(N-1))"),
    O_N_2("O(N^2)"),
    O_N_3("O(N^3)"),
    O_N_4("O(N^4)"),
    //其中 N,KN, KN,K 分别为 S, T 字符串的长度
    O_NK("O(NK)");
    private String value;

    TimeComplexity(String level) {
        this.value = level;
    }

    public String getValue(){
        return value;
    }

    public static TimeComplexity fromValue(String level){
        for (TimeComplexity b : TimeComplexity.values()){
            if(b.value.equals(level)){
                return b;
            }
        }
        throw new IllegalArgumentException("Unexpected value '"+level+"'");
    }

}
