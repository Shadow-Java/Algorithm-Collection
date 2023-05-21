package algorithm.collection.common.datastruct.linklist;


import java.util.Random;

/**
 * @author shadow
 * @create 2023-05-21 15:01
 **/
public class ListNodeRandomGenerator {

    /**
     * 自动生成单链表
     *
     * @param length
     * @param maxVal
     * @return
     */
    public static ListNode generatorSingleList(int length, int maxVal){
        ListNode head = null;
        ListNode tail = null;
        Random random = new Random();
        while(length > 0){
            if(head == null){
                head = tail = new ListNode(random.nextInt(maxVal));
            }else{
                /**
                 * 要先申请空间，再更新
                 */
                tail.next = new ListNode(random.nextInt(maxVal));
                tail = tail.next;
                /**
                 * 错误写法：将tail指向了null空间，null空间和ListNode空间不同
                 */
                //tail = tail.next;
                //tail = new ListNode(random.nextInt(maxVal));
            }
            length--;
        }
        return head;
    }

    public static void printSingleListNode(ListNode head){
        System.out.println("--------------------------链表打印如下--------------------------");
        while (head != null){
            System.out.print(head.val+" --> ");
            head = head.next;
        }
        System.out.print("NULL"+"\n");
        System.out.println("--------------------------链表打印完成--------------------------");
    }


    public static void main(String[] args) {
        ListNode head = generatorSingleList(4,10);
        printSingleListNode(head);
    }

}
