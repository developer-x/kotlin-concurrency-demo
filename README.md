# Kotlin Concurrency Examples
This project provides small examples that illustrate different aspects of 
[Kotlin's Concurrency Support](https://kotlinlang.org/docs/coroutines-guide.html).

## Coroutines
[Coroutines](https://kotlinlang.org/docs/coroutines-basics.html#your-first-coroutine) is a lightweight
concurrency framework.  A Coroutine defines an asynchronous unit of work.  Unlike 
Native Threads, a Coroutine is not bound to a particular thread - it can be started/started and assigned 
to different threads.  The Coroutine is typically invoked using the `launch` keyword and returns an instance of a 
[Job](https://kotlinlang.org/api/kotlinx.coroutines/kotlinx-coroutines-core/kotlinx.coroutines/-job/) that allows 
you to either cancel or wait for completion.  A Job is unable to return a value.

* [CoroutineExample](src/main/kotlin/developerx/examples/CoroutineExample.kt)
illustrates an invocation of a suspending function within a Coroutine.

## Channel
Kotlin Coroutines can use [Channels](https://kotlinlang.org/docs/channels.html#channel-basics) to
transmit data between Coroutines and the larger context.  

* [AutoCloseChannelExample](src/main/kotlin/developerx/examples/AutoCloseChannelExample.kt) demonstrates
creating, transmitting, and auto-closing a Channel at the conclusion of the Coroutine. 

## Async/Await 
Kotlin's [async/await](https://kotlinlang.org/docs/composing-suspending-functions.html#concurrent-using-async) allows for 
a Coroutine to return a value.

* [AsyncExample](src/main/kotlin/developerx/examples/AsyncExample.kt) demonstrates the speed improvements of
concurrency and shows a Coroutine wrapped in an `async` invocation that returns a value.

## Flow
Kotlin's [flow](https://kotlinlang.org/docs/flow.html#flows) and 
[channelFlow](https://kotlinlang.org/api/kotlinx.coroutines/kotlinx-coroutines-core/kotlinx.coroutines.flow/channel-flow.html) framework provides the ability for a Coroutine to transmit
an interruptible stream of data.

* [FlowExample](src/main/kotlin/developerx/examples/FlowExample.kt) demonstrates a single
[Flow](https://kotlinlang.org/api/kotlinx.coroutines/kotlinx-coroutines-core/kotlinx.coroutines.flow/-flow/) based stream of data.
* [ChannelFlowExample](src/main/kotlin/developerx/examples/ChannelFlowExample.kt) demonstrates
concurrent streams of data using [channelFlow](https://kotlinlang.org/api/kotlinx.coroutines/kotlinx-coroutines-core/kotlinx.coroutines.flow/channel-flow.html).

## Shared State
Kotlin supports protecting shared state using the 
[Mutex](https://kotlinlang.org/docs/shared-mutable-state-and-concurrency.html#mutual-exclusion) class
for Coroutines and the [@Synchronized Annotation](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-synchronized/)
for [Native Threading](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.concurrent/thread.html)

* [MutexExample](src/main/kotlin/developerx/examples/MutexExample.kt) demonstrates using the `Mutex`
Class to synchronize state access within a Coroutine.
* [SynchronizedStateExample](src/main/kotlin/developerx/examples/SynchronizedStateExample.kt) demonstration
using the `@Synchronized` annotation to synchronize state access within Native Threading.

## Running the Demo
From the command line, issue `./gradlew run`.
