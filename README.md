# Kotlin Concurrency Examples
The project provides small examples that illustrate different aspects of 
[Kotlin's Concurrency Support](https://kotlinlang.org/docs/coroutines-guide.html)

## Coroutines
[Coroutines](https://kotlinlang.org/docs/coroutines-basics.html#your-first-coroutine) is a lightweight
concurrency framework.  A Coroutine defines an asynchronous unit of work.  Unlike 
Native Threads, a Coroutine is not bound to particular thread - it can be started/started and assigned 
to different threads.  The unit of work is invoked using the `launch` keyword and returns an instance of a Job to either
cancel or wait for completion.  A Job is unable to return a value.

* [CoroutineExample](src/main/kotlin/developerx/examples/CoroutineExample.kt)
illustrates invocation of a suspending function within a Coroutine.

## Channel
Kotlin Coroutines can use [Channels](https://kotlinlang.org/docs/channels.html#channel-basics) to
transmit data between coroutines and the larger context.  

* [AutoCloseChannelExample](src/main/kotlin/developerx/examples/AutoCloseChannelExample.kt) demonstrates
creating, transmitting, and auto-closing a Channel at the conclusion of the Job. 

## Async/Await 
Kotlin's [async/await](https://kotlinlang.org/docs/composing-suspending-functions.html#concurrent-using-async) allows for a unit or work to return
a value.

* [AsyncExample](src/main/kotlin/developerx/examples/AsyncExample.kt) demonstrates
an asynchronous unit of work which returns a string and prints out the results of multiple invocations.

## Flow
Kotlin's [flow](https://kotlinlang.org/docs/flow.html#flows) and 
[channelFlow](https://kotlinlang.org/api/kotlinx.coroutines/kotlinx-coroutines-core/kotlinx.coroutines.flow/channel-flow.html) framework provides the ability for an asynchronous unit of work to transmit
an interruptible stream of data between asynchronous units of work

* [FlowExample](src/main/kotlin/developerx/examples/FlowExample.kt) demonstrates a single Flow based stream of data 
* [ChannelFlowExample](src/main/kotlin/developerx/examples/ChannelFlowExample.kt) demonstrates
concurrent streams of data using a ChannelFlow

## Shared State
Kotlin supports protecting shared state using the 
[Mutex](https://kotlinlang.org/docs/shared-mutable-state-and-concurrency.html#mutual-exclusion) class
for Coroutines and the [@Synchronized Annotation](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-synchronized/)
for [Native Threading](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.concurrent/thread.html)

* [MutexExample](src/main/kotlin/developerx/examples/MutexExample.kt) demonstrates using the `Mutex`
Class to synchronize state access within a Coroutine
* [SynchronizedStateExample](src/main/kotlin/developerx/examples/SynchronizedStateExample.kt) demonstration
using the `@Synchronized` annotation to synchronize state access within Native Threading