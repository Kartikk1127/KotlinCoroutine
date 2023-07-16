import kotlin.concurrent.thread

fun main() {
    println("Main program starts: ${Thread.currentThread().name}")

thread {    //creates a background thread(worker thread)
    println("Fake work starts: ${Thread.currentThread().name}")
    Thread.sleep(1000) //pretend doing some work...maybe file upload
    println("Fake work finished: ${Thread.currentThread().name}")
}
    println("Main program ends: ${Thread.currentThread().name}")

}