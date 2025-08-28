public class BinaryTreeTraversal {
    Node root;

    public void preOrderTraversal() {

        preOrderTraversal(this.root);
    }

    private void preOrderTraversal(Node root) {
        if(root!= null){
            System.out.print(root.data + " ");
            preOrderTraversal(root.left);
            preOrderTraversal(root.right);
        }
    }

    //------------------------------------------

    public void inOrderTraversal() {

        inOrderTraversal(this.root);
    }

    private void inOrderTraversal(Node root) {
        if(root!= null){
            inOrderTraversal(root.left);
            System.out.print(root.data + " ");
            inOrderTraversal(root.right);
        }
    }

    //------------------------------------------

    public void postOrderTraversal() {

        postOrderTraversal(this.root);
    }

    private void postOrderTraversal(Node root) {
        if(root!= null){
            postOrderTraversal(root.left);
            postOrderTraversal(root.right);
            System.out.print(root.data + " ");

        }
    }

    //------------------------------------------

    public int findHeight(Node root) {

        if (root==null){
            return 0;
        }else{
            int leftHight = findHeight(root);
            int rightHight = findHeight(root);
            return 1 + Math.max(leftHight,rightHight);
        }
    }

    public static void main(String[] args) {
        
    }
}
