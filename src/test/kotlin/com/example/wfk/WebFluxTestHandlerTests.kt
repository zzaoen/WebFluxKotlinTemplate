package com.example.wfk

import com.example.wfk.config.Routers
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest
import org.springframework.context.annotation.Import
import org.springframework.test.web.reactive.server.WebTestClient


/* 
 * Author: zzaoen
 * Date: 2020/2/16 16:08
 * Desc: 
 */

@WebFluxTest
@Import(Routers::class)
class WebFluxTestHandlerTests(@Autowired val client: WebTestClient) {
  @Test
  fun test1() {
//    val client = WebTestClient.bindToRouterFunction(Routers().testRouter1(personHandler)).build()
    val result = client.get().uri("/wfk/test/person")
//      .accept(MediaType.APPLICATION_JSON)
      .exchange()
      .expectStatus().isOk()
      .expectBody(Person::class.java)
      .returnResult()
    println(result.responseBody.toString())
  }
  
  /**
   * Failed because can't start datastore service
   */
  
  @Test
  fun test2() {
//    val client = WebTestClient.bindToRouterFunction(Routers().testRouter1(personHandler)).build()
    val result = client.get().uri("/wfk/person")
//      .accept(MediaType.APPLICATION_JSON)
      .exchange()
      .expectStatus().isOk()
      .expectBody(Person::class.java)
      .returnResult()
    println(result.responseBody.toString())
  }
}