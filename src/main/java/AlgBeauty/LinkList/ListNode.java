package AlgBeauty.LinkList;

/**
 * Created by apple on 19/4/28.
 */
public class ListNode {
    int val;
    ListNode next;
    ListNode(int x ){
        this.val= x;
    }

    //方法：遍历链表（打印输出链表。方法的参数表示从节点node开始进行遍历
    public static void print(ListNode node) {
        if (node == null) {
            return;
        }

        ListNode current = node;
        while (current != null) {
            System.out.print(current.val+"->");
            current = current.next;
        }
        System.out.println("");
    }
}
