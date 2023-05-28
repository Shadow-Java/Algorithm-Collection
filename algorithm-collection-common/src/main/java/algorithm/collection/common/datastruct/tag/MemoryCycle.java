package algorithm.collection.common.datastruct.tag;

/**
 * 按照艾宾浩斯遗忘曲线进行学习的重复记忆
 * 为了防止遗忘，有人根据艾宾浩斯记忆曲线总结了一套周期记忆法，主要是对所学习的内容进行周期性的重复记忆，以达到记忆的很好效果。
 *
 * 第一个记忆周期:5分钟
 *
 * 第二个记忆周期:30分钟
 *
 * 第三个记忆周期:12小时
 *
 * 第四个记忆周期:1天
 *
 * 第五个记忆周期:2天
 *
 * 第六个记忆周期:4天
 *
 * 第七个记忆周期:7天
 *
 * 第八个记忆周期:15天
 */
public enum MemoryCycle {

    FIRST("FIRST"),

    SECOND("SECOND"),

    THIRD("THIRD"),

    FOURTH("FOURTH"),

    FIFTH("FIFTH"),

    SIXTH("SIXTH"),

    SEVENTH("SEVENTH"),

    EIGHTH("EIGHTH");

    private String value;

    MemoryCycle(String level) {
        this.value = level;
    }

    public String getValue(){
        return value;
    }

    public static MemoryCycle fromValue(String level){
        for (MemoryCycle b : MemoryCycle.values()){
            if(b.value.equals(level)){
                return b;
            }
        }
        throw new IllegalArgumentException("Unexpected value '"+level+"'");
    }

}
