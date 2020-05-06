
package leetcode.editor.cn;

//[2]两数相加
//给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。 
//
// 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。 
//
// 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。 
//
// 示例： 
//
// 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
//输出：7 -> 0 -> 8
//原因：342 + 465 = 807
// 
// Related Topics 链表 数学


public class T2 {

    public static void main(String[] args) {

        ListNode l1 = new ListNode(9);
        l1.next = new ListNode(9);
//        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(9);
//        l2.next = new ListNode(9);
//        l2.next.next = new ListNode(4);
        new T2().addTwoNumbers(l1, l2);
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }

        if (l2 == null) {
            return l1;
        }

        int t = 0;
        ListNode a = l1;
        while (true) {

            l1.val += l2.val + t;
            t = l1.val / 10;
            l1.val %= 10;

            if (l1.next == null && l2.next == null && t == 0) {
                break;
            }
            if (l1.next == null) {
                l1.next = new ListNode(0);
            }
            if (l2.next == null) {
                l2.next = new ListNode(0);
            }
            l1 = l1.next;
            l2 = l2.next;
        }

        return a;
    }


}