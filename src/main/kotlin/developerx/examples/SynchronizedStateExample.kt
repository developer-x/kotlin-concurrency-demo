package developerx.examples

import kotlinx.coroutines.runBlocking
import kotlin.concurrent.thread

/**
 * Example of using the @Synchronized annotation to synchronize native Thread access to Shared State
 */
class SynchronizedStateExample {

    var state = 0

    fun unsynchronized() {
        this.state += 1
    }

    @Synchronized
    fun synchronized() {
        this.state += 1
    }

}

fun runSynchronizedStateExample() = runBlocking {
    val unSynchronizedState = SynchronizedStateExample()
    val worker1 = thread(start = true) {
        repeat(100000) { unSynchronizedState.unsynchronized() }
    }
    val worker2 = thread(start = true) {
        repeat(100000) { unSynchronizedState.unsynchronized() }
    }
    worker1.join()
    worker2.join()
    println("Unsynchronized State is ${unSynchronizedState.state}")

    val synchronizedState = SynchronizedStateExample()
    val worker3 = thread(start = true)  {
        repeat(100000) { synchronizedState.synchronized() }
    }
    val worker4 = thread(start = true)  {
        repeat(100000) { synchronizedState.synchronized() }
    }
    worker3.join()
    worker4.join()
    println("Synchronized State is ${synchronizedState.state}")
}
