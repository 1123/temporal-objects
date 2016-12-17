package mvctest.domain

import java.util
import java.util.{Date, UUID}

import org.springframework.data.annotation.Id

import scala.beans.BeanProperty

/**
  * Created by linseb on 15/12/16.
  */
class Organization() extends Temporal {

  @Id
  @BeanProperty
  var uuid : UUID = UUID.randomUUID()

  @BeanProperty
  var names: java.util.List[TemporalString] = util.Arrays.asList(new TemporalString)

  @BeanProperty
  var spaces: java.util.List[Space] = util.Arrays.asList(new Space())

}





