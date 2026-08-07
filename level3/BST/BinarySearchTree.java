package level3.BST;

public class BinarySearchTree {
	    Node root;
	    public Node insert(Node root, int data) {
	        if (root == null) {
	            return new Node(data);
	        }
	        if (data < root.data) {
	            root.left = insert(root.left, data);
	        } else if (data > root.data) {
	            root.right = insert(root.right, data);
	        }
	        return root;
	    }
	    public boolean search(Node root, int key) {
	        if (root == null)
	            return false;
	        if (root.data == key)
	            return true;
	        if (key < root.data)
	            return search(root.left, key);
	        return search(root.right, key);
	    }
	    public void inorder(Node root) {
	        if (root != null) {
	            inorder(root.left);
	            System.out.print(root.data + " ");
	            inorder(root.right);
	        }
	    }
	    public void preorder(Node root) {
	        if (root != null) {
	            System.out.print(root.data + " ");
	            preorder(root.left);
	            preorder(root.right);
	        }
	    }
	    public void postorder(Node root) {
	        if (root != null) {
	            postorder(root.left);
	            postorder(root.right);
	            System.out.print(root.data + " ");
	        }
	    }
	    public Node findMin(Node root) {
	        while (root.left != null) {
	            root = root.left;
	        }
	        return root;
	    }
	    public Node delete(Node root, int key) {
	        if (root == null)
	            return null;
	        if (key < root.data) {
	            root.left = delete(root.left, key);
	        } else if (key > root.data) {
	            root.right = delete(root.right, key);
	        } else {
	            if (root.left == null && root.right == null)
	                return null;
	            if (root.left == null)
	                return root.right;
	            if (root.right == null)
	                return root.left;
	            Node minNode = findMin(root.right);
	            root.data = minNode.data;
	            root.right = delete(root.right, minNode.data);
	        }
	        return root;
	    }
	}
