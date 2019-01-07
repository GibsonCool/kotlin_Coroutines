import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

//fun main(args: Array<String>) {
fun main(args: Array<String>) = runBlocking{
    val statTime = System.currentTimeMillis()


    /**
     * 线程的方式：耗时基本在7500毫秒左右
     */
//    val threadList = List(100000) { MyThread() }
//    threadList.forEach {
//        it.start()
//        it.join()
//    }


    /**
     * 协程的方式：耗时在 1000毫秒一下  相比线程的方式快了太多了
     */
    val coroutineList = List(100000){
        GlobalScope.launch {
            println(".")
        }
    }
    coroutineList.forEach { it.join() }



    val endTime = System.currentTimeMillis()
    val time = endTime-statTime
    println("消耗时间:$time")
}

class MyThread : Thread() {
    override fun run() {
        println(".")
    }
}