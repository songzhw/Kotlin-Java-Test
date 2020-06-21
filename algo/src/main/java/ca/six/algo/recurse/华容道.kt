package ca.six.algo.recurse

/*
 下面是两个2x3滑动拼图(用二维数组表示), 其中的0是代表着空的那个格子. 要求移动格子, 让board变成[[1,2,3], [4,5,0]]就胜利了.
 现在要求一个算法, 给定一个board, 求服务生需要的最少移动次数. 如不能胜利, 返回-1.

 比如说, board = [ [4,1,2], [5,0,3] ]
 4 1 2    4 1 2    0 1 2    1 0 2    1 2 0    1 2 3
 5 0 3 => 0 5 3 => 4 5 3 => 4 5 3 => 4 5 3 => 4 5 0
 所以是移动5次, 算法要返回5.
 */

fun 华容道(board: Array<Array<Int>>): Int {


    return -1
}

fun main() {
    println("1. ${华容道(arrayOf(
        arrayOf(4, 1, 2), 
        arrayOf(5, 0, 3)
    ))}")

    println("2. ${华容道(arrayOf(
        arrayOf(3, 4, 2),
        arrayOf(5, 0, 1)
    ))}")
}