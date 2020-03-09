package com.example.wfk.reactor

import org.reactivestreams.Subscription
import reactor.core.Exceptions
import reactor.core.publisher.BaseSubscriber
import reactor.core.publisher.Flux
import java.io.IOException


/*
 * Author: zzaoen
 * Date: 2020/3/1 20:53
 * Desc: 
 */
class TestReactor {

}

fun main() {
//  Flux.just("u1", "u2", "u3")
  
  /*val nums1 = Flux.range(1, 4)
  nums1.subscribe {
    println(it)
  }*/
  
  /*val num2 = Flux.range(1, 4)
    .map {
      if (it > 3)
        throw RuntimeException("element > 3")
      else
        it
    }
  num2.subscribe({ i -> println(i) }, { error -> println("error: $error") })*/
  
  /*val num3 = Flux.range(1, 4)
  num3.subscribe(
    { i -> println(i) },
    { error -> println("error: $error") },
    { println("done") }
  )*/
  
  /*val num4 = Flux.range(1, 20)
  num4.subscribe(
    { i -> println(i) },
    { error -> println("error: $error") },
    { println("done") }, // This block will not be executed. 20 elements but only request 10.
    { sub -> sub.request(10) }
  )
  num4.subscribe(
    { i -> println(i) },
    { error -> println("error: $error") },
    { println("done") }
  )*/
  
  /*val num5 = Flux.range(1, 4)
  val ss = SampleSubscribe<Int>()
//  num5.subscribe(
//    { i -> println(i) },
//    { error -> println("error: $error") },
//    { println("done") }, // This block will not be executed. 20 elements but only request 10.
//    { sub -> sub.request(10) }
//  )
  num5.subscribe(ss)
  num5.subscribe(ss) // BaseSubscribe will cancel it's subscription*/
  
  /*val flux1 = Flux.generate(
    { 0 }
  ) { state: Int, sink: SynchronousSink<String?> ->
    sink.next("3 x " + state + " = " + 3 * state)
    if (state == 10) sink.complete()
    state + 1
  }
  val flux2 = Flux.generate(
    { AtomicLong() }
  ) { state: AtomicLong, sink: SynchronousSink<String?> ->
    val i = state.getAndIncrement()
    sink.next("3 x " + i + " = " + 3 * i)
    if (i == 10L) sink.complete()
    state
  }
  val flux3 = Flux.generate(
    { AtomicLong() },
    { state: AtomicLong, sink: SynchronousSink<String?> ->
      val i = state.getAndIncrement()
      sink.next("3 x " + i + " = " + 3 * i)
      if (i == 10L) sink.complete()
      state
    },
    { println("state: $it") }
  )
  flux3.subscribe(::println)*/
  
  /*val list = listOf<String>("a", "b")
  val toFlux = list.toFlux()*/
  
  /*val onErrorReturn = Flux.just("20")
    .map {
      println(it)
      it
    }
    .onErrorReturn("Uh oh")
  onErrorReturn.subscribe()
  
  
  val flux = Flux.interval(Duration.ofMillis(250))
    .map { input: Long ->
      if (input < 3) return@map "tick $input"
      throw RuntimeException("boom")
    }
    .doOnError {
      println(it)
    }
    .onErrorReturn("Uh oh")
  
  flux.subscribe { x: String? -> println(x) }
  Thread.sleep(1100)*/
  
  /*Flux.interval(Duration.ofMillis(250))
    .map { input: Long ->
      if (input < 3) return@map "tick $input"
      throw RuntimeException("boom")
    }
    .retry(1)
    .elapsed()
    .subscribe(
      { x: Tuple2<Long?, String>? -> println(x) }
    ) { x: Throwable? -> System.err.println(x) }
  
  Thread.sleep(2100)*/
  
  /*val flux1 = Flux
    .error<String>(IllegalArgumentException())
    .doOnError { x: Throwable? -> println(x) }
    .retryWhen { companion: Flux<Throwable?> ->
      companion.take(
        3
      )
    }.subscribe()*/
  val converted = Flux
    .range(1, 10)
    .map<String> { i: Int ->
      try {
        return@map convert(i)
      } catch (e: IOException) {
        throw Exceptions.propagate(e)
      }
    }
  converted.subscribe(
    { v: String -> println("RECEIVED: $v") }
  ) { e: Throwable? ->
    if (Exceptions.unwrap(e!!) is IOException) {
      println("Something bad happened with I/O")
    } else {
      println("Something bad happened")
    }
  }
  
}

@Throws(IOException::class)
fun convert(i: Int): String {
  if (i > 3) {
    throw IOException("boom $i")
  }
  return "OK $i"
}

class SampleSubscribe<T> : BaseSubscriber<T>() {
  override fun hookOnNext(value: T) {
    println(value)
    request(1)
  }
  
  override fun hookOnComplete() {
    super.hookOnComplete()
  }
  
  override fun hookOnSubscribe(subscription: Subscription) {
    println("Subscribed")
    request(1)
  }
}
