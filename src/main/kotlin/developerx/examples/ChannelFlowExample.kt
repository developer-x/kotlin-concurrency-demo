package developerx.examples

import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.channelFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * Example of using channelFlow to concurrently produce
 * multiple interruptible streams of data
 */
@OptIn(DelicateCoroutinesApi::class)
fun channelFlows() = channelFlow {
    val job1 = GlobalScope.launch {
        repeat(100) {
            send(it)
        }
    }
    val job2 = GlobalScope.launch {
        repeat(100) {
            send(it + 100)
        }
    }
    job1.join()
    job2.join()
}

fun runChannelFlowExample() = runBlocking {
    channelFlows()
        .collect {
            println(it)
        }
}
