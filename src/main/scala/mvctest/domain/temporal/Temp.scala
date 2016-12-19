package mvctest.domain.temporal

/**
  * Created by linseb on 19/12/16.
  */
case class Temp[T](timeSlizes: List[TimeSlize[T]]) extends Temporal[T]
