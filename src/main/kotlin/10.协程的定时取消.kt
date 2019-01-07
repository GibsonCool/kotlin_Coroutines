import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withTimeout

fun main(args: Array<String>) = runBlocking {
    val job = launch {

    /**
     * 需求 在协程还行到2000毫秒的时候需要停止不执行了
     */
        withTimeout(2000) {
            (1..10).forEach {
                println("打印：$it")
                delay(500)
            }
        }
    }

    job.join()
}