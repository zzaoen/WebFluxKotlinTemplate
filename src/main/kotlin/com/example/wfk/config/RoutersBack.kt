//package com.example.wfk.config
//
//import com.example.wfk.TestHandler
//import lombok.extern.slf4j.Slf4j
//import org.springframework.context.annotation.Bean
//import org.springframework.context.annotation.Configuration
//import org.springframework.http.MediaType.APPLICATION_JSON
//import org.springframework.http.MediaType.TEXT_PLAIN
//import org.springframework.web.reactive.function.server.*
//
//
///*
// * Author: zzaoen
// * Date: 2020/2/14 17:37
// * Desc:
// */
//@Slf4j
//@Configuration
//class RoutersBack {
//  @Bean
//  fun testRouter(
//      testHandler: TestHandler
//  ): RouterFunction<ServerResponse> {
//    val firstRoute: RouterFunction<ServerResponse> = coRouter {
//      accept(TEXT_PLAIN).nest {
//        GET("/test/hello", accept(TEXT_PLAIN)) {
//          //        ok().bodyValue("hello-world").awaitFirst()
//          ok().bodyValueAndAwait("hello-world")
//        }
//      }
//    }
//
//    val monoRoute = router {
//      "/test".nest {
//        GET("/test/person/v1/{id}", testHandler::findPersonMono)
//        after { _, response ->
//          println(response)
//          response
//        }
//      }
//    }
//
//    val secondRoute = coRouter {
//      accept(APPLICATION_JSON).nest {
//        GET("/test/person/v1/{id}", testHandler::findPerson)
//      }
//      POST("/test/person/v1", testHandler::savePerson)
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
//        .and(firstRoute)
//        .and(monoRoute)
////        .andRoute(accept(TEXT_PLAIN), )
//
//
//    return secondRoute
//  }
//
//  @Bean
//  fun testRouter2(
//      testHandler: TestHandler
//  ): RouterFunction<ServerResponse> {
//    return RouterFunctions.route()
//        .POST("/test/v2/person", testHandler::savePersonMono)
//        .build()
//  }
//}