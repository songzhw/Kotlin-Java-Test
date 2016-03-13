package cn.song.agdelegate


/**
songzhw - 2015/8/16
Copyright 2015 Six.
 */

/**
 * The observable() function takes two arguments: initial value and a handler for modifications.
 * The handler gets called every time we assign to `name`, it has three parameters:
 * a property being assigned to, the old value and the new one. If you want to be able to veto
 * the assignment, use vetoable() instead of observable().
 */
import kotlin.properties.Delegates

class User3 {
    var name: String by Delegates.observable("no name") {
        d, old, new ->
        println("$old - $new")
    }
}

//fun main(args: Array<String>) {
//    val user = User3()
//    user.name = "Carl"  //no name - Carl
//    user.name = "szw"   //Carl - szw
//}