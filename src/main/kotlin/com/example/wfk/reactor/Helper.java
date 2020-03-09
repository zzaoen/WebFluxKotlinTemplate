//package com.example.wfk.reactor;/*
// * Author: zzaoen
// * Date: 2020/3/2 18:04
// * Desc:
// */
//
//import reactor.core.publisher.Mono;
//import reactor.core.publisher.MonoCallable;
//import reactor.core.publisher.MonoRunnable;
//import reactor.core.publisher.MonoSupplier;
//
//import java.util.Objects;
//import java.util.concurrent.Callable;
//import java.util.function.Supplier;
//
//public class Helper {
//
//
//  public static <T> Mono<T> fromSupplier(Supplier<? extends T> supplier) {
//    return onAssembly(new MonoSupplier<>(supplier));
//  }
//  //Executes a Supplier function and emits a single value to each individual Subscriber.
//  MonoSupplier(Supplier<? extends T> callable) {
//    this.supplier = Objects.requireNonNull(callable, "callable");
//  }
//
//
//  public static <T> Mono<T> fromCallable(Callable<? extends T> supplier) {
//    return onAssembly(new MonoCallable<>(supplier));
//  }
//  //Executes a Callable function and emits a single value to each individual Subscriber.
//  MonoCallable(Callable<? extends T> callable) {
//    this.callable = Objects.requireNonNull(callable, "callable");
//  }
//  //Callable可以返回执行结果
//
//
//  public static <T> Mono<T> fromRunnable(Runnable runnable) {
//    return onAssembly(new MonoRunnable<>(runnable));
//  }
//  //Executes the runnable whenever a Subscriber subscribes to this Mono.
//  MonoRunnable(Runnable run) {
//    this.run = Objects.requireNonNull(run, "run");
//  }
//  //Runnable没有返回值
//}
