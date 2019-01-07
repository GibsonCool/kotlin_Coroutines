import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main(args: Array<String>) = runBlocking {

    /**
     * GlobalScope.launch调用的都是同一个线程池
     *
     * 当使用delay()挂起的时候，由于这是一个挂起函数非阻塞，线程池中的该(取名叫A线程) 'A线程' 并不会阻塞在这里，意思就是可能去做其他事情
     *
     * 由于这里launch调用的是同一个线程池，故就不停的多处调用launch，并且在其中调用阻塞方法占用线程，目的是为了消耗完线程池中的线程数
     *
     * 当线程池中的空闲线程都被占用了后，刚才调用了delay()挂起函数的非阻塞 'A线程' 就要出来去执行还未处理的任务了。
     *
     * 当此 'A线程' 去处理其他任务时，delay挂起函数执行时间到了需要执行后续任务，则又会去线程池中找线程来执行后续任务
     *
     * 此时线程池调配的就是其他线程来执行任务了而非  'A线程' 来执行。
     *
     * 从上面的分析可以得出几点：
     *  1、kotlin中协程的实现依赖于线程池
     *  2、kotlin中协程的确是非阻塞的。从输出结果可以看出执行前和执行后可能是不同线程，通过挂起代替阻塞，有效利用闲置的线程资源
     *  3、由于不走系统线程的调度，由应用层的库来实现减少了线程创建以及线程阻塞的开销。
     */
    val job = GlobalScope.launch {
        println("协程执行前：${Thread.currentThread().name}")

        //等待   约等于Thread.sleep   但是这个是非阻塞的
        delay(2000)


        println("协程执行后：${Thread.currentThread().name}")
    }

    /**
     * 经过测验在这台MacBook Pro。CPU：2.6 GHz Intel Core i7 中协程的线程池大小为12 从输出log可以看出
     */
    GlobalScope.launch {
        println("当前线程：${Thread.currentThread().name}")
        Thread.sleep(3000)
    }
    GlobalScope.launch {
        println("当前线程：${Thread.currentThread().name}")
        Thread.sleep(3000)
    }
    GlobalScope.launch {
        println("当前线程：${Thread.currentThread().name}")
        Thread.sleep(3000)
    }
    GlobalScope.launch {
        println("当前线程：${Thread.currentThread().name}")
        Thread.sleep(3000)
    }
    GlobalScope.launch {
        println("当前线程：${Thread.currentThread().name}")
        Thread.sleep(3000)
    }
    GlobalScope.launch {
        println("当前线程：${Thread.currentThread().name}")
        Thread.sleep(3000)
    }
    GlobalScope.launch {
        println("当前线程：${Thread.currentThread().name}")
        Thread.sleep(3000)
    }
    GlobalScope.launch {
        println("当前线程：${Thread.currentThread().name}")
        Thread.sleep(3000)
    }
    GlobalScope.launch {
        println("当前线程：${Thread.currentThread().name}")
        Thread.sleep(3000)
    }
    GlobalScope.launch {
        println("当前线程：${Thread.currentThread().name}")
        Thread.sleep(3000)
    }
    GlobalScope.launch {
        println("当前线程：${Thread.currentThread().name}")
        Thread.sleep(3000)
    }
    GlobalScope.launch {
        println("当前线程：${Thread.currentThread().name}")
        Thread.sleep(3000)
    }
    GlobalScope.launch {
        println("当前线程：${Thread.currentThread().name}")
        Thread.sleep(3000)
    }




    job.join()
}