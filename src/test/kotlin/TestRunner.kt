import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.TestFactory
import problem.TestCase

@DisplayName("Test Runner")
class TestRunner {
    @TestFactory
    fun `All Tests`() = TestCase.runAllTests()
}
