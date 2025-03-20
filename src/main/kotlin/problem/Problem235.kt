package com.onthecrow.problem

import com.onthecrow.entity.TreeNode

/**
 * 235. Lowest Common Ancestor of a Binary Search Tree
 *
 * Given a binary search tree (BST), find the lowest common ancestor (LCA) node of two given nodes in the BST.
 *
 * According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as
 * the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”
 *
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree
 */
class Problem235 {

    private var lca: TreeNode? = null

    fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
        if (root == null) return null
        dfs(root, p, q)
        return lca
    }

    private fun dfs(tree: TreeNode?, p: TreeNode?, q: TreeNode?): Boolean {
        if (tree == null) return false
        val left = dfs(tree.left, p, q)
        val right = dfs(tree.right, p, q)
        val isBoth = left && right
        val isOneAndThis = (left || right) && (tree.`val` == p?.`val` || tree.`val` == q?.`val`)
        if (isBoth || isOneAndThis) {
            if (lca == null) {
                lca = tree
            }
        }
        return (tree.`val` == p?.`val` || tree.`val` == q?.`val`) || (left || right)
    }
}