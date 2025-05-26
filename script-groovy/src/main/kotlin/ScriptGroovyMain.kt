import groovy.lang.GroovyClassLoader
import groovy.lang.GroovyObject
import groovy.lang.GroovyShell
import kotlin.time.measureTime

/**
 * @author Qnxy
 */

private const val SCRIPT = """
    class Fibonacci {
        static def fib(n) {
            if (n <= 1) return n
            def a = 0, b = 1
            (2..n).each {
                (a, b) = [b, a + b]
            }
            return b
        }
    }
"""

fun main() {

    val groovyClassLoader = GroovyClassLoader()
    val fibClass = groovyClassLoader.parseClass(SCRIPT)
    val fibInstance = fibClass.getDeclaredConstructor().newInstance() as GroovyObject

    repeat(10000) {
        fibInstance.invokeMethod("fib", 30)
    }

    measureTime {
        repeat(10000) {
            fibInstance.invokeMethod("fib", 30)
        }
    }.also { println(it) }

}
// 20.999289ms