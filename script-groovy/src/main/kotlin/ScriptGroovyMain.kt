import groovy.lang.GroovyShell
import kotlin.time.measureTime

/**
 * @author Qnxy
 */

fun main() {

    val groovyShell = GroovyShell()

    repeat(10000) {
        groovyShell.evaluate(
            """
            static def fib(n) {
                if (n <= 1) return n
                def a = 0, b = 1
                (2..n).each {
                    (a, b) = [b, a + b]
                }
                return b
            }
            
            fib(30)
        """.trimIndent()
        )
    }

    measureTime {
        repeat(10000) {
            groovyShell.evaluate(
                """
            static def fib(n) {
                if (n <= 1) return n
                def a = 0, b = 1
                (2..n).each {
                    (a, b) = [b, a + b]
                }
                return b
            }
            
            fib(30)
            """.trimIndent()
            )
        }
    }.also { println(it) }

}
// 13.337640055s