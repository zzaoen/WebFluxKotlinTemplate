package com.example.wfk

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono

/* 
 * Author: zzaoen
 * Date: 2020/2/26 13:38
 * Desc: 
 */
@Service
class PersonService(
  val personRepository: PersonRepository
) {
  
//  @Autowired
//  private val personRepository: PersonRepository? = null
  
  fun save(person: Person): Mono<Person> {
    return Mono.fromSupplier {
      personRepository!!.save(person)
    }
  }
  
  fun delete(id: Long): Mono<Unit> {
    return Mono.fromSupplier {
      personRepository!!.deleteById(id)
    }
  }
  
  fun update(person: Person): Mono<Person> {
    return Mono.fromSupplier {
      personRepository!!.save(person)
    }
  }
  
  fun find(id: Long): Mono<Person> {
    return Mono.fromSupplier {
      personRepository!!.findById(id).get()
    }
  }
  
  fun findAll(): Mono<List<Person>> {
    return Mono.fromSupplier {
      personRepository!!.findAll().toList()
    }
  }
}