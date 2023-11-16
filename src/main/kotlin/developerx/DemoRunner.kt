package developerx

import developerx.examples.*

fun main() {
    println("Running Coroutine Example...")
    runCoroutineExample()

    println("\nRunning AsyncReturn Example...")
    runAsyncReturnExample()

    println("\nRunning Async Example...")
    runAsyncExample()

    println("\nRunning AutoCloseChannel Example...")
    runAutoCloseExample()

    println("\nRunning Mutex Example...")
    runMutexExample()

    println("\nRunning SynchronizedState Example...")
    runSynchronizedStateExample()

    println("\nRunning ChannelFlow Example...")
    runChannelFlowExample()

    println("\nRunning Flow Example...")
    runFlowExample()
}
