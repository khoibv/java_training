package vn.kls.training.collection.treeview;

import java.util.ArrayList;
import java.util.List;

public class TreeNode {
    /**
     * Tên node
     */
    private String nodeName;

    /**
     * Các node con
     */
    private List<TreeNode> children;


    public TreeNode(String nodeName, List<TreeNode> children) {
        this.nodeName = nodeName;
        this.children = children;
    }

    public TreeNode(String nodeName) {
        this(nodeName, new ArrayList<>());
    }

    public String getNodeName() {
        return nodeName;
    }

    public void setNodeName(String nodeName) {
        this.nodeName = nodeName;
    }

    public List<TreeNode> getChildren() {
        return children;
    }

    public void setChildren(List<TreeNode> children) {
        this.children = children;
    }
}
