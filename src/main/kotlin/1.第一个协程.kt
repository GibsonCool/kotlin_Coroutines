import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

fun main(args: Array<String>) {
    println("主线程start")

    //开启协程
    GlobalScope.launch{
        println("协程执行了")
    }

    println("主线程end")

    //主线程睡眠
    Thread.sleep(1000)
}