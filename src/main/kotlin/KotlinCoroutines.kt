import kotlinx.coroutines.*
import kotlin.concurrent.thread

fun main() = runBlocking{

    println("Main program starts: ${Thread.currentThread().name}")

    val job = launch {
        for(i in 0..500){
            println("$i.")
//            delay(50)
            yield() //or use delay() or any other suspending function as per your need
        }
    }

    delay(10) //printing few values before we cancel
    job.cancel()
    job.join() //waits for coroutine to finish
//    job.cancelAndJoin() you can also use this function instead of the above separate functions

    println("\nMain program ends: ${Thread.currentThread().name}")

}
