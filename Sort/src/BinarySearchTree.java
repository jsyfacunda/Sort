import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

public class BinarySearchTree {
    //this is my node class that can be accessed only by the BinarySearchTree class

    static int total = 0;

    private class Node<Integer> {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }
    }

    public Node root;

    public static void main(String[] args) {

        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(47);
        tree.add(32);
        tree.add(59);
        tree.add(62);
        tree.add(21);
        tree.add(20);
        tree.add(30);
        tree.printBST(tree.root);
        System.out.println();
        tree.replaceWithSum(32);
        System.out.println();
        tree.printBST(tree.root);
        //tree.replaceWithSum(59);


    }
    //I need to build a binary search tree

    //checking if there is a root to start at
    public void insert(int value) {
        Node node = new Node<Integer>(value);
        if (root == null) {
            root = node;
            return;
        }
        //helper method
        insertRec(root, node);
    }

    //now we need a helper method (in this case it is insertRec) for inserting a value for the root if the root is not null
    private void insertRec(Node latestRoot, Node node) {
        //check both left and right side of the tree
        if (latestRoot.data > node.data) {
            if (latestRoot.left == null) {
                latestRoot.left = node;
            } else {
                insertRec(latestRoot.left, node);
            }
        } else {
            if (latestRoot.right == null) {
                latestRoot.right = node;
            } else {
                insertRec(latestRoot.right, node);
            }
        }
    }

    //method to add a value to a tree and it calls the helper method
    public void add(int value) {
        compareAdd(root, value);
    }

    //helper method that goes through and checks if the latest node being passed in is null
    //if it is not null then you need to check if the nodes value is greater or lesser than the value being passed in
    //node value is greater than you need to go right
    //node value is lesser than you need to go left
    //sett the latestRoot.right or .left to compareAdd in order for the node to be added to that side
    private Node compareAdd(Node latestRoot, int value) {
        if (latestRoot == null) {
            latestRoot = new Node(value);
        } else if (latestRoot.data > value) {
            latestRoot.left = compareAdd(latestRoot.left, value);
        } else if (latestRoot.data < value) {
            latestRoot.right = compareAdd(latestRoot.right, value);
        }
        return latestRoot;
    }

    //traverse the tree and print in post-order
    private void printBST(Node n) {
        if (n != null) {
            printBST(n.left);
            printBST(n.right);
            System.out.print(n.data + " ");
        }
    }

    //given method that takes all subtree roots and sums the children and that value replaces the subtree root node
    public void replaceWithSum(int value) {

        //contains(root, value);
        //want to print
        //if ( contains(root, value) != null) {
        //printBST(contains(root, value).left);
        //printBST( contains(root, value).right);
        contains(root, value);
        //}
    }

    //I need a helper method to search for the value being passed in
    private Node contains(Node latestRoot, int value) {
        if (latestRoot.data == value) {
            //if latestRoot.data == value then I want to create a new node that adds in the value from traverseAdd into a new node
            Node node = new Node<Integer>(traverseAdd(latestRoot));
            //latestRoot becomes the new node as that is replacing the old subtree root node
            latestRoot = node;
        }

        //if the latestRoot.data does not equal the value then I need to go though the tree and check if it is in the left or right side

        /*if the value is in the left or right then I need to set latestRoot.left or latestRoot.right equal to contains in order to have it
        reach that if statement that will create the new node and set it to the total value from the children nodes
        */
        else if (latestRoot.data > value) {
            //contains(latestRoot.left, value);
            latestRoot.left = contains(latestRoot.left, value);
        } else if (latestRoot.data < value) {
            //contains(latestRoot.right, value);
            latestRoot.right = contains(latestRoot.right, value);
        }

        return latestRoot;
    }

    //I need a helper method for contains() to go through all of the nodes and grab the values in order to sum it all up
    //just like printBST I use the same idea to traverse the tree but instead of just printing the value I add it to the total sum
    private int traverseAdd(Node latestRoot) {

            if (latestRoot.right != null) {
                System.out.println("Right node: " + latestRoot.right.data);
                total += latestRoot.right.data;
                traverseAdd(latestRoot.right);
            }
            if (latestRoot.left != null) {
                System.out.println("Left node: " + latestRoot.left.data);
                total += latestRoot.left.data;
                traverseAdd(latestRoot.left);
            }

            latestRoot.data = total;

        return latestRoot.data;
    }

}