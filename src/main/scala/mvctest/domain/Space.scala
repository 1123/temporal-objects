package mvctest.domain

import java.util.UUID

import scala.beans.BeanProperty

/**
  * Created by linseb on 17/12/16.
  */
class Space extends Temporal {

  @BeanProperty
  var uuid: UUID = UUID.randomUUID()

  @BeanProperty
  var names: java.util.List[TemporalString] = java.util.Arrays.asList(new TemporalString)

}
