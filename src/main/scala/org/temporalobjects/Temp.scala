package org.temporalobjects

import java.util.UUID

/**
  * Created by linseb on 19/12/16.
  */
case class Temp[T](timeSlizes: List[TimeSlize[T]]) extends Temporal[T] {

  var uuid: UUID = UUID.randomUUID()

}
