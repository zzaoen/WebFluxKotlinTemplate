package com.example.wfk

import com.example.wfk.config.Routers
import com.ninjasquad.springmockk.MockkBean
import org.junit.jupiter.api.Test
import org.springframework.http.MediaType
import org.springframework.test.web.reactive.server.WebTestClient


/* 
 * Author: zzaoen
 * Date: 2020/2/16 16:08
 * Desc: 
 */
class TestHandlerTests {
  
  @Test
  fun test1() {
    val client = WebTestClient.bindToRouterFunction(Routers().testRouter2()).build()
    val result = client.get().uri("/wfk/test/person")
      .accept(MediaType.APPLICATION_JSON)
      .exchange()
      .expectStatus().isOk()
      .expectBody(Person::class.java)
      .returnResult()
    println(result.responseBody.toString())
  }
  
  @Test
  fun test2() {
    val client = WebTestClient.bindToServer().baseUrl("http://localhost:8080")
      .build()
    val result = client.get().uri("/wfk/person/1")
//      .accept(MediaType.APPLICATION_JSON)
      .exchange()
      .expectStatus().isOk()
      .expectBody(Person::class.java)
      .returnResult()
    println(result.responseBody.toString())
  }
}
