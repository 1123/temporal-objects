package org.temporalobjects

import java.util.Date

/**
  * Created by linseb on 19/12/16.
  */
class TimeSlize[T](var t: T, var from: Date, var to: Date) {

  def getT: T = { t }

  def seT(t: T): Unit = {
    this.t = t
  }

  def setFrom(from: Date): Unit = { this.from = from }

  def setTo(from: Date): Unit = { this.to = to }

}


