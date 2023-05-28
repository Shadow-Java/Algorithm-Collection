package algorithm.collection.common.datastruct.tag;

/**
 * 衡量做题的熟练程度
 */
public enum SegmentLevel {

    /**
     * 感觉记忆：保持0.25-4秒
     */
    SENSORY_MEMORY("SENSORY_MEMORY"),

    /**
     * 短时记忆：保持5秒-1分钟
     */
    SHORT_TERM_MEMORY("SHORT_TERM_MEMORY"),

    /**
     * 长时记忆：保持1分钟以上至终身
     */
    LONG_TERM_MEMORY("LONG_TERM_MEMORY");

    private String value;

    SegmentLevel(String level) {
        this.value = level;
    }

    public String getValue(){
        return value;
    }

    public static SegmentLevel fromValue(String level){
        for (SegmentLevel b : SegmentLevel.values()){
            if(b.value.equals(level)){
                return b;
            }
        }
        throw new IllegalArgumentException("Unexpected value '"+level+"'");
    }

}
