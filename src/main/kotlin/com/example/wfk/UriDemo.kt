package com.example.wfk

import org.springframework.web.util.DefaultUriBuilderFactory
import org.springframework.web.util.UriComponentsBuilder


/* 
 * Author: zzaoen
 * Date: 2020/2/14 23:41
 * Desc: 
 */

class UriDemo

fun test1() {
  val uriComponents = UriComponentsBuilder
      .fromUriString("https://example.com/hotels/{hotel}")
      .queryParam("q", "{q}")
      .encode()
      .build()

  val uri = uriComponents.expand("Westin", "123").toUri()
  val str = uri.toString()
  println(str)
}

fun test2() {
  val uri = UriComponentsBuilder
      .fromUriString("https://example.com/hotels/{hotel}")
      .queryParam("q", "{q}")
      .encode()
      .buildAndExpand("Westin", "123")
      .toUri()
  val str = uri.toString()
  println(str)
}

fun test3() {
  val uri1 = UriComponentsBuilder
      .fromUriString("https://example.com/hotels/{hotel}")
      .queryParam("q", "{q}")
      .build("Westin", "123")
  val uri2 = UriComponentsBuilder
      .fromUriString("https://example.com/hotels/{hotel}?q={q}")
      .build("Westin", "123")
  println(uri1.toString())
  println(uri2.toString())
}

fun test4(): Unit {
  val baseUrl = "https://example.com"
  val uriBuilderFactory = DefaultUriBuilderFactory(baseUrl)

  val uri1 = uriBuilderFactory.uriString("/hotels/{hotel}")
      .queryParam("q", "{q}")
      .build("Westin", "123")
  println(uri1.toString())

  val uri2 = uriBuilderFactory.uriString("/hotel list/{city}")
      .queryParam("q", "{q}")
      .build("New York", "foo+bar")
  println(uri2.toString())
}

fun main() {
  test1()
  test2()
  test3()
  test4()
}
