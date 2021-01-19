
/**
 * Ed Tomlinson
 * 11/29/19
 * CSI 311 Assignment 5 - BST Tree
 *
 */

import java.lang.Math;
import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JOptionPane;

public class TomlinsonE_BTree {

    public static void main(String[] args) {
        Node root = null;// Creates empty BST
        int value;// Holds integer value

        // Fills BST with 20 random values between 1 and 100.
        for (int i = 0; i < 19; i++) {
            value = randNumber();
            root = insertValue(root, value);
        }

        // Prints out BST to JFrame window.
        JFrame frame = new JFrame("(1) Java Binary Search Tree");
        frame.add(displayTree(root));
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        // Asks user to input value of node to be removed.
        String inputString = JOptionPane.showInputDialog("Enter a number to remove from the BST.");
        System.out.println("Removed " + inputString);

        // Parses user input to int variable.
        int inputInt = Integer.parseInt(inputString);

        // Removes the user inputted value from the BST
        removeNode(root, inputInt);

        // Prints new BST
        JFrame frame2 = new JFrame("(2) BST with node removed");
        frame2.add(displayTree(root));
        frame2.pack();
        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame2.setVisible(true);

        // Adds a new random value to the BST
        int ran = randNumber();
        System.out.println("Added " + ran);
        root = insertValue(root, ran);

        // Prints the new BST
        JFrame frame3 = new JFrame("(3) BST with new node inserted");
        frame3.add(displayTree(root));
        frame3.pack();
        frame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame3.setVisible(true);

    }

    /**
     * displayTree is the utility to diplay a BST using swing
     * 
     * @param root the root node of the BST to display
     * @return JPanel component to display tree
     */
    public static JPanel displayTree(Node root) {

        // If tree is empty return a blank panel
        if (root == null) {
            return new JPanel();
        }

        // Leaf node displayed as single text field
        if (root.left == null && root.right == null) {
            JTextField textField = new JTextField(String.valueOf(root.value));
            textField.setEditable(false);
            textField.setBackground(Color.white);
            JPanel leafPanel = new JPanel();
            leafPanel.add(textField);
            return leafPanel;
        }

        // Tree with more than leaf value,. NORTH region dislays node's value, WEST and
        // EAST display the left and right
        // subtrees of the node
        JPanel panel = new JPanel(new BorderLayout());

        // String strValue = String.valueOf(root.value);
        JTextField textField = new JTextField(String.valueOf(root.value));
        textField.setEditable(false);
        textField.setBackground(Color.white);
        JPanel valuePanel = new JPanel();
        valuePanel.add(textField);
        panel.add(valuePanel, BorderLayout.NORTH);

        // Displays left and right subtrees
        panel.add(displayTree(root.left), BorderLayout.WEST);
        panel.add(displayTree(root.right), BorderLayout.EAST);

        return panel;
    }

    /**
     * Removes a specified node from the BST
     * 
     * @param root BST to remove node from
     * @param val  value of node to be removed
     * @return root value of BST with node remvoed
     */
    public static Node removeNode(Node root, int val) {

        // If root is empty return null
        if (root == null) {
            return null;
        }

        // if value specified is less than root value search left subtree
        if (val < root.value) {
            root.left = removeNode(root.left, val);
        }
        // If value specified is greater than root value search right subtree
        else if (val > root.value) {
            root.right = removeNode(root.right, val);
        }

        else {
            // If no left child exists return right subtree
            if (root.left == null) {
                return root.right;
            }
            // If no right child exists return left subtree
            else if (root.right == null) {
                return root.left;
            }
            // Swaps the root value with its successor value
            root.value = minValue(root.right);

            // Removes successor node from tree
            root.right = removeNode(root.right, root.value);
        }

        return root;
    }

    /**
     * Finds the minimal value node in a tree
     * 
     * @param root
     * @return the integer value of node
     */
    public static int minValue(Node root) {
        // holds smallest value found. Initialized to root value
        int min = root.value;

        // Iterate down left subtrees
        while (root.left != null) {
            min = root.left.value;// Replace min value with value of new node
            root = root.left;// change root
        }

        return min;
    }

    /**
     * Creates a random integer between 1 and 100
     * 
     * @return the integer made
     */
    public static int randNumber() {
        int rand = (int) (Math.random() * 100 + 1);
        return rand;
    }

    /**
     * Inserts a node into a BST
     * 
     * @param root the node of the BST
     * @param val  the value to be inserted into the BST
     * @return the root of the new BST
     */
    public static Node insertValue(Node root, int val) {
        // If root is null create a new BST
        if (root == null) {
            root = new Node(val);
            return root;
        }

        // If value is less than the root, add to the left subtree
        if (val < root.value) {
            root.left = insertValue(root.left, val);
        }

        // If value is greater than the root, add to the right subtree.
        else if (val > root.value) {
            root.right = insertValue(root.right, val);
        }
        return root;
    }

}
