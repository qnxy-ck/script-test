import com.qnxy.FibInterface
import java.io.File
import java.net.URLClassLoader
import java.util.*
import kotlin.time.measureTime

/**
 * @author Qnxy
 */

fun main() {

    val jarFile = File("${System.getProperty("user.dir")}/script-java-jar/application/libs/java-jar-1.0-SNAPSHOT.jar")
    if (!jarFile.exists()) {
        throw IllegalArgumentException("Jar file not found: ${jarFile.absolutePath} -> You'll need to execute the build task first")
    }

    val urlClassLoader = URLClassLoader(
        arrayOf(jarFile.toURI().toURL()),
        FibInterface::class.java.classLoader
    )

    val fibInterface = ServiceLoader.load(FibInterface::class.java, urlClassLoader).first()


    repeat(10000) {
        fibInterface.fib(30)
    }

    measureTime {
        repeat(10000) {
            fibInterface.fib(30)
        }
    }.also { println(it) }


}

// 453.181us