package algorithm.collection.schedule.schedulejob;

public interface MessageService {

    /**
     * 每天通过注册写的算法，在对应的目录下生成文件，通过分析每天的文件，生成对应的学习计划和复习计划
     * @param message
     */
    void sendMessage(String message);

}
