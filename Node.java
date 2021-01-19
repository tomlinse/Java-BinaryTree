/**
 * Node Class for BST
 */

public class Node {
    int value; //Holds an integer value for the node
    Node left, right; //Left and right children nod

    /**
     * Constructor of root node, Value but no children;
     * @param val
     */
    Node(int val){
        value = val;
        left = null;
        right = null;
    }

    /**
     * Constructs a node with a value, left and right children nodes.
     * @param val
     * @param leftChild
     * @param rightChild
     */
    Node(int val, Node leftChild, Node rightChild){
        value = val;
        left = leftChild;
        right = rightChild;
    }
}
