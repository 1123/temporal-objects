package mvctest.domain.temporal

/**
  * Created by linseb on 19/12/16.
  */
case class Just[T](t: T) extends Temporal[T]
