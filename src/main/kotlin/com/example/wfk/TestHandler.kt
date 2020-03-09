package com.example.wfk

import kotlinx.coroutines.reactive.awaitFirst
import org.springframework.beans.factory.annotation.Value
import org.springframework.http.CacheControl
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.BodyExtractors
import org.springframework.web.reactive.function.server.HandlerFunction
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.ServerResponse.ok
import reactor.core.publisher.Mono
import java.util.concurrent.TimeUnit


/* 
 * Author: zzaoen
 * Date: 2020/2/14 17:48
 * Desc: 
 */
@Component
class TestHandler {
  
  @Value("\${test.name}")
  val name: String? = null
  
  /**
   * POST /test/person/v1
   */
  suspend fun savePerson(request: ServerRequest): ServerResponse {
//    val body = request.awaitBody<String>()
    val body = request.body(BodyExtractors.toMono(String::class.java)).awaitFirst()
    return ok().bodyValue(body).awaitFirst()
  }
  
  /**
   * GET /test/person/v1/{id}
   */
  suspend fun findPerson(request: ServerRequest): ServerResponse {
    val handle = handlerFunction.handle(request)
    return handle.awaitFirst()
  }
  
  
  
  
  
  //*****************************
  // Mono
  //*****************************
  
  val handlerFunction = HandlerFunction<ServerResponse> {
    ok()
//      .cacheControl(CacheControl.maxAge(30, TimeUnit.MINUTES))
//      .bodyValue(Person(name = "zz", age = 26))
      .bodyValue("HelloWorld")
  }
  /**
   * POST /test/person
   */
  fun savePersonMono(request: ServerRequest): Mono<ServerResponse> {
//    val body = request.awaitBody<String>()
    val body = request.body(BodyExtractors.toMono(Person::class.java))
    return body.flatMap {
      ok().bodyValue(it)
    }
  }
  
  /**
   * GET /test/person/{id}
   */
  fun findPersonMono(request: ServerRequest): Mono<ServerResponse> {
    val handle = handlerFunction.handle(request)
    return handle
  }
  
  /**
   * GET /wfk/person
   */
  suspend fun findPersonMono2(request: ServerRequest): ServerResponse {
    val handle = handlerFunction.handle(request)
    return handle.awaitFirst()
  }
  
}