package coursera.course4;

public class Main {
    public static void main(String[] args) {
//        ListNode<Integer> head = new ListNode<>(2);
//        head.prev = null;
//        head.next = new ListNode<>(3);
//        head.next.prev = head;
//        head.next.next = null;
//        System.out.println(ListNode.displayLinkedList(head));
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(7);
        TreeNode.bfs(root);
    }
}
