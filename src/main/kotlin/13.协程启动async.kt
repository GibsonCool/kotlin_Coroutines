import kotlinx.coroutines.*


/**
 * 第一种启动协程的方式：  launch 没有返回值
 * 第二种启动协程的方式：  async 需要返回值
 */
fun main(args: Array<String>) = runBlocking {
//    val job = GlobalScope.launch {
//        job1()
//    }
//    println("获取job1 的返回值")
//

    val defeered1 = GlobalScope.async { job1() }
    val defeered2 = GlobalScope.async { job2() }
    val result1 = defeered1.await()
    val result2 = defeered2.await()

    println("返回结果： result1（$result1）  result2（$result2）")
}

suspend fun job1(): String {
    println("开始执行  job1")
    delay(1000)
    println("执行了  job1")
    return "job1"
}

suspend fun job2(): String {
    println("开始执行  job2")
    delay(1000)
    println("执行了  job2")
    return "job2"
}

