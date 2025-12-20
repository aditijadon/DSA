package binaryTree;

import java.util.*;

public class BinaryTree {
    private int diameter = 0;
//  --------------------------- DFS Recursion ----------------------------------------

    void preOrderTraversalRecursion(TreeNode root) {  // USING RECURSION (DFS)
        if (root == null) return;
        System.out.print(root.val + " ");
        preOrderTraversalRecursion(root.left);
        preOrderTraversalRecursion(root.right);
    }

    void inOrderTraversalRecursion(TreeNode root) {  // USING RECURSION (DFS)
        if (root == null) return;
        inOrderTraversalRecursion(root.left);
        System.out.print(root.val + " ");
        inOrderTraversalRecursion(root.right);
    }

    void postOrderTraversalRecursion(TreeNode root) {  // USING RECURSION (DFS)
        if (root == null) return;
        postOrderTraversalRecursion(root.left);
        postOrderTraversalRecursion(root.right);
        System.out.print(root.val + " ");
    }

//  --------------------------- DFS Stack ----------------------------------------

    void preOrderTraversalStack(TreeNode root) {  // USING STACK (DFS)
        if (root == null) return;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode curr = stack.pop();
            System.out.print(curr.val + " ");
            if (curr.right != null)
                stack.push(curr.right);
            if (curr.left != null)
                stack.push(curr.left);
        }
    }

    void preOrderTraversalBetterStack(TreeNode root) {  // USING STACK (DFS)
        if (root == null) return;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (!stack.isEmpty() || curr != null) {
            while(curr != null){
                System.out.println(curr.val + " ");
                if (curr.right != null) stack.push(curr.right);
                curr = curr.left;
            }
            if(!stack.isEmpty()) curr = stack.pop();
        }
    }

    void inOrderTraversalStack(TreeNode root) {  // USING STACK (DFS)
        if (root == null) return;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            System.out.print(curr.val + " ");  // Printing after push makes it preOrder
            curr = curr.right;
        }
    }

    void postOrderTraversalTwoStack(TreeNode root) {  // SAME AS PREORDER BUT USING 2 STACKS
        if (root == null) return;
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.push(root);
        TreeNode curr;
        while (!stack1.isEmpty()) {
            curr = stack1.pop();
            stack2.push(curr);
            if (curr.left != null)
                stack1.push(curr.left);
            if (curr.right != null)
                stack1.push(curr.right);
        }
        while (!stack2.isEmpty()) {
            curr = stack2.pop();
            System.out.print(curr.val + " ");
        }
    }

    void postOrderTraversalStack(TreeNode root) {  // USING ONE STACK (DFS)
        if (root == null) return;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (true) {
            while (curr != null) {
                stack.push(curr);
                stack.push(curr);
                curr = curr.left;
            }
            if (stack.empty()) return;
            curr = stack.pop();
            if (!stack.empty() && stack.peek() == curr) {
                curr = curr.right;
            } else {
                System.out.print(curr.val + " ");
                curr = null;
            }
        }
    }

    void preInPostInOneTraversalStack(TreeNode root){
        if (root == null) return;
        Stack<Pair> stack = new Stack<>();
        stack.push(new Pair(root,1));
        List<TreeNode> pre = new ArrayList<>();
        List<TreeNode> in = new ArrayList<>();
        List<TreeNode> post = new ArrayList<>();

        while(!stack.isEmpty()){
            Pair curr = stack.pop();
            if(curr.getValue() == 1){
                pre.add(curr.getKey());
                stack.push(new Pair(curr.getKey(), 2));
                if(curr.getKey().left != null) stack.push(new Pair(curr.getKey().left,1));
            }

            if(curr.getValue() == 2){
                in.add(curr.getKey());
                stack.push(new Pair(curr.getKey(), 3));
                if(curr.getKey().right != null) stack.push(new Pair(curr.getKey().right,1));
            }

            if(curr.getValue() == 3){
                post.add(curr.getKey());
            }
        }
        printList(pre);
        printList(in);
        printList(post);
    }

//    --------------------------- DFS Morris ----------------------------------------

    void preOrderMorris(TreeNode root){
        if (root == null) return;
        TreeNode curr = root;
        while(curr != null){
            if(curr.left == null){
                System.out.println(curr.val);
                curr = curr.right;
            }
            else {
                TreeNode predecessor = curr.left;
                while(predecessor.right != null && predecessor.right != curr){
                    predecessor = predecessor.right;
                }

                if(predecessor.right == null){
                    predecessor.right = curr;
                    System.out.print(curr.val);
                    curr = curr.left;
                }

                else {
                    predecessor.right = null;
                    curr = curr.right;
                }
            }
        }
    }

    void inOrderMorris(TreeNode root){
        if (root == null) return;
        TreeNode curr = root;
        while(curr != null){
            if(curr.left == null){
                System.out.println(curr.val);
                curr = curr.right;
            }
            else {
                TreeNode predecessor = curr.left;
                while(predecessor.right != null && predecessor.right != curr){
                    predecessor = predecessor.right;
                }

                if(predecessor.right == null){
                    predecessor.right = curr;
                    curr = curr.left;
                }

                else {
                    predecessor.right = null;
                    System.out.print(curr.val);
                    curr = curr.right;
                }
            }
        }
    }

//    --------------------------- BFS Iterative ----------------------------------------

    void levelOrderTraversal(TreeNode root) {  // SAME AS PREORDER BUT WITH QUEUE
        if (root == null) return;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            System.out.print(curr.val + " ");
            if (curr.left != null)
                queue.add(curr.left);
            if (curr.right != null)
                queue.add(curr.right);
        }
    }

    void levelOrderTraversalLineByLine(TreeNode root) {
        if (root == null) return;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int currLevel = 0;
        while (!queue.isEmpty()) {
            int len = queue.size();
            System.out.print("level " + currLevel + ": ");
            for (int i = 0; i < len; i++) {
                TreeNode current = queue.poll();
                System.out.print(current.val + " ");
                if (current.left != null)
                    queue.add(current.left);
                if (current.right != null)
                    queue.add(current.right);
            }
            currLevel++;
            System.out.println();
        }
    }

//    --------------------------- BFS Recursion ----------------------------------------

    void levelOrderTraversalRecursion(TreeNode root){  // LEVEl ORDER = BFS
        Map<Integer, List<Integer>> map = new HashMap();   // USE LIST WHEN LEVEL NUMBER NOT REQUIRED
        levelOrderRec(root, 0, map);
        map.forEach((k,v) -> {
            System.out.print("level " + k + ": ");
            v.forEach(va -> System.out.print(va + " "));
            System.out.println();
        });
    }

    void levelOrderRec(TreeNode node, int level, Map<Integer, List<Integer>> map) {
        if (node == null) return;
        if (map.get(level) == null) map.put(level, new ArrayList<>());
        map.get(level).add(node.val);
        levelOrderRec(node.left, level + 1, map);
        levelOrderRec(node.right, level + 1, map);
    }

    void verticalTraversalRecursion(TreeNode root) {
        Map<Integer, List<Integer>> res = new HashMap();  // USE MAP WHEN LEVEL NUMBER NOT REQUIRED
        verticalOrderRec(root, 0, res);
        res.forEach((k,v) -> {
            System.out.print("level " + k + ": ");
            v.forEach(va -> System.out.print(va + " "));
            System.out.println();
        });
    }

    void verticalOrderRec (TreeNode node, int level, Map<Integer, List<Integer>> res) {
        if (node == null) return;
        if (res.get(level) == null) res.put(level, new ArrayList<>());
        res.get(level).add(node.val);
        verticalOrderRec(node.left, level - 1, res);
        verticalOrderRec(node.right, level + 1, res);
    }

    void diagonalTraversalRecursion(TreeNode root) {
        Map<Integer, List<Integer>> res = new HashMap();
        diagonalOrderRec(root, 0, res);
        res.forEach((k,v) -> {
            System.out.print("level " + k + ": ");
            v.forEach(va -> System.out.print(va + " "));
            System.out.println();
        });
    }

    void diagonalOrderRec (TreeNode node, int level, Map<Integer, List<Integer>> res) {
        if (node == null) return;
        if (res.get(level) == null) res.put(level, new ArrayList<>());
        res.get(level).add(node.val);
        diagonalOrderRec(node.left, level + 1, res);
        diagonalOrderRec(node.right, level, res);
    }

    void boundaryTreversal(TreeNode node){

    }

    void zigzagTraversal(TreeNode node){}

