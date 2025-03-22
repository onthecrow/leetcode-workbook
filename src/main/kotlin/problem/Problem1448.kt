package com.onthecrow.problem

import com.onthecrow.entity.TreeNode
import kotlin.math.max

class Problem1448 {

    private var goodNodes: Int = 0

    fun goodNodes(root: TreeNode?): Int {
        dfs(root?.`val` ?: Int.MIN_VALUE, root)
        return goodNodes
    }

    private fun dfs(maxValue: Int, node: TreeNode?) {
        if (node == null) return
        if (node.`val` >= maxValue) goodNodes++

        dfs(max(maxValue, node.`val`), node.left)
        dfs(max(maxValue, node.`val`), node.right)
    }
}
