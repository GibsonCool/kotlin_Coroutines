import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * 除了由不同的构建器提供协程作用域之外，还可以使用 coroutineScope 构建器声明自己的作用域
 */
fun main(args: Array<String>) = runBlocking {
    val job1 = launch {
        delay(2000)
        println("Task from runBlocking 作用域中的  job1")
    }


    /**
     * coroutineScope 与 runBlocking不同，不会阻塞当前线程。
     *
     *      所以job1中的延时到了会正常输出，不会因为job2延时没到阻塞线程而不输出
     *
     * 当延时时间为 '1500' 时候的输出结果是：
     *      Task from coroutine scope 新的作用域
     *      Task from 内嵌作用域中的  job2
     *      runBlocking 作用域执行完毕
     *      Task from runBlocking 作用域中的  job1
     *
     * 当延时时间为 '5000' 时候的输出结果是：
     *      Task from coroutine scope 新的作用域
     *      Task from runBlocking 作用域中的  job1
     *      Task from 内嵌作用域中的  job2
     *      runBlocking 作用域执行完毕
     *
     * 从上面两个结果可以看出。无论新协程作用域中的延时任务大于还是小于runBlocking作用域中的延时任务
     * 最后的输出log中 "runBlocking 作用域执行完毕" 一定都是在新协程作用域中的log输出完成之后才会
     * 输出。
     */
    coroutineScope {    //创建一个新的协程作用域
        val job2 = launch {
            delay(5000)
            println("Task from 内嵌作用域中的  job2")
        }

        delay(1000)
        /**
         *  这一行会在job2之前输出
         */
        println("Task from coroutine scope 新的作用域")
    }

    /**
     * 这一行会在job2执行完之后再输出
     */
    println("runBlocking 作用域执行完毕")
}