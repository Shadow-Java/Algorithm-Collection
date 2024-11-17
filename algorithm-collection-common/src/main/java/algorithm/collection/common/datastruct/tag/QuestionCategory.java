package algorithm.collection.common.datastruct.tag;

public enum QuestionCategory {

    /**
     * 题单
     * https://leetcode.cn/circle/discuss/YiXPXW/
     */
    GRID_DFS("GRID_DFS"),

    GRID_BFS("GRID_BFS"),

    INTERVAL_COVER("INTERVAL_COVER");

    private String value;

    QuestionCategory(String value) {
        this.value = value;
    }

    public String getValue(){
        return value;
    }

}
