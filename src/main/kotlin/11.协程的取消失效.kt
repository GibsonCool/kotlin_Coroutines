import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main(args: Array<String>) = runBlocking {
    val job = GlobalScope.launch {
        (1..10).forEach {
            println("打印：$it")
            Thread.sleep(500)
        }
    }
    /**
     * 需求 在协程还行到2000毫秒的时候需要停止不执行了
     */
    delay(2000)
    /**
     * 取消失效，只能取消挂起，不能取消阻塞的/Thread.sleep
     */
    job.cancel()


    job.join()
}