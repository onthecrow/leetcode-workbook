package problem

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.Test
import kotlin.reflect.KClass
import kotlin.reflect.full.createInstance
import kotlin.reflect.full.declaredFunctions
import kotlin.reflect.full.findAnnotation
import kotlin.reflect.full.functions


sealed class TestCase<T : Any>(private val testClazz: KClass<T>) {

    var testObject: T = testClazz.createInstance()
        private set


    @BeforeEach
    fun before() {
        testObject = testClazz.createInstance()
    }

    private fun gatherTests(): List<DynamicTest> {
        val testName = this::class.findAnnotation<DisplayName>()?.value ?: this::class.simpleName
        val beforeEachMethods = this::class.functions.filter { it.findAnnotation<BeforeEach>() != null }
        val testMethods = this::class.declaredFunctions.filter { it.findAnnotation<Test>() != null }

        return testMethods.map { method ->
            val methodName = method.findAnnotation<DisplayName>()?.value ?: method.name
            DynamicTest.dynamicTest("$testName -> $methodName") {
                beforeEachMethods.forEach { it.call(this) }
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