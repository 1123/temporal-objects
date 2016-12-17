package mvctest.domain

import java.util.Date

import scala.beans.BeanProperty

/**
  * Created by linseb on 17/12/16.
  */
trait Temporal {

  @BeanProperty
  var from: Date = new Date()

  @BeanProperty
  var to: Date = new Date()

}
