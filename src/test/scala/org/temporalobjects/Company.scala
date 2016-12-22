package org.temporalobjects

/**
  * Created by linseb on 15/12/16.
  */
class Company(e: List[Temporal[Employee]] = List(), n: Temporal[String]) {

  var employees: List[Temporal[Employee]] = e
  var name: Temporal[String] = n

}







