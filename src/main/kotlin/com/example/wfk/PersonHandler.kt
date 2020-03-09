package com.example.wfk

import kotlinx.coroutines.reactive.awaitFirst
import org.springframework.http.MediaType.APPLICATION_JSON
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import reactor.core.publisher.Mono

/* 
 * Author: zzaoen
 * Date: 2020/2/26 13:43
 * Desc: 
 */
@Component
class PersonHandler(val personService: PersonService) {
  
  suspend fun save(request: ServerRequest) : ServerResponse {
    return request.bodyToMono(Person::class.java)
      .flatMap {
        personService.save(it)
      }.flatMap {
        ServerResponse.ok().contentType(APPLICATION_JSON).bodyValue(it)
      }.awaitFirst()
  }
  
//  fun save(request: ServerRequest) : Mono<ServerResponse> {
//    return request.bodyToMono(Person::class.java)
//      .flatMap {
//        personService.save(it)
//      }.flatMap {
//        ServerResponse.ok().contentType(APPLICATION_JSON).bodyValue(it)
//      }.switchIfEmpty(ServerResponse.badRequest().build())
//  }
  
  suspend fun find(request: ServerRequest) : ServerResponse {
    return Mono.just(request.pathVariable("id"))
      .flatMap {
        personService.find(it.toLong())
      }.flatMap {
        ServerResponse.ok().contentType(APPLICATION_JSON).bodyValue(it)
      }.awaitFirst()
  }
  
}