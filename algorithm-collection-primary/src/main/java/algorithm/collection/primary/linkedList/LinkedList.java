package algorithm.collection.primary.linkedList;


import algorithm.collection.common.datastruct.linklist.SingleLinkListNode;

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
     * <p>反转链表,输入头结点，返回头结点
     *
     * <pre>  head.value = 5
     *     比如: 5->4->3->2->1->null
     *          ^
     *   反转后: 1->2->3->4->5->null
     *          ^
     * </pre>
     *
     * 类型:头结点有值,结果返回新的头部
     * 结构:pre->head->next
     */
    public static SingleLinkListNode reverseList(SingleLinkListNode head){
        /**
         * 代表cur节点的上一个节点,开始时上一节点为null
         */
        SingleLinkListNode pre = null;
        /**
         * 代表cur的下一个节点
         */
        SingleLinkListNode next;
        while(head.next != null){
            /**
             * 当前节点是head,故记录下一个节点head;下一轮的cur为next
             */
            next = head.next;
            /**
             * 下一节点已记录,故断连head与head.next;将head指向上一节点pre
             */
            head.next = pre;
            /**
             * pre已使用,记录下一节点的值；对于下一节点来说当前节点为next
             */
            pre = head;
            /**
             * 用记录的next来更新head,next的主要作用是来更新head，即next就是下一轮的cur
             */
            head = next;
        }
        return pre;
    }


}
