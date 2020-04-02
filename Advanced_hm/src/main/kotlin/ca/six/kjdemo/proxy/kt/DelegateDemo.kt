package ca.six.kjdemo.proxy.kt

interface IWorkJob {
    fun work()
    fun despcription()
}

class FetchDataWorkJob : IWorkJob {
    override fun work() {
        println("http working...")
    }

    override fun despcription() {
        println("I'm fetch")
    }
}

class LogWrapper(val bizJob: IWorkJob) : IWorkJob by bizJob {
    override fun work() {
        println("=== before log === (${System.currentTimeMillis()})")
        bizJob.work()
        println("=== after log === (${System.currentTimeMillis()})")
    }
}

class TimeWrapper(val bizJob: IWorkJob) : IWorkJob by bizJob {
    override fun work() {
        val start = System.currentTimeMillis()
        bizJob.work()
        val end = System.currentTimeMillis()
        println("TimeWrapper : consume time = ${end - start}ms")
    }
}

fun main() {
    val fetcher = FetchDataWorkJob()
    val worker = LogWrapper(fetcher)
    worker.work()
    worker.despcription()

    println("\n******************************\n")

    val fetcher2 = FetchDataWorkJob()
    val worker2 = TimeWrapper(LogWrapper(fetcher2))

    worker2.work()
    worker2.despcription()

}
/*
=== before log === (1585841097667)
http working...
=== after log === (1585841097667)
I'm fetch


=== before log === (1585842176441)
http working...
=== after log === (1585842176441)
TimeWrapper : consume time = 0ms
I'm fetch
 */