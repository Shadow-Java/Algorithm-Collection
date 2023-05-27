package algorithm.collection.common.datastruct.tag;

/**
 * TODO
 *
 * @author shadow
 * @date 2023/5/27 11:05
 * @since 1.0
 */
public enum DifficultyLevel {

    EASY("EASY"),
    MEDIUM("MEDIUM"),
    HARD("HARD");

    private String value;

    DifficultyLevel(String level) {
        this.value = level;
    }

    public String getValue(){
        return value;
    }

    public static DifficultyLevel fromValue(String level){
        for (DifficultyLevel b : DifficultyLevel.values()){
            if(b.value.equals(level)){
                return b;
            }
        }
        throw new IllegalArgumentException("Unexpected value '"+level+"'");
    }
}
