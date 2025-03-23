package problem

import com.onthecrow.entity.TreeNode
import com.onthecrow.problem.Problem199
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

@DisplayName("199: Binary Tree Right Side View")
class Problem199Test : TestCase<Problem199>(Problem199::class) {

    @Test
    fun `balanced tree`() {
        val testTree = TreeNode(1).apply {
            left = TreeNode(2).apply {
                right = TreeNode(5)
            }
            right = TreeNode(3).apply {
                right = TreeNode(4)
            }
        }
        assertEquals(listOf(1, 3, 4), testObject.rightSideView(testTree))
    }

    @Test
    fun `left-skewed tree`() {
        val testTree = TreeNode(1).apply {
            left = TreeNode(2).apply {
                left = TreeNode(4).apply {
                    left = TreeNode(5)
                }
            }
            right = TreeNode(3)
        }
        assertEquals(listOf(1, 3, 4, 5), testObject.rightSideView(testTree))
    }

    @Test
    fun `empty tree`() {
        assertEquals(listOf(), testObject.rightSideView(null))
    }
}
