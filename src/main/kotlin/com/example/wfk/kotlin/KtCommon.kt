package com.example.wfk.kotlin

import com.example.wfk.Person


/* 
 * Author: zzaoen
 * Date: 2020/2/16 20:04
 * Desc: 
 */

open class KtCommon

@ExperimentalUnsignedTypes
fun main() {
  val values = mapOf<String, String>()
//  val email = values["email"] ?: throw IllegalStateException("Email is missing!")

  val intArray = IntArray(5).apply { fill(-1) }
  println(intArray.toString())

  /*val printer = Printer().apply {
    name = "fuji"
  }
  with(printer) {
    job1()
    job2()
  }*/
  
  val a: Int = 10000
  println(a === a) // 输出“true”
  val boxedA: Int? = a
  val anotherBoxedA: Int? = a
  
  
  val person = Person(id = 0, name = "zz", age = 18)
  val s = person.name ?: return
  println(s)
  
  fun foo() {
    listOf(1, 2, 3, 4, 5).forEach {
      if (it == 3) return@forEach // 非局部直接返回到 foo() 的调用者
      print(it)
    }
    println("this point is unreachable")
  }
  
  foo()
}

class Printer {
  var name = String()

  fun job1() = println("job1 $name")
  fun job2() = println("job2")
}