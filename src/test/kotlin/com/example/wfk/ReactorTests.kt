package com.example.wfk

import org.junit.jupiter.api.Test
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import reactor.test.StepVerifier


/*
 * Author: zzaoen
 * Date: 2020/3/2 13:48
 * Desc: 
 */

class ReactorTests {
  @Test
  fun testAppendBoomError() {
    val source = Flux.just("thing1", "thing2")
    StepVerifier.create(
      appendBoomError(source)!!
    )
      .expectNext("thing1")
      .expectNext("thing2")
      .expectErrorMessage("boom")
      .verify()
  }
  
  private fun <T> appendBoomError(source: Flux<T>): Flux<T>? {
    return source.concatWith(Mono.error(IllegalArgumentException("boom")))
  }
}
