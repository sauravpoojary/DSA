public class BST {
    static class Node {
        
        int data;
        Node left;
        Node right;

        public Node(int val) {
            this.data = val;
        }
    }

    public static Node insert(Node root,int val){
        if(root == null){
            root = new Node(val);
            return root;
        }

        //check left subtree
        if(root.data > val){
            root.left = insert(root.left, val);
        }else {
            root.right = insert(root.right, val);
        }

        return root;


    }

    public static void inorderTraversal(Node root){
        if(root == null){
            return;
        }
        inorderTraversal(root.left);
        System.out.print(root.data + " ");
        inorderTraversal(root.right);
    }

    public static void main(String[] args) {
        int []values = {5, 1, 3, 4, 2, 7, 6};

        Node root = null;
        int len = values.length;
        for(int i =0; i<len; i++){
            root = insert(root, values[i]);
        }

        inorderTraversal(root);

    }
}