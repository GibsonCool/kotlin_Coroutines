import kotlinx.coroutines.*

fun main(args: Array<String>) = runBlocking {
    val job = GlobalScope.launch {
        (1..10).forEach {
            //判断协程状态取消之后直接返回
            if (!isActive) return@launch
            println("打印：$it")
            Thread.sleep(500)
        }
    }
    /**
     * 需求 在协程还行到2000毫秒的时候需要停止不执行了
     */
    delay(2000)

    //协程状态
    println("协程取消之前：" + job.isActive)

    /**
     * 取消失效，只能取消挂起，不能取消阻塞的/Thread.sleep
     */
    job.cancel()

    println("协程取消后：" + job.isActive)
    job.join()
}