package mvctest.domain

import scala.beans.BeanProperty

/**
  * Created by linseb on 17/12/16.
  */
class TemporalString() extends Temporal {

  @BeanProperty
  var value: String = "test-org"

}
