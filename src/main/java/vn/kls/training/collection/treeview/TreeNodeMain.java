package vn.kls.training.collection.treeview;


import java.util.Arrays;
import java.util.Scanner;

public class TreeNodeMain {

    private static final String ROOT = "___root___";

    /**
     * Node gốc của cây
     */
    private final TreeNode root = new TreeNode(ROOT);

    public static void main(String[] args) {
        System.out.println("Tree example");
        System.out.println("===================================");
        System.out.println();

        var app = new TreeNodeMain();
        app.run();

        System.out.println();
        System.out.println("===================================");
        System.out.println("Bye");
    }

    private void run() {
        populateSampleTree();
        showTree(root, -1);


        // Tìm kiếm trên tree
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.println("\n\nNhập chuỗi ký tự để tìm kiếm trong cây. Nhập `exit` để thoát");
            String s = in.nextLine();

            if ("exit".equalsIgnoreCase(s)) {
                break;
            }

            searchTree(s, root);
        }
    }

    /**
     * Sample tree: https://learn.microsoft.com/en-us/windows/apps/design/controls/images/treeview-selection.png
     */
    private void populateSampleTree() {

        var workNode = new TreeNode("Work Documents", Arrays.asList(
                new TreeNode("XYZ Functional Spec"),
                new TreeNode("Feature Schedule"),
                new TreeNode("Overall project plan"),
                new TreeNode("Feature Resource Allocation", Arrays.asList(
                        new TreeNode("Child 1", Arrays.asList(
                                new TreeNode("Child 1.1"),
                                new TreeNode("Child 1.2")
                        )),
                        new TreeNode("Child 2"),
                        new TreeNode("Child 3", Arrays.asList(
                                new TreeNode("Child 3.1"),
                                new TreeNode("Child 3.2"),
                                new TreeNode("Child 3.3")
                        ))
                ))
        ));

        var personalDocumentNode = new TreeNode("Personal Documents", Arrays.asList(
                new TreeNode("Home Remodel", Arrays.asList(
                        new TreeNode("Contractor Contact Info"),
                        new TreeNode("Paint Color Scheme"),
                        new TreeNode("Flooring woodgrain type"),
                        new TreeNode("Kitchen cabinet style")
                ))
        ));

        root.setChildren(Arrays.asList(
                workNode,
                personalDocumentNode
        ));
    }

    /**
     * @param node  TreeNode cần in thông tin ra màn hình
     * @param level Level của node, bắt đầu từ 0
     */
    private void showTree(TreeNode node, int level) {

        if (node == null) return;

        // Lưu ý: Không in node gốc, do node gốc chỉ dùng để quản lý không cần in ra màn hình
        if (!ROOT.equals(node.getNodeName())) {

            // khoảng thụt vào đầu dòng
            // level 0 sẽ không thụt vào
            // level 1 sẽ thụt vào N spaces
            // level 2 sẽ thụt vào 2N spaces
            // level 3 sẽ thụt vào 3N spaces
            // ...
            var prefix = "    ".repeat(level);

            System.out.println(prefix + node.getNodeName());
        }

        // lặp đệ quy để in thông tin của các node con
        for (var child : node.getChildren()) {
            showTree(child, level + 1);
        }
    }

    private void searchTree(String textToSearch, TreeNode node) {

        if (textToSearch == null || textToSearch.isBlank()) return;
        if (node == null) return;

        // lưu ý: đang sử dụng toLowerCase để demo cách tìm kiếm không phân biệt chữ hoa/thường
        // nhưng đây là cách làm có performance chưa tối ưu nhất
        // xem thêm: https://stackoverflow.com/questions/86780/how-to-check-if-a-string-contains-another-string-in-a-case-insensitive-manner-in#answer-25379180
        if (!ROOT.equals(node.getNodeName()) && node.getNodeName().toLowerCase().contains(textToSearch.toLowerCase())) {
            System.out.println(node.getNodeName());
        }

        // lặp đệ quy để tiếp tục tìm trong các node con
        for (var child : node.getChildren()) {
            searchTree(textToSearch, child);
        }
    }
}