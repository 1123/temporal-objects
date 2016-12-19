package mvctest.domain

import java.util.UUID

import mvctest.domain.temporal.Temporal

import scala.beans.BeanProperty

/**
  * Created by linseb on 17/12/16.
  */
class Space (var name: Temporal[String]) {

  @BeanProperty
  var uuid: UUID = UUID.randomUUID()

  def setName(name: Temporal[String]): Unit = {
    this.name = name
  }

}
