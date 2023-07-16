import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.concurrent.thread

fun main() {
    println("Main program starts: ${Thread.currentThread().name}")

GlobalScope.launch {    //creates a background coroutine that runs on a background thread //let's say Thread: T1
    println("Fake work starts: ${Thread.currentThread().name}")
//    Thread.sleep(1000) //pretend doing some work...maybe file upload
    delay(1000) //better than thread.sleep //Coroutine is suspended but thread T1 is free(not blocked)
    println("Fake work finished: ${Thread.currentThread().name}")
}

    //the below thread.slepp blocks the current main thread and wait for the coroutine to finish(practically not the right way to wait)
    Thread.sleep(2000)
    println("Main program ends: ${Thread.currentThread().name}")

}