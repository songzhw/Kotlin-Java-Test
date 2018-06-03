package msg_queue

import java.util.concurrent.locks.ReentrantLock

class MessageQueue {
    val lock = ReentrantLock()
    var messages = Message()
    var isQuitting = false
    val emptyMessage = EmptyMessage()

    fun next(): Message {
        var waitTimeMillis = 0L; //需要的时间. 0是无限休眠, 正数表示实际的休眠时间, 负数表示不休眠

        while (true) {
            try { //kotlin中try-catch并非强制. 但这里为了finally中lock.unlock(), 只好加个try{}
                lock.lockInterruptibly()
                waitMessag(waitTimeMillis); //若没有马上就可以处理的消息, 那方法就要在这行被堵塞了
                if (isQuitting) return emptyMessage  // java中是return null; 这里就改了, 以适应kotlin

                val now = System.currentTimeMillis()
                val msg = messages
                if (msg is EmptyMessage) {
                    waitTimeMillis = -1 //缓冲区没有数据, 但线程被唤醒, 说明消息循环需要退出, 所以等待时间置为负数
                } else {
                    // 缓冲区内有数据, 要么取出msg并返回, 要么就计算下等待时间并重新休眠
                    if (now < msg._when) {
                        waitTimeMillis = msg._when - now
                    } else {
                        messages = messages.next
                        msg.next = emptyMessage
                        return msg
                    }
                }
            } finally {
                lock.unlock()
            }
        }
    }

    private fun waitMessag(waitTimeMillis: Long) {

    }

}