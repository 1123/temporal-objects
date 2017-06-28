package org.temporalobjects

import java.util.Date

/**
  * Created by Dr. Benedikt Linse on 26/05/2017.
  */
case class TempOneToOne[T](values: List[TempValue[T]]) {

}

case class TempValue[T](value: T, from: Date, to: Date) {

}