package developerx.examples

import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis

/***
 * Example of running tasks within async/await
 */
fun runAsyncExample() = runBlocking {
    val duration1 = measureTimeMillis {
        val result1 = returnSomething("worker1")
        val result2 = returnSomething("worker2")
        println("worker1 = ${result1}, worker2 = $result2")
    }
    println("That took $duration1 milliseconds")

    val duration2 = measureTimeMillis {
        val worker1 = async { returnSomething("worker1") }
        val worker2 = async { returnSomething("worker2") }
        println("worker1 = ${worker1.await()}, worker2 = ${worker2.await()}")
    }
    println("That took $duration2 milliseconds")
}

suspend fun returnSomething(message: String): String {
    delay(1000L)
    return message
}
