package leetcode.linklist;

/**
 * Created by apple on 19/4/28.
 */
public class ListNode {
    private int val;           //保存节点内容
    private ListNode next;     //保存下一个节点
    public ListNode(int x ){  //构造方法设置节点内容
        this.val= x;
    }

    public int getVal(){           //得到节点内容
        return this.val;
    }
    public void setVal( int val){  //修改节点内容
        this.val = val;
    }

    public ListNode getNext(){     //得到下一个节点
        return this.next;
    }
    public void setNext( ListNode next){  //设置 下一个节点
        this.next = next;
    }

    //方法：遍历链表（打印输出链表。方法的参数表示从节点node开始进行遍历

    /**
     * @param node
     */
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
