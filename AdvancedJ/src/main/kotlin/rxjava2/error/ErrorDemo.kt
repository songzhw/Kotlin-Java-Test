package rxjava2.error

import io.reactivex.Observable
import io.reactivex.functions.Function

val DEFAULT_ERROR = 0
val DEFAULT_ERROR_100 = 100

fun main(args: Array<String>) {
    var i = 1
    val http = HttpEngine()
    http.getStoryList()
            .map { 23/0 }
            .onErrorReturn { DEFAULT_ERROR }
            .subscribe{ println("$it")}  //=> 0

    http.getStoryList()
            .map { 23/0 }
            .onErrorResumeNext(Function {Observable.just(DEFAULT_ERROR_100)}) //DEFAULT_ERROR_100值为100
            .subscribe{ println("$it")}  //=> 100

    http.getStory_E()
            .onErrorReturn { "error happens" }
            .subscribe { str ->
                println("szw getStory_E() $str")
            }

    http.getStory_E()
            .subscribe({str-> println("next $str")},
                    {err -> println("error : $err")}) //error: java.lang.Exception: test

}

/*
onErrorResumeNext()的两种形式:


    Observable.just(23)
            .onErrorResumeNext(object : Observable<Int>() {
                override fun subscribeActual(observer: Observer<in Int>) {
                    println("onErrorResumeNext() : " + observer.toString())
                }
            })
            .subscribe { integer -> println("onNext() : " + integer!!) }

    Observable.just(23)
            .map{ 24 / 0}
            .onErrorResumeNext(Function { Observable.just(300) })
            .subscribe { integer -> println("onNext() : " + integer!!) }

 */