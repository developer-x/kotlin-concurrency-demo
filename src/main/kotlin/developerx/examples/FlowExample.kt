package developerx.examples

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking

/**
 * Example of using Flow to produce an interruptable Stream
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
