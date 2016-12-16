package mvctest.domain

import java.util.{Date, UUID}
import javax.persistence.{Entity, Id}

import scala.beans.BeanProperty

/**
  * Created by linseb on 15/12/16.
  */
@Entity
class Organization() extends Temporal {

  @Id
  @BeanProperty
  var uuid : UUID = UUID.randomUUID()

  @BeanProperty
  var name: String = "sample"

}

trait Temporal {

  @BeanProperty
  var from: Date = new Date()

  @BeanProperty
  var to: Date = new Date()

}