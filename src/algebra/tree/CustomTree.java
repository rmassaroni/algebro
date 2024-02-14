package algebra.tree;

import algebra.readables.Component;
import algebra.readables.block.split.Split;
import algebra.readables.equation.Equation;
import com.sun.source.tree.Tree;
import deckPack.Deck;

import java.util.ArrayList;

public class CustomTree {
    private TreeNode root;

    public CustomTree() {
        this.root = null;
    }

    public CustomTree(Component component) {
        this.root = new TreeNode(component);
    }

    public void insert(Component component) {
        root = insertSearch(root, component);
    }

    private TreeNode insertSearch(TreeNode root, Component component) {
        if(root == null) {
            root = new TreeNode(component);
            return root;
        }

//        if (data < root.data) {
//            root.left = insertRec(root.left, data);
//        } else if (data > root.data) {
//            root.right = insertRec(root.right, data);
//        }
        //COMPARE COMPONENTS

        return root;
    }
}

class TreeNode {
    public Component c;

    public Deck<TreeNode> nodes;

    public TreeNode(Component component) {
        this.c = component;
        this.nodes = new Deck<>();
        setNodes();
    }

    private void setNodes() {
        //add new factory constructor to deck
//        if(c instanceof Equation) {
//
//        }
        for(Component component : c.nodes())
            if(component.nodes() != null)
                nodes.add(new TreeNode(component));
    }
}

class TreeLevel {

}
