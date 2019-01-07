import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

fun main(args: Array<String>) {
    println("主线程start")

    //开启协程
    GlobalScope.launch {
        (1..10).forEach {
            println("打印了: $it")
            delay(500)
        }
    }

//    thread {
//        (1..10).forEach {
//            println("打印了: $it")
//            /**
//             * 如果使用线程来操作则不可怀疑使用delay()函数,
//             * 因为delay函数被 suspend 关键字修饰是一个"挂起函数" 他不会阻塞贤臣个，但是会挂起协程，并且只能在协程中使用
//             */
//            // delay(500)
//            // 这里使用换成线程sleep来实现同样的效果
//            Thread.sleep(500)
//        }
//    }

    println("主线程end")


    //主线程阻塞5秒来保证JVM存货，否则执行完上一句后，主线程结束jvm死掉，协程代码就无法运行
    //从打印结果可以看到，协程只能打印延时时间总和（i*500）在主线程中睡眠的时间（2000）的数据
    Thread.sleep(2000)
}