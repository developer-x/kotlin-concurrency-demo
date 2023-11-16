package developerx.examples

import kotlinx.coroutines.*
import kotlinx.coroutines.channels.Channel

/**
 * Example of defining a `CoroutineScope.using` extension  to auto-close
 * a Channel at the conclusion of the block
 */
@OptIn(DelicateCoroutinesApi::class)
fun runAutoCloseExample() = runBlocking {
    val channel = Channel<String>()
    launch {
        using(channel) {
            send("foo")
            send("bar")
            send("foobar")
        }
    }
    while(!channel.isClosedForReceive) {
        println(channel.receive())
    }
}

fun <T> CoroutineScope.using(channel: Channel<T>, block: suspend Channel<T>.() -> Unit) =
        channel.run {
            launch(context = coroutineContext) {
                block()
            }
        }
        .invokeOnCompletion { channel.close() }
