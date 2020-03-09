package com.example.wfk

import org.springframework.http.MediaType
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.awaitBody
import org.springframework.web.reactive.function.client.awaitExchange
import org.springframework.web.util.DefaultUriBuilderFactory
import org.springframework.web.util.UriComponentsBuilder

/*
 * Author: zzaoen
 * Date: 2020/2/14 23:41
 * Desc: 
 */

class WebClientDemo

suspend fun test11() {
  val client = WebClient.create("https://example.org")
  val result1 = client.get()
    .uri("/persons/{id}", "1").accept(MediaType.APPLICATION_JSON)
    .awaitExchange()
    .awaitBody<String>()
  
  val result2 = client.get()
    .uri("/persons/{id}", "1").accept(MediaType.APPLICATION_JSON)
    .awaitExchange()
    .toEntity(String::class.java)
}

fun main() {
  test1()
}
