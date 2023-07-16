import kotlinx.coroutines.*
import kotlin.concurrent.thread

fun main() = runBlocking{

    println("Main program starts: ${Thread.currentThread().name}")
    val jobDeferred: Deferred<Int> = async {    //creates a background coroutine that runs on the main thread
        println("Fake work starts: ${Thread.currentThread().name}")
//    Thread.sleep(1000) //pretend doing some work...maybe file upload
        delay(1000) //better than thread.sleep //Coroutine is suspended but thread T1 is free(not blocked)
        println("Fake work finished: ${Thread.currentThread().name}") //either main thread or some other thread
        15
    }

    //the below thread.slepp blocks the current main thread and wait for the coroutine to finish(practically not the right way to wait)
//    Thread.sleep(2000)

//    mySuspendFun(1000) //main thread: wait for coroutine to finish the execution(practically not the right way to wait)
    //you can also cancel a coroutine using job.cancel()
    val num: Int = jobDeferred.await() //join function will wit for the coroutine to finish the execution only after which the next statement will be exceutred
    println("Main program ends: ${Thread.currentThread().name}")

}

suspend fun myOwnSuspendFun()
{
    delay(1000)
}