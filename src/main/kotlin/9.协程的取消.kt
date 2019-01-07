import kotlinx.coroutines.*

fun main(args: Array<String>) = runBlocking {
    val job = GlobalScope.launch {
        (1..10).forEach {
            println("打印：$it")
            delay(500)
        }
    }
    /**
     * 需求 在协程执行到2000毫秒的时候需要停止不执行了
     */
    delay(2000)
//    job.cancel()
//    job.join()
    // 合并cancel 和 join
    job.cancelAndJoin()
}