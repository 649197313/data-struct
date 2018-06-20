package com.nick.skip;

import java.util.Random;

public class SkipList {
    public static  final double PROBALITY = 0.5;

    private int size;
    private int level;
    private SkipListNode head;
    private Random random;

    public SkipList() {
        size = 0;
        level = 0;
        head = new SkipListNode(Integer.MAX_VALUE, null);
        random = new Random();
    }

    public void insert(int key, Object value) {
        // 构建新的Node
        SkipListNode node = new SkipListNode(key, value);
        SkipListNode real = find(node);
        if (real != null) {
            real.value = value;
            return;
        }
        // 左边连接
        SkipListNode left = findLeft(node);
        linkHorizontal(left, node);

        int currentLevel = 0;
        // 添加层数
        while (random.nextDouble() > PROBALITY) {
            // 如果高于了最大层数，head节点要添加节点。
            if (++currentLevel > level) {
                SkipListNode h = new SkipListNode(Integer.MAX_VALUE, null);
                linkVertical(h, head);
                head = h;
                level++;
            }
            while (left.up == null) {
                left = left.left;
            }
            // 注意，每次添加节点才会上升一层，如果上一层为空了，则左移一次
            left = left.up;
            SkipListNode n = new SkipListNode(key, null);
            linkHorizontal(left, n);
            linkVertical(n, node);
            node = n;
        }

        this.size++;
    }

    private void linkVertical(SkipListNode up, SkipListNode down) {
        up.down = down;
        down.up = up;
    }

    private void linkHorizontal(SkipListNode left, SkipListNode node) {
        if (left.right != null) {
            node.right = left.right;
            left.right.left = node;
        }
        left.right = node;
        node.left = left;
    }
    // 查找左侧节点，注意循环退出的条件
    private SkipListNode findLeft(SkipListNode node) {
        SkipListNode p = head;
        while (true) {
            while (p.right != null && p.right.key <= node.key) {
                p = p.right;
            }
            if (p.down != null) {
                p = p.down;
            } else {
                return p;
            }
        }
    }

    private SkipListNode find(SkipListNode node) {
        SkipListNode s = findLeft(node);
        if (s.key == node.key) {
            return node;
        }
        return null;
    }

    public void asString() {
        // 找到head的最底层节点
        SkipListNode p = head;
        while (p.down != null) {
            p = p.down;
        }
        while (p.right != null) {
            p = p.right;
            SkipListNode tmp = p;
            while (tmp != null) {
                System.out.print(tmp.key + "\t");
                tmp = tmp.up;
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        SkipList skipList = new SkipList();
        skipList.insert(1, "中文");
        skipList.insert(3, "中文");
        skipList.insert(2, "中文");
        skipList.insert(5, "中文");
        skipList.insert(8, "中文");
        skipList.insert(4, "中文");
        skipList.insert(7, "中文");
        skipList.insert(6, "中文");
        skipList.asString();
    }

}
