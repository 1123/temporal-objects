package org.temporalobjects

import java.util

/**
  * Created by linseb on 15/12/16.
  */
class Organization() {

  var spaces: java.util.List[Temporal[Space]] = util.Arrays.asList()

  var name: Temporal[String] = Just("")

}







