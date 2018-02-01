package CodePractice;

class ListNode {
    int val;
    ListNode next = null;
    ListNode(int val) {
        /**
         * Java关键字this只能用于方法方法体内,当一个对象创建后，Java虚拟机（JVM）就会给这个对象分配一个引用自身的指针，
         * 这个指针的名字就是 this,因此，this只能在类中的非静态方法中使用，静态方法和静态的代码块中绝对不能出现this，
         */
        this.val = val;
    }
}


public class Item15 {
    public ListNode ReverseList(ListNode head) {
        if (head == null)
            return null;
        ListNode pPre = null;
        ListNode pNext = null;
        while (head != null) {
            pNext = head.next;
// 反转指向
            head.next = pPre;
// 指针往下移动
            pPre = head;
            head = pNext;
        }
// 新链表的头结点就是原链表的尾结点
        return pPre;
    }


    void printList(ListNode last) {
        while (last != null) {
            System.out.print(last.val + ",");
            last = last.next;


        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(4);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        Item15 s = new Item15();
        ListNode last = s.ReverseList(head);
        s.printList(last);
    }
}
