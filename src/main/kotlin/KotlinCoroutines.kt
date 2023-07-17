import kotlinx.coroutines.*
import kotlin.concurrent.thread
import kotlin.system.measureTimeMillis

fun main() = runBlocking{
    println("Main program starts: ${Thread.currentThread().name}")

    val time = measureTimeMillis {
        val msgOne: Deferred<String> = async { getMessageOne() }
        val msgTwo: Deferred<String> = async { getMessageTwo() }
        println("The entire message is: ${msgOne.await()+msgTwo.await()}")
    }

    println("Completed in: $time ms")


    println("Main program ends: ${Thread.currentThread().name}")
}

    suspend fun getMessageOne(): String{
        delay(1000L) //pretend to do some work
        return "Hello"
    }

    suspend fun getMessageTwo(): String{
        delay(1000L) //pretend to do some work
        return "World"
    }

