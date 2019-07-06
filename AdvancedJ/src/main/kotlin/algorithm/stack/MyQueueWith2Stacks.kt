package algorithm.stack

import java.util.*
import javax.sound.midi.Soundbank

class MyQueueWith2Stacks {
    private val newest = Stack<Int>()
    private val oldest = Stack<Int>()

    fun add(num: Int) {
        newest.push(num)
    }

    fun remove(): Int {
        shift()
        return oldest.pop()
    }

    fun shift() {
        while (!newest.isEmpty()) {
            oldest.push(newest.pop())
        }
    }

    override fun toString(): String {
        val s1 = newest.toString()
        val s2 = oldest.toString()
        return s2 + s1
    }

}

fun main() {
    val queue = MyQueueWith2Stacks()
    queue.add(1)
    queue.add(2)
    queue.add(4)
    println(queue) //=> 1, 2, 4

    queue.remove()
    println(queue) //=> 4, 2

    queue.remove()
    println(queue) //=> 4
}