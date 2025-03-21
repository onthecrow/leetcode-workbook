package com.onthecrow.problem

import com.onthecrow.entity.TreeNode

class Problem199 {

    fun rightSideView(root: TreeNode?): List<Int> {
        if (root == null) return listOf()

        val result = mutableListOf<Int>()
        val queue = ArrayDeque<TreeNode>()
        queue.addFirst(root)

        while (queue.isNotEmpty()) {
            repeat(queue.size) { index ->
                val currentElement = queue.removeLast()
                if (index == 0) {
                    result.add(currentElement.`val`)
                }
                currentElement.right?.let { queue.addFirst(it) }
                currentElement.left?.let { queue.addFirst(it) }
            }
        }

        return result
    }
}
