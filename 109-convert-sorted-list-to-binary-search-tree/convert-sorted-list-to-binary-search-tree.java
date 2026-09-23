class Solution {
    private ListNode headPointer;

    public TreeNode sortedListToBST(ListNode head) {
        this.headPointer = head;
        int size = getSize(head);
        return convertListToBST(0, size - 1);
    }

    private int getSize(ListNode head) {
        int size = 0;
        while (head != null) {
            size++;
            head = head.next;
        }
        return size;
    }

    private TreeNode convertListToBST(int left, int right) {
        if (left > right) {
            return null;
        }

        int mid = left + (right - left) / 2;

        TreeNode leftChild = convertListToBST(left, mid - 1);

        TreeNode root = new TreeNode(headPointer.val);
        root.left = leftChild;

        headPointer = headPointer.next;

        root.right = convertListToBST(mid + 1, right);

        return root;
    }
}
