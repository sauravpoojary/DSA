public class StackClass {

    static class Node {
        int data;
        Node next;
        public Node(int data) {
            this.data = data;
            next = null;
        }
    }

    static class Stack {
        public static Node head;

        public static boolean isEmpty() {
            return head == null;
        }




        public static void push(int data){
            Node newNode = new Node(data);

            if(isEmpty()) {
                head = newNode;
                return;
            }

            newNode.next = head;
            head = newNode;

        }

        public static int pop() {

            if(isEmpty()){
                return -1;
            }
            int top = head.data;

            head = head.next;

            return top;
        }

        public static int peek() {
            if(isEmpty()){
                return -1;
            }

            int top = head.data;

            return top;
        }
    }
    public static void main(String[] args) {

        Stack stack = new Stack();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println("Peek top element is : " +stack.peek());
        System.out.println(" Popped element is : "+ stack.pop());
        System.out.println("Peek top element is : "  +stack.peek());




    }
}
