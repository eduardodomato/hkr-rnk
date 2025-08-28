public class BinarySearchTree {

    Node root;

    public void insert(int value){
        root = insert(this.root, value);
    }

    private Node insert(Node root, int value) {

        if(root == null){
            root=new Node();
            root.data=value;
        } else if (value < root.data) {

            root.left = insert(root.left,value);
        }else if (value>root.data){
            root.right= insert(root.right, value);
        }
        return root;

    }

    public static void main(String[] args) {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree .insert(7);
        binarySearchTree .insert(3);
        binarySearchTree .insert(5);

    }

}