//  -------------------------------------------- VIEWS ---------------------------------------------------------

    void rightView(TreeNode root) {
        Map<Integer, Integer> map = new HashMap();   // USE LIST WHEN LEVEL NUMBER NOT REQUIRED
        rightViewImpl(root, 0, map);
        System.out.print("right view : ");
        map.forEach((k,v) -> {
            System.out.print(v + " ");
        });
    }

    void rightViewImpl(TreeNode root, int level, Map<Integer, Integer> map){
        if(root == null) return;
        map.put(level, root.val);
        rightViewImpl(root.left, level+1, map);
        rightViewImpl(root.right, level+1, map);
    }

    void leftView(TreeNode root) {
        Map<Integer, Integer> map = new HashMap();   // USE LIST WHEN LEVEL NUMBER NOT REQUIRED
        leftViewImpl(root, 0, map);
        System.out.print("left view : ");
        map.forEach((k,v) -> {
            System.out.print(v + " ");
        });
    }

    void leftViewImpl(TreeNode root, int level, Map<Integer, Integer> map){
        if(root == null) return;
        map.putIfAbsent(level, root.val);
        leftViewImpl(root.left, level+1, map);
        leftViewImpl(root.right, level+1, map);
    }

    void topView(TreeNode root) {
        Map<Integer, Integer> map = new TreeMap<>();   // USE LIST WHEN LEVEL NUMBER NOT REQUIRED
        topViewImpl(root, 0, map);
        System.out.print("top view: ");
        map.values().forEach(val -> System.out.print(val + " "));
        System.out.println();
    }

    void topViewImpl(TreeNode root, int level, Map<Integer, Integer> map){
        if(root == null) return;
        map.putIfAbsent(level, root.val);
        topViewImpl(root.left, level-1, map);
        topViewImpl(root.right, level+1, map);
    }

    void bottomView(TreeNode root) {
        Map<Integer, Integer> map = new TreeMap<>();   // USE LIST WHEN LEVEL NUMBER NOT REQUIRED
        bottomViewImpl(root, 0, map);
        System.out.print("bottom view : ");
        map.forEach((k,v) -> {
            System.out.print(v + " ");
        });
    }

    void bottomViewImpl(TreeNode root, int level, Map<Integer, Integer> map){
        if(root == null) return;
        map.put(level, root.val);
        bottomViewImpl(root.left, level-1, map);
        bottomViewImpl(root.right, level+1, map);
    }

//  --------------------------------------------- BASIC --------------------------------------------------

    int getSize(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        return getSize(root.left) + getSize(root.right) + 1;
    }

    int getHeight(TreeNode root) {
        if (root == null) return -1;
        if (root.left == null && root.right == null) return 0;
        return Math.max(getHeight(root.left) + 1, getHeight(root.right) + 1);
    }

    int getHeightWithDiameter(TreeNode root){
        if(root == null) return 0;
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        diameter = Math.max(diameter, leftHeight + rightHeight);
        return Math.max(leftHeight, rightHeight) + 1;
    }

    int getDiamater(TreeNode root){
        int diameter = 0;
        getHeightWithDiameter(root);
        return diameter;
    }

    boolean isHeightBalanced(TreeNode root){
        return isBalancedHelper(root) != -1;
    }

    int isBalancedHelper(TreeNode root){
        if(root == null) return 0;
        int leftHeight = isBalancedHelper(root.left);
        if (leftHeight == -1) return -1;
        int rightHeight = isBalancedHelper(root.right);
        if (rightHeight == -1) return -1;
        if (Math.abs(leftHeight - rightHeight) > 1) return -1;
        return Math.max(leftHeight, rightHeight) + 1;
    }

    int getMaxWidthUsingIndexing(TreeNode root){
        return 0;
//        return Math.max(getSize(root.left) + getSize(root.right));
    }

//  --------------------------------------- TWO TREES --------------------------------------------------

    boolean isIdentical(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null) return root1 == root2;
        return isIdentical(root1.left, root2.left) && isIdentical(root1.right, root2.right) && root1.val == root2.val;
    }

    boolean isMirror(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null) return root1 == root2;
        return isMirror(root1.left, root2.right) && isMirror(root1.right, root2.left) && root1.val == root2.val;
    }

    boolean isSymmetric(TreeNode root){
        return root == null || isMirror(root.left, root.right);
    }

    boolean isPerfect() {
        return true;
    }

    boolean isCousins() {
        return true;
    }

//  --------------------------------------- MISC -------------------------------------------------

    TreeNode LCA(TreeNode node){
        return node;
    }

    int getLevel(TreeNode root, int node) {
        return getLevelImpl(root, node, 0);
    }

    int getLevelImpl(TreeNode root, int node, int level) {
        if (root == null) return -1;
        if (root.val == node) return level;
        int leftLevel = getLevelImpl(root.left, node, level + 1);
        if (leftLevel != -1) {
            return leftLevel;
        }
        return getLevelImpl(root.right, node, level + 1);
    }

    List<Integer> rootToNodePath(TreeNode root, int node){
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        getPath(root, res, node);
        return res;
    }

    boolean getPath(TreeNode root, List<Integer> res, int node){
        if(root == null) return false;
        res.add(root.val);
        if(root.val == node) return true;
        if(getPath(root.left, res, node) || getPath(root.right, res, node)) return true;
        res.remove(res.size()-1);
        return false;
    }

//    ------------------------------- Util --------------------------------

    void printList(List<TreeNode> l){
        l.stream().forEach(a -> System.out.print(a.val + " "));
        System.out.println();
    }
}
