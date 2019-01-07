import java.util.concurrent.Executors
import java.util.concurrent.ForkJoinPool

fun main(args: Array<String>) {
    println("主线程开始")
    /**
     *  普通的线程池执行
     */

//    val service = Executors.newFixedThreadPool(3)

    /**
     * ForkJoinPool执行
     */
    val service = ForkJoinPool(3)


    service.execute(MyRunnable())

    /**
     * ForkJoinPool 执行时必须要让主线程睡眠阻塞才能看到结果
     * 原因：ForkJoinPool与普通的线程池不同，因为他创建的线程是守护线程，普通线程池创建的线程的用户线程
     *      守护线程在主线程挂了之后就会死亡所以必须阻塞主线程才能看到ForkJoinPool中运行线程的结果 
     */
    Thread.sleep(2000)

    println("主线程结束")
}

class MyRunnable : Runnable {
    override fun run() {
        (1..10).forEach {
            println("打印：$it")
            Thread.sleep(500)
        }
    }
}