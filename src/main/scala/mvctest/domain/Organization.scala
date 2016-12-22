package mvctest.domain

import java.util

import mvctest.domain.temporal.{Just, Temp, Temporal}

/**
  * Created by linseb on 15/12/16.
  */
class Organization() {

  var spaces: java.util.List[Temporal[Space]] = util.Arrays.asList()

  var name: Temporal[String] = Just("")

}







