package com.example.wfk

import lombok.NoArgsConstructor
import org.springframework.cloud.gcp.data.datastore.core.mapping.Entity
import org.springframework.data.annotation.Id
import java.util.*
import javax.validation.constraints.NotEmpty

/* 
 * Author: zzaoen
 * Date: 2020/2/17 21:08
 * Desc: 
 */
@Entity(name = "wfk_person")
data class Person (
  @Id
  var id: Long = Date().time,
  val name: String,
  val age: Int
)
