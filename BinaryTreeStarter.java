import java.util.*;

import javax.swing.tree.TreeNode;

public class BinaryTreeStarter {

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }


    static class BinaryTree {
        static int indx = -1;
        public static Node buildTree(int []nodes){

            indx++;

            if(nodes[indx] == -1){
                return null;
            }

            Node newNode = new Node(nodes[indx]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);

            return newNode;
        }

        public static void preorder(Node root) {

            if(root == null){
                return ;
            }

            System.out.print(root.data + "->");
            preorder(root.left);
            preorder(root.right);
        }

        public static void inorder(Node root) {

            if(root == null){
                return ;
            }

            
            preorder(root.left);
            System.out.print(root.data + "->");
            preorder(root.right);
        }

        public static void postorder(Node root) {

            if(root == null){
                return ;
            }

            
            preorder(root.left);
            preorder(root.right);

            System.out.print(root.data + "->");
        }


        /**
         * 
         * Level order traversal
         * 
         *    1
         *   2  3
         *  4 5  6
         * 
         * 
         * output
         * 1
         * 2 3
         * 4 5 6
         * 
         * 
         * approach
         * take queue
         * store 1 with null first
         * [1,null]
         * print 1 and null[nextline] then then add 2 and 3 children to queue 
         * if null removed add null to end also
         * [2,3,null]
         * print 2 and store its child to queue
         */

         public static void levelOrderTraversal(Node root){
            Queue<Node> q = new LinkedList<>();

            //add root and null to q first

            q.add(root);
            q.add(null);

            //loop until q is empty
            while(!q.isEmpty()){
                Node currNode = q.remove();

                if(currNode == null){
                    //print next line
                    System.out.println();

                    //check if it was last node or what
                    if(q.isEmpty()){
                        break;
                    }else{
                        //if not last null then add null at end
                        q.add(null);
                    }
                }else {
                    System.out.println(currNode.data);
                    //add left and right child to queue
                    if(currNode.left != null) q.add(currNode.left);

                    if(currNode.right != null) q.add(currNode.right);
                }
            }
         }

         public List<List<Integer>> levelOrder(Node root) {
            List<List<Integer>> res = new ArrayList<>();
            
            if (root == null) {
                return res;
            }

            Queue<Node> q = new LinkedList<>();
            q.add(root);

            while (!q.isEmpty()) {
                int levelSize = q.size();
                List<Integer> levelList = new ArrayList<>();

                for (int i = 0; i < levelSize; i++) {
                    Node currNode = q.poll();
                    levelList.add(currNode.data);

                    if (currNode.left != null) {
                        q.add(currNode.left);
                    }
                    if (currNode.right != null) {
                        q.add(currNode.right);
                    }
                }

                res.add(levelList);
            }

            return res;
        }
    }

    public static void main(String[] args) {

        int []nodes_array = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};

        BinaryTree binaryTree = new BinaryTree();
        Node root = binaryTree.buildTree(nodes_array);
        System.out.println(root.data);


        System.out.println(":: Preorder Traversal ::");
        binaryTree.preorder(root);

        System.out.println(":: Inorder Traversal ::");
        binaryTree.inorder(root);

        System.out.println(":: Postorder Traversal ::");
        binaryTree.postorder(root);

        System.out.println(binaryTree.levelOrder(root));
    }
}
