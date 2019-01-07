import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main(args: Array<String>) = runBlocking {   //主协程

    /**
     * 挂起函数：可以被挂起执行  到时间之后从线程池中空闲的线程中恢复执行、
     *
     * 挂起函数必须通过  suspend  进行修饰
     *
     * 挂起函数必须下协程中执行 或者在其他挂起函数中执行
     */
    val job = GlobalScope.launch {
        myTask()
    }

    /**
     * 由于job.join方法也是 suspend 修饰的一个挂起函数，所以我们的main方法也必须是挂起函数或者是协程
     *
     * 由于main函数是程序入口如果用suspend修饰就跑步起来了，所以使用runBlocking把其中代码块都包含在协程中执行
     */
    job.join()
}

/**
 * 由于 delay是个挂起函数，所以myTask方法也必须是挂起函数要用suspend修饰
 */
private suspend fun myTask() {
    println("协程执行前")

    delay(2000)

    println("协程执行后")
}