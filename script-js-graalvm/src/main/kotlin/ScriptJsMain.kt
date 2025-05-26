import org.graalvm.polyglot.Context
import kotlin.time.measureTime

/**
 * @author Qnxy
 */
fun main() {

    Context.create("js").use { ctx ->
        repeat(10000) {

            ctx.eval(
                "js", """
                function fib(n) {
                if (n <= 1) return n;
                let a = 0, b = 1;
                for (let i = 2; i <= n; i++) {
                    [a, b] = [b, a + b];
                }
                return b;
            }
            fib(30);
            """.trimIndent()
            )
        }

        measureTime {
            repeat(10000) {

                ctx.eval(
                    "js", """
                function fib(n) {
                    if (n <= 1) return n;
                    let a = 0, b = 1;
                    for (let i = 2; i <= n; i++) {
                        [a, b] = [b, a + b];
                }
                return b;
                }
            fib(30);
            """.trimIndent()
                )
            }
        }.also { println(it) }

    }
}

// 127.664580ms