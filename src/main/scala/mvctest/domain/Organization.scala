package mvctest.domain

import java.util.UUID

import mvctest.domain.temporal.{Just, Temp, Temporal}
import org.springframework.data.annotation.Id

import scala.beans.BeanProperty

/**
  * Created by linseb on 15/12/16.
  */
class Organization() {

  @Id
  @BeanProperty
  var uuid : UUID = UUID.randomUUID()

  @BeanProperty
  var spaces: Temporal[Space] = Temp(List())

  @BeanProperty
  var name: Temporal[String] = Just("")
}







