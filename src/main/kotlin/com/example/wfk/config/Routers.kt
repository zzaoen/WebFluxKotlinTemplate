package com.example.wfk.config

import com.example.wfk.PersonHandler
import com.example.wfk.PersonService
import com.example.wfk.TestHandler
import lombok.extern.slf4j.Slf4j
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.MediaType.APPLICATION_JSON
import org.springframework.http.MediaType.TEXT_PLAIN
import org.springframework.web.reactive.function.server.*


/* 
 * Author: zzaoen
 * Date: 2020/2/14 17:37
 * Desc: 
 */
@Slf4j
@Configuration
class Routers {
  
  //  @Bean
//  fun testRouter(
//    personHandler: PersonHandler
//  ): RouterFunction<ServerResponse> {
//
//    val helloRouter: RouterFunction<ServerResponse> = coRouter {
//      accept(TEXT_PLAIN).nest {
//        GET("/wfk/hello", accept(TEXT_PLAIN)) {
//          //        ok().bodyValue("hello-world").awaitFirst()
//          ok().bodyValueAndAwait("hello-world")
//        }
//      }
//    }
//    val monoRouter = router {
//      "/test".nest {
//        GET("/wfk/person/v1/{id}", testHandler::findPersonMono)
//        after { _, response ->
//          println(response)
//          response
//        }
//      }
//    }
//
//    val personRouter = coRouter {
//      POST("/wfk/person", personHandler::save)
//      accept(APPLICATION_JSON).nest {
//        GET("/wfk/person/v1/{id}", testHandler::findPerson)
//      }
//      "/test".nest {
//        GET("/person/v2/{id}", accept(APPLICATION_JSON), testHandler::findPerson)
//        GET("/person/v3/{id}", testHandler::findPerson)
//      }
//      "/test".nest {
//        accept(APPLICATION_JSON).nest {
//          GET("/person/v4", testHandler::findPerson)
//        }
//      }
//    }
//      .and(helloRouter)
//      .and(monoRouter)
////        .andRoute(accept(TEXT_PLAIN), )
//
//
//    return personRouter
//  }
  
  val testHandler: TestHandler = TestHandler()
  //  private val personService = PersonService()
//  val personHandler: PersonHandler = PersonHandler(personService)
//
  @Bean
  fun testRouter1(
    personHandler: PersonHandler
  ): RouterFunction<ServerResponse> {
    return coRouter {
      POST("/wfk/person", personHandler::save)
      GET("/wfk/person/{id}", personHandler::find)
      GET("/wfk/person", testHandler::findPersonMono2)
    }
  }
  
  @Bean
  fun testRouter2(
  ): RouterFunction<ServerResponse> {
    return RouterFunctions.route()
      .POST("/wfk/test/person", testHandler::savePersonMono)
      .GET("/wfk/test/person", testHandler::findPersonMono)
      .build()
  }
}