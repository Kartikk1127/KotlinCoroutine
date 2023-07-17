import kotlinx.coroutines.*
import kotlin.concurrent.thread

fun main() = runBlocking{

    println("Main program starts: ${Thread.currentThread().name}")

    val result: String? = withTimeoutOrNull(10000){ //if this coroutine fails to execute within 2000 ms then this function(withTimeout) will throw TimeoutCancellationException
        for (i in 0..500){
            println("$i.")
            delay(500)
        }
        "i am done"
    }

    println("Result: $result")

    println("\nMain program ends: ${Thread.currentThread().name}")

}
