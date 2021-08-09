public class BinaryTree<T extends Comparable<? super T>> {
    private Node<T> root;
    public Node<T> getRoot(){
        return root;
    }
    public BinaryTree(){
        root = null;
    }
    public void add(T data){
        root = add(data, root);


    }
    private boolean isEmpty(Node<T> node){
        return node.left == null && node.right == null;

    }
    private boolean noLeft(Node<T> node){
        return node.left == null;

    }
    private boolean noRight(Node<T> node){
        return node.right == null;

    }
    private Node<T> add(T data, Node<T> n){
        if(n == null){
            return new Node<>(data);
        }
        else if(data.compareTo(n.data) <= 0 ) {
            n.left = add(data, n.left);
            return root;
        }
        else{
            n.right = add(data, n.right);
            return root;
        }

    }
    public void remove(T data){
        root = remove(data, root);
    }

    private Node<T> remove(T data, Node<T> n) {
        Node<T> curr;
        if(n != null && root.data.compareTo(data) == 0){
            // case1
            if(noLeft(n)){
                return  n.right;
            }else if (noRight(n)){
                return  n.left;
            }else{
                curr = leftLargest(root);
                remove(curr.data);
                root.data = curr.data;
            }

            return curr;
        }
        else if(data.compareTo(n.data) <= 0 ) {
            root.left = remove(data, n.left);
            return root;
        }
        else{
            root.right = remove(data, n.right);
            return root;
        }
    }

    private Node<T> leftLargest(Node<T> root) {
        if(noRight(root)){
            return root;
        }
        return leftLargest(root.right);
    }

    private static class Node<T>{
      private T data;
      private Node<T> left;
      private Node<T> right;
      public Node(T d){
          data = d;
          left = null;
          right = null;
        }
    }
    public String toString(){
        StringBuffer sb = new StringBuffer();
        infixPrint(root,sb);
        return sb.toString().trim();

    }
    // Prints the elements in infix order.
    private void infixPrint(Node<T> root, StringBuffer sb) {
        if (root != null) {
            infixPrint(root.left, sb);
            sb.append(root.data + " ");
            infixPrint(root.right, sb);
        }
    }

    public static void main(String[] args) {
        BinaryTree<Integer> tree = new BinaryTree<>();
        tree.add(50);
        tree.add(20);
        tree.add(73);
        System.out.println(tree);
        tree.remove(50);
        System.out.println(tree);


    }
}
