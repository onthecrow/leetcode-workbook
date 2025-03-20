package com.onthecrow.problem

import com.onthecrow.entity.TreeNode

/**
 * 102. Binary Tree Level Order Traversal
 *
 * Given the root of a binary tree, return the level order traversal of its nodes' values.
 * (i.e., from left to right, level by level).
 * https://leetcode.com/problems/binary-tree-level-order-traversal
 */
class Problem102 {

    fun levelOrder(root: TreeNode?): List<List<Int>> {
        if (root == null) return emptyList()

        val result = mutableListOf<List<Int>>()
        val queue = ArrayDeque<TreeNode>()
        queue.addFirst(root)

        while (!queue.isEmpty()) {
            val levelList = mutableListOf<Int>()
            repeat(queue.size) {
                val currentNode = queue.removeLast()
                currentNode.left?.let { queue.addFirst(it) }
                currentNode.right?.let { queue.addFirst(it) }
                levelList.add(currentNode.`val`)
            }
            result.add(levelList)
        }

        return result
    }
}