package org.temporalobjects

/**
  * Created by linseb on 17/12/16.
  */
class Employee(var f: Temporal[String], l: Temporal[String]) {

  var firstName: Temporal[String] = f
  var lastName: Temporal[String] = l

}
