package coursera.course4;

public class BST {
    int val;
    BST left,right;

    BST(int val){ this.val = val;}

    public static void insert(int value, BST bst) {
        if(value <= bst.val) {
            if(bst.left == null) bst.left = new BST(value);
            else bst.left.insert(value, bst.left);
        } else {
            if(bst.right == null) bst.right = new BST(value);
            else bst.right.insert(value, bst.right);
        }
    }

    public void insert(int value) {
        if(value<=val) {
            if(left == null) {
                left = new BST(value);
            } else {
                left.insert(value);
            }
        } else {
            if(right == null) {
                right = new BST(value);
            } else {
                right.insert(value);
            }
        }
    }

    public boolean find(int value) {
        if(value == val) return true;
        else if(value<=val) {
            if(left == null) return false;
            return left.find(value);
        }
        else if(value > val){
            if(right ==  null) return false;
            return right.find(value);
        }
        return false;
    }

    public void inorder() {
        if(left != null) left.inorder();
        System.out.print(val + " ");
        if(right != null) right.inorder();
    }
}
