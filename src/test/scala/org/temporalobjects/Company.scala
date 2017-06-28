package org.temporalobjects

import java.util.Date

import scala.collection.JavaConversions._

/**
  * Created by linseb on 15/12/16.
  */
case class Company(var employees: TempOneToMany[Employee], name: TempOneToOne[String]) {

}

case class TempOneToMany[T](values: List[TempValue[T]]) {

}







