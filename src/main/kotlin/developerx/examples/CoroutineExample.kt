package developerx.examples

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

suspend fun printMessage(message: String) {
    delay(100)
    println(message)
}

fun runCoroutineExample() = runBlocking {
    launch {
        printMessage("launch 1")
    }
    launch {
        printMessage("launch 2")
    }
}
