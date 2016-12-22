package mvctest.domain.temporal

import java.util.UUID

import org.springframework.data.annotation.Id

import scala.beans.BeanProperty

/**
  * Created by linseb on 19/12/16.
  */
case class Temp[T](timeSlizes: java.util.List[TimeSlize[T]]) extends Temporal[T] {

  @Id
  @BeanProperty
  var uuid: UUID = UUID.randomUUID()

}
