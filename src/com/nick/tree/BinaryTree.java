package com.nick.tree;

public class BinaryTree<AnyType extends Comparable<? super AnyType>> {

    BinaryTreeNode<AnyType> root;

    public boolean contains(AnyType value, BinaryTreeNode<AnyType> node) {
        if (node == null) {
            return false;
        }
        int res = node.element.compareTo(value);
        if (res > 0) {
            return contains(value, node.left);
        } else if (res < 0) {
            return contains(value, node.right);
        } else {
            return true;
        }
    }

    public void insert(AnyType value) {
        if (root == null) {
            root = new BinaryTreeNode(value);
            return;
        }
        insert(new BinaryTreeNode(value), root);
    }

    public BinaryTreeNode<AnyType> remove(AnyType targe) {
        return remove(targe, root);
    }

    private BinaryTreeNode<AnyType> remove(AnyType target, BinaryTreeNode<AnyType> node) {
        if (node == null) {
            return node;
        }
        int cmp = target.compareTo(node.element);
        if (cmp > 0) {
            node.right = remove(target, node.right);
        } else if (cmp < 0) {
            node.left = remove(target, node.left);
        } else if (node.left !=null && node.right !=null){
            node.element = findMin(node.right);
            remove(node.element, node.right);
        } else {
            node = node.left == null ? node.right : node.left;
        }
        return node;
    }

    private AnyType findMin(BinaryTreeNode<AnyType> node) {
        if (node.left == null) {
            return node.element;
        } else {
            return findMin(node.left);
        }
    }

    private void insert(BinaryTreeNode<AnyType> value, BinaryTreeNode<AnyType> node) {
        if (value.element.compareTo(node.element) > 0) {
            if (node.right == null) {
                node.right = value;
            } else {
                insert(value, node.right);
            }
        } else if (value.element.compareTo(node.element) < 0) {
            if (node.left == null) {
                node.left = value;
            } else {
                insert(value, node.left);
            }
        }
    }

    private class BinaryTreeNode<AnyType extends Comparable<? super AnyType>> {
        AnyType element;
        BinaryTreeNode<AnyType> left;
        BinaryTreeNode<AnyType> right;

        public BinaryTreeNode(AnyType element) {
            this.element = element;
        }
    }

    public void show() {
        show(0, root);
    }
    public void show(int depth, BinaryTreeNode<AnyType> element) {
        if (element == null) {
            return;
        }
        show(depth + 1, element.left);
        for (int i = 0; i < depth; i++) {
            System.out.print("\t");
        }
        System.out.println(element.element);
        show(depth + 1, element.right);
    }
}
