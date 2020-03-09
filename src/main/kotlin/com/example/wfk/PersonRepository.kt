package com.example.wfk

import org.springframework.cloud.gcp.data.datastore.repository.DatastoreRepository
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

/* 
 * Author: zzaoen
 * Date: 2020/2/26 13:37
 * Desc: 
 */
@Repository
interface PersonRepository : DatastoreRepository<Person, Long>, CrudRepository<Person, Long>