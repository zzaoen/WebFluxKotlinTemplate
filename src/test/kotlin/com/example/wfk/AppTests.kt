package com.example.wfk

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType.APPLICATION_JSON
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.web.reactive.server.WebTestClient


@SpringBootTest
@ActiveProfiles(value = ["local"])
@AutoConfigureWebTestClient
class AppTests(@Autowired val client: WebTestClient) {
  
  @Test
  fun contextLoads() {
  }
  
  @Test
  fun testHandlerTest() {
    val result = client.get().uri("/wfk/person/1")
//      .accept(MediaType.APPLICATION_JSON)
      .exchange()
      .expectStatus().isOk()
      .expectBody(Person::class.java)
      .returnResult()
    println(result.responseBody.toString())
  }
  
  @Test
  fun testHandlerTest2() {
    val result = client.get().uri("/wfk/person")
//      .accept(MediaType.APPLICATION_JSON)
      .accept(APPLICATION_JSON)
      .exchange()
      .expectStatus().isOk()
      .expectBody(Person::class.java)
      .returnResult()
    println(result.responseBody.toString())
  }
  
}
