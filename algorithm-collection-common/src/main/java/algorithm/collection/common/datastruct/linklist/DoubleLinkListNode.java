package algorithm.collection.common.datastruct.linklist;

/**
 * 双链表节点
 *
 * @author Shadow at 2022/7/28 8:11
 * @version 1.0.1
 */
public class DoubleLinkListNode<T>{
    private T value;
    private DoubleLinkListNode<T> pre;
    private DoubleLinkListNode<T> next;

    DoubleLinkListNode(T value){
        this.value = value;
    }
}
