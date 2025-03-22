package com.onthecrow.entity

class TreeNode(var `val`: Int = 0) {

    constructor(
        `val`: Int = 0,
        left: TreeNode? = null,
        right: TreeNode? = null,
    ) : this(`val`) {
        this.left = left
        this.right = right
    }

    var left: TreeNode? = null
    var right: TreeNode? = null
}