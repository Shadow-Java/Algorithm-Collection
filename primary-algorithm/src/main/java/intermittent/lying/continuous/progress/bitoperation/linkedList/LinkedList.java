package intermittent.lying.continuous.progress.bitoperation.linkedList;

import intermittent.lying.continuous.progress.common.datastruct.LinkListNode;

/**
 *
 * <ul>
 *     <li>1.最好不用包装类型，全部用值类型</li>
 *     <li>2.最好不要用get和set,单值传递</li>
 *     <li>3.可以设计成一个spring项目,定义一个parent名,每次打包通过这个name</li>
 * </ul>
 *
 *
 * @author Shadow at 2022/7/11 21:48
 * @version 1.0.1
 */
public class LinkedList {


    /**
     * 反转链表,输入头结点，返回头结点
     * 类型：头结点有值
     * 比如：5->4->3->2->1
     * 反转后：1->2->3->4->5
     */
    public static LinkListNode reverseList(LinkListNode head){
        /**
         * 代表cur节点的上一个节点
         */
        LinkListNode pre = null;
        /**
         * 代表cur的下一个节点
         */
        LinkListNode next;
        while(head.next != null){
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }


}
