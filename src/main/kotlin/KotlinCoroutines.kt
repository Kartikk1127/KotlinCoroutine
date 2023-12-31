import kotlinx.coroutines.*
import kotlin.concurrent.thread
import kotlin.system.measureTimeMillis

fun main() = runBlocking{
    println("Main program starts: ${Thread.currentThread().name}")

    val msgOne: Deferred<String> = async(start = CoroutineStart.LAZY) { getMessageOne() }
    val msgTwo: Deferred<String> = async(start = CoroutineStart.LAZY) { getMessageTwo() }
    println("The entire message is: ${msgOne.await()+msgTwo.await()}")




    println("Main program ends: ${Thread.currentThread().name}")
}

    suspend fun getMessageOne(): String{
        delay(1000L) //pretend to do some work
        println("After working in getMessageOne()")
        return "Hello"
    }

    suspend fun getMessageTwo(): String{
        delay(1000L) //pretend to do some work
        println("After working in getMessageTwo()")
        return "World"
    }

