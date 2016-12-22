package org.temporalobjects

import scala.collection.JavaConversions._

/**
  * Created by linseb on 15/12/16.
  */
case class Company(var employees: List[Temporal[Employee]], name: Temporal[String]) {

  def this(e: java.util.List[Temporal[Employee]], n: Temporal[String]) = this(e.toList, n)

}







