import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main(args: Array<String>) = runBlocking {
    println("主线程开始执行")


//    val job = GlobalScope.launch {
//        println("协程启动")
//    }

    val job = GlobalScope.launch {
        (1..10).forEach {
            println("打印了: $it")
            delay(500)
        }
    }
    println("主线程结束执行")
    //方案1：主线程睡眠
    //Thread.sleep(100)

    //方案二：通过协程返回的job任务执行join方法（main接受返回一个runblocking）
    job.join()
}