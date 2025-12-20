package binaryTree;

public class Driver {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.left = new TreeNode(6);
        root.left.right.right = new TreeNode(7);

        //                1
        //           2          3
        //       4        5
        //            6       7

        BinaryTree tree = new BinaryTree();
        System.out.println("Tree Height: " + tree.getHeight(root));
        System.out.println("Tree Size: " + tree.getSize(root));
//        System.out.println("Max node is: " + tree.getMax(root));
        System.out.println("Level of Node 4: " + tree.getLevel(root, 4));

        System.out.println("---------- PreOrder Recursion ----------");
        tree.preOrderTraversalRecursion(root);
        System.out.println();
        System.out.println("---------- PreOrder ----------");
        tree.preOrderTraversalStack(root);
        System.out.println();

        System.out.println("---------- InOrder Recursion ----------");
        tree.inOrderTraversalRecursion(root);
        System.out.println();
        System.out.println("---------- InOrder ----------");
        tree.inOrderTraversalStack(root);
        System.out.println();
        System.out.println("---------- PostOrder Recursion ----------");
        tree.postOrderTraversalRecursion(root);
        System.out.println();
        System.out.println("---------- PostOrder ----------");
        tree.postOrderTraversalStack(root);
        System.out.println();
        System.out.println("---------- PostOrder 2 Stacks ----------");
        tree.postOrderTraversalTwoStack(root);
        System.out.println("---------- All in one traversal -----------");
        tree.preInPostInOneTraversalStack(root);
        System.out.println();
        System.out.println("---------- LevelOrder ----------");
        tree.levelOrderTraversal(root);
        System.out.println();
        System.out.println("---------- LevelOrder Recursion ----------");
        tree.levelOrderTraversalRecursion(root);
        System.out.println("---------- LevelOrderLineByLine ----------");
        tree.levelOrderTraversalLineByLine(root);
        System.out.println("---------- VerticalOrder Recursion ----------");
        tree.verticalTraversalRecursion(root);
        System.out.println("---------- DiagonalOrder Recursion ----------");
        tree.diagonalTraversalRecursion(root);
        System.out.println();
        System.out.println("---------- Right View ----------");
        tree.rightView(root);
        System.out.println();
        System.out.println("---------- Left View ----------");
        tree.leftView(root);
        System.out.println();
        System.out.println("---------- Top View ----------");
        tree.topView(root);
        System.out.println();
        System.out.println("---------- Bottom View ----------");
        tree.bottomView(root);
        System.out.println();
        System.out.println("---------- Size ----------");
        tree.getSize(root);
        System.out.println();
        System.out.println("---------- Max Width ----------");
        tree.getMaxWidthUsingIndexing(root);
        System.out.println();
        System.out.println("---------- Height ----------");
        tree.getHeight(root);
        System.out.println();
        System.out.println("---------- Diameter ----------");
        tree.getDiamater(root);
        System.out.println();
        System.out.println("---------- Is Height Balanced ----------");
        tree.isHeightBalanced(root);
        System.out.println();
        System.out.println("---------- Root to Node path ----------");
        tree.rootToNodePath(root, 7);
        System.out.println();
    }
}
