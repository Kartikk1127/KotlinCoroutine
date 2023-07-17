import kotlinx.coroutines.*
import kotlin.concurrent.thread

fun main() = runBlocking{

    println("Main program starts: ${Thread.currentThread().name}")

    val job = launch(Dispatchers.Default) {
        try{
            for(i in 0..500){
                println("$i.")
                delay(5)
            }
        }
        catch (ex: CancellationException){
            print("\nException caught safely: ${ex.message}")
        }
        finally {
            withContext(NonCancellable){
                delay(1000) //generally we don't use suspending function in finally
                print("\nClose resources in finally")
            }
        }
    }

    delay(10) //printing few values before we cancel
    job.cancel(CancellationException("My crash message"))
    job.join() //waits for coroutine to finish
//    job.cancelAndJoin() you can also use this function instead of the above separate functions

    println("\nMain program ends: ${Thread.currentThread().name}")

}
