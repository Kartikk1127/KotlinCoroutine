import kotlinx.coroutines.*
import kotlin.concurrent.thread

fun main() = runBlocking{

    println("Main program starts: ${Thread.currentThread().name}")

    withTimeout(2000){ //if this coroutine fails to execute within 2000 ms then this function(withTimeout) will throw TimeoutCancellationException
        try{
            for (i in 0..500){
                println("$i.")
                delay(500)
            }
        }
        catch (ex: TimeoutCancellationException){
            println("Exception handled successfully")
        }
        finally {
            println("Code ends now")
        }
    }

    println("\nMain program ends: ${Thread.currentThread().name}")

}
