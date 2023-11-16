package developerx.examples

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking

/**
 * Example of using Flow to produce an interruptible stream of data
 */
fun exampleFlow(): Flow<Int> = flow {
        repeat(20) {
            emit(it)
        }
}

fun runFlowExample() = runBlocking {
    exampleFlow()
        .collect {
            println(it)
        }
}
