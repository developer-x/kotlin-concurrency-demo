package developerx.examples

import kotlinx.coroutines.*
import kotlinx.coroutines.sync.*
import kotlin.system.*

/**
 * Example of using a Mutex to synchronize coroutine's access of shared state
 *
 * Copied from https://github.com/Kotlin/kotlinx.coroutines/blob/master/kotlinx-coroutines-core/jvm/test/guide/example-sync-06.kt
 */
suspend fun massiveRun(action: suspend () -> Unit) {
    val n = 100  // number of coroutines to launch
    val k = 1000 // times an action is repeated by each coroutine
    val time = measureTimeMillis {
        coroutineScope { // scope for coroutines
            repeat(n) {
                launch {
                    repeat(k) { action() }
                }
            }
        }
    }
    println("Completed ${n * k} actions in $time ms")
}

val mutex = Mutex()
var counter = 0

fun runMutexExample() = runBlocking {
    withContext(Dispatchers.Default) {
        massiveRun {
            counter++
        }
    }
    println("Counter without lock = $counter")

    counter = 0
    withContext(Dispatchers.Default) {
        massiveRun {
            mutex.withLock {
                counter++
            }
        }
    }
    println("Counter with lock = $counter")
}
