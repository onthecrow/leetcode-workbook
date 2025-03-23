package problem

import com.onthecrow.entity.TreeNode
import com.onthecrow.problem.Problem102
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

@DisplayName("102: Binary Tree Level Order Traversal")
class Problem102Test : TestCase<Problem102>(Problem102::class) {

    @Test
    fun `Full tree case`() {
        val testTree = TreeNode(3).apply {
            left = TreeNode(9).apply {
                left = TreeNode(10)
            }
            right = TreeNode(20).apply {
                left = TreeNode(15)
                right = TreeNode(7)
            }
        }
        assertEquals(listOf(listOf(3), listOf(9, 20), listOf(10, 15, 7)), testObject.levelOrder(testTree))
    }

    @Test
    fun `Single node case`() {
        val testTree = TreeNode(3)
        assertEquals(listOf(listOf(3)), testObject.levelOrder(testTree))
    }

    @Test
    fun `Empty tree test`() {
        assertEquals(emptyList(), testObject.levelOrder(null))
    }
}