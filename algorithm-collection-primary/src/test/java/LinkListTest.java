import algorithm.collection.common.datastruct.linklist.SingleLinkListNode;
import algorithm.collection.primary.linkedList.LinkedList;
import org.junit.Test;

/**
 * 链表test
 *
 * @author shadow
 * @date 2022/7/28 18:17
 * @since 1.0
 */
public class LinkListTest {

    /**
     * 通过数组创建单链表
     */
    @Test
    public void createSingleLinkList(){
        int[] num = {1,2,3,4,5,6,7};
        SingleLinkListNode<Integer> head = LinkedList.createLinkList(num);
        while(head != null){
            System.out.println(head.value);
            head = head.next;
        }
    }

}
