package problem

import com.onthecrow.entity.TreeNode
import com.onthecrow.problem.Problem235
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("235. Lowest Common Ancestor of a Binary Search Tree")
class Problem235Test : TestCase<Problem235>(Problem235()) {

    private val testTree by lazy {
        TreeNode(6).apply {
            left = TreeNode(2).apply {
                left = TreeNode(0)
                right = TreeNode(4).apply {
                    left = TreeNode(3)
                    right = TreeNode(5)
                }
            }
            right = TreeNode(8).apply {
                left = TreeNode(7)
                right = TreeNode(9)
            }
        }
    }

    @Test
    fun `first case`() {
        val resultTreeNode = Problem235().lowestCommonAncestor(testTree, TreeNode(2), TreeNode(8))
        assertEquals(6, resultTreeNode?.`val`)
    }

    @Test
    fun `second case`() {
        val resultTreeNode = Problem235().lowestCommonAncestor(testTree, TreeNode(2), TreeNode(4))
        assertEquals(2, resultTreeNode?.`val`)
    }

    @Test
    fun `third case`() {
        val treeNode = TreeNode(2).apply {
            left = TreeNode(1)
        }
        val resultNode = Problem235().lowestCommonAncestor(treeNode, TreeNode(2), TreeNode(1))
        assertEquals(2, resultNode?.`val`)
    }
}