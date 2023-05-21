import kotlinx.coroutines.*

@OptIn(DelicateCoroutinesApi::class)
fun main() {
    runBlocking {
        val context = newFixedThreadPoolContext(2, "OtusPowerThread")
        (1 .. 10).forEach {
            launch(context) {
                coroutineScope {
                    println("Start execution $it on ${Thread.currentThread().name}")
                    delay(500)
                    println("End of execution $it on ${Thread.currentThread().name}")
                }
            }
        }
    }
}