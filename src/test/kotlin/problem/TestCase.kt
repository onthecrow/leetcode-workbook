package problem

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.Test
import kotlin.reflect.full.declaredFunctions
import kotlin.reflect.full.findAnnotation


sealed class TestCase<T>(val testObject: T) {

    private fun gatherTests(): List<DynamicTest> {
        val testName = this::class.findAnnotation<DisplayName>()?.value ?: this::class.simpleName
        val testMethods = this::class.declaredFunctions.filter { it.findAnnotation<Test>() != null }

        return testMethods.map { method ->
            val methodName = method.findAnnotation<DisplayName>()?.value ?: method.name
            DynamicTest.dynamicTest("$testName -> $methodName") {
                method.call(this)
            }
        }
    }

    companion object {
        fun runAllTests(): List<DynamicTest> {
            val subclasses = TestCase::class.sealedSubclasses

            return subclasses.flatMap {
                val instance = it.objectInstance ?: it.constructors.first().call()
                instance.gatherTests()
            }
        }
    }
}