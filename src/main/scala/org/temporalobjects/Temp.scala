package org.temporalobjects

import java.util
import java.util.UUID

import scala.collection.JavaConversions._

/**
  * Created by linseb on 19/12/16.
  */
case class Temp[T](var versions: List[Version[T]]) extends Temporal[T] {

  var uuid: UUID = UUID.randomUUID()

  def this(v: util.List[Version[T]]) = this(v.toList)

}
