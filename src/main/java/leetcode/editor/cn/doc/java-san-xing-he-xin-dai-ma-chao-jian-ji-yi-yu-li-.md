### 解题思路

每个 node 左子树的 next , 就是 node 的右子树
每个 node 右子树的 next, 就是 node next 的 左子树

### 代码

```java

public Node connect(Node root) {
    dfs(root, null);
    return root;
}

private void dfs(Node node, Node next) {
    if(node != null) {
        node.next = next;
        dfs(node.left, node.right);
        dfs(node.right, node.next != null ? node.next.left : null);
    }
}

```