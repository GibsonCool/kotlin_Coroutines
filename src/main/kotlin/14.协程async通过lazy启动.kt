import kotlinx.coroutines.*

fun main(args: Array<String>) = runBlocking {

    /**
     * 使用CoroutineStart.LAZY的方式开启，里面的doOne不会立即执行。只有被调用的时候才会执行类似  by lazy{}懒加载
     */
    val start = CoroutineStart.LAZY //如果是lazy方式，会在调用asynOne.await()方式的时候内部lambd表达式才会执行
//    val start = CoroutineStart.DEFAULT  //如果是默认方式，doOne会被立即执行
    val asynOne = GlobalScope.async(start = start) {
        doOne()
    }

    println("延时1000毫秒在调用")
    delay(1000)

    //这里调用asynOne时，其中的doOne才会被执行
    println("输出结果是：${asynOne.await()}")


}

suspend fun doOne(): Int {
    println("doOne 被调用")
    delay(500)
    return 1
}