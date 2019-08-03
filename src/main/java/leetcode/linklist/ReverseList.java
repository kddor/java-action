package leetcode.linklist;

/**
 * Created by apple on 2019/7/15.
 * 反转一个单链表。
 示例:
 输入: 1->2->3->4->5->NULL
 输出: 5->4->3->2->1->NULL
 需要定义3个指针分别指向遍历到的节点、它的前一个节点及后一个节点
 */
public class ReverseList {
    /**
     * 反转链表
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.getNext(); //把当前节点的下一个节点存储起来，防止链表断裂
            curr.setNext(prev); //当前节点的next指针指向前一个节点
            prev = curr; //
            curr = nextTemp;
        }
        return prev;
    }

    /**
     * 删除节点
     * @param node
     */
    public void deleteNode(ListNode node) {
        node.setVal(node.getNext().getVal());   //设置节点的值为下一节点的val
        node.setNext(node.getNext().getNext()); //指针指向下一节点
    }

    public static void main(String args[]) {
        ListNode P1 = new ListNode(1);
        ListNode P2 = new ListNode(2);
        ListNode P3 = new ListNode(3);
        ListNode P4 = new ListNode(4);
        ListNode P5 = new ListNode(5);

        P1.setNext(P2);
        P2.setNext(P3);
        P3.setNext(P4);
        P4.setNext(P5);
        ListNode.print(P1);

        ReverseList revlist = new ReverseList();
        //反转链表
        ListNode prev=revlist.reverseList(P1);
        ListNode.print(prev);
        //删除节点2
        revlist.deleteNode(P2);
        ListNode.print(prev);
        System.out.print(revlist.getClass().getName());
    }


}

