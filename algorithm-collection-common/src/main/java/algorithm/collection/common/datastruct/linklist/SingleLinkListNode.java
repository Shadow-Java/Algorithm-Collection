package algorithm.collection.common.datastruct.linklist;


/**
 * 单链表节点
 *
 * @author shadow
 * @create 2022-07-14 18:39
 */
public class SingleLinkListNode<T> {
    public T value;
    public SingleLinkListNode next;

    SingleLinkListNode(T value){
        this.value = value;
    }
}
