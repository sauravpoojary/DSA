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


    public static boolean search(Node root, int key){

        if(root == null){
            return false;
        }

        if(root.data == key){
            return true;
        }

        //check left subtree
        if(root.data > key){
            return search(root.left, key);
        }else{
            return search(root.right, key);
        }
    }


    /* Delete a Node 
     * 
     * 
     * Case 1 NoChild ( leaf node )
     * 
     * Delete node and return null to parent
     * 
     * 
     * Case 2 One child
     * 
     * Delete node and replace with the single child
     * 
     * 
     * Case 3 Two childern
     * 
     * Replace with inorder succesor
     * 
     *       8
     *     5
     *   3   6
     * 
     * 
     * if you want to delete 5 
     * node 5 has inorder successor has 6
     * so 6 will be replaced with 5
     * after replacing delete original 6 from tree
     * 
     * how to find inorder successor ?
     * In BST inorder successor = left most in right subtree
     * 
    */

    public static Node delete (Node root, int val){


        if(root.data > val){
            //search in left subtree
            root.left = delete(root.left, val);
        }else if(root.data < val){
            //search in right subtree
            root.right = delete(root.right, val);
        }else {

            //you searched the element
            //when root.data == val

            //Case 1
            if(root.left == null && root.right == null){
                //return null to parent
                return null;
            }

            //case 2
            if(root.left == null){
                return root.right;
            }else if(root.right == null){
                return root.left;
            }
            
            //case 3 
            //find leftmost element in right subtree

            Node inorder_succ = inorderSuccessor(root.right);
            //change the data to successor data
            root.data = inorder_succ.data;
            //delete already existing data
            root.right = delete(root.right, inorder_succ.data);

        }

        return root;
    }

    public static Node inorderSuccessor(Node root){

        //check until you get leftmost child

        while(root.left != null){
            root = root.left;
        }

        return root;

    }

    public static void printInRange(Node root, int X, int Y){

        if(root == null) return;
        if(root.data >= X && root.data <= Y){
            printInRange(root.left, X, Y);
            System.out.print(root.data + "-> ");
            printInRange(root.right, X, Y);
        }else if(root.data > Y){
            //left subtree only
            printInRange(root.left, X, Y);
        }else {
            printInRange(root.right, X, Y);
        }

    }
    public static void main(String[] args) {
        int []values = {5, 1, 3, 4, 2, 7, 6};

        Node root = null;
        int len = values.length;
        for(int i =0; i<len; i++){
            root = insert(root, values[i]);
        }

        inorderTraversal(root);

        boolean isFound = search(root, 9);

        System.out.println("isFound :: "+isFound);

        int delete_val = 6;
        delete(root, delete_val);

        inorderTraversal(root);
        System.out.println();
       
        int x = 4;
        int y = 8;
         System.out.println("Printing in range X:: "+x+" Y:: "+ y);
        printInRange(root, x, y);

    }
}