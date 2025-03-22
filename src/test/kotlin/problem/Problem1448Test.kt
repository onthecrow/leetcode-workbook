package problem

import com.onthecrow.entity.TreeNode
import com.onthecrow.problem.Problem1448
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

@DisplayName("1448. Count Good Nodes in Binary Tree")
class Problem1448Test : TestCase<Problem1448>(Problem1448()) {

    @Test
    fun `mixed graph`() {
        val testGraph = TreeNode(
            3,
            left = TreeNode(
                1,
                left = TreeNode(3),
            ),
            right = TreeNode(
                4,
                right = TreeNode(
                    3,
                    left = TreeNode(1),
                    right = TreeNode(5),
                ),
            )
        )
        assertEquals(4, testObject.goodNodes(testGraph))
    }

    @Test
    fun `single element`() {
        val testGraph = TreeNode(3)
        assertEquals(1, testObject.goodNodes(testGraph))
    }

    @Test
    fun `empty graph`() {
        assertEquals(0, testObject.goodNodes(null))
    }
}
