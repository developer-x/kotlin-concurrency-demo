package developerx.examples

import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis

/***
 * Example of running tasks within async/await
 */
fun runAsyncExample() = runBlocking {

    val duration1 = measureTimeMillis {
        val result1 = doSomething("worker1")
        val result2 = doSomething("worker2")
        println("worker1 = ${result1}, worker2 = $result2")
    }
    println("That took $duration1 milliseconds")

    val duration2 = measureTimeMillis {
        val worker1 = async { doSomething("worker1") }
        val worker2 = async { doSomething("worker2") }
        println("worker1 = ${worker1.await()}, worker2 = ${worker2.await()}")
    }
    println("That took $duration2 milliseconds")

}

fun runAsyncReturnExample() = runBlocking {

    val worker1 = async { returnSomething(2) }
    val worker2 = async { returnSomething(3) }
    println("worker1 returned = ${worker1.await()}, worker2 returned = ${worker2.await()}")

}

suspend fun doSomething(message: String): String {
    delay(1000L)
    return message
}

fun returnSomething(value: Int) = value
