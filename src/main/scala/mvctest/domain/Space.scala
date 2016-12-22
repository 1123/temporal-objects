package mvctest.domain

import mvctest.domain.temporal.Temporal

/**
  * Created by linseb on 17/12/16.
  */
class Space (var name: Temporal[String]) {

  def setName(name: Temporal[String]): Unit = {
    this.name = name
  }

}
