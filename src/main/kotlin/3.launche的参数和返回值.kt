import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

fun main(args: Array<String>) {
    println("主线程start")

    /**
     * GlobalScope.launch
     * 第一个参数： 协程上下文----》空上下文
     *     context: CoroutineContext = EmptyCoroutineContext
     * 第二个参数：协程启动状态----》默认
     *     start: CoroutineStart = CoroutineStart.DEFAULT
     */
    GlobalScope.launch {
        println("协程执行了")
    }

    println("主线程end")

    //主线程睡眠
    Thread.sleep(5000)
}