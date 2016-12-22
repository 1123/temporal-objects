package org.temporalobjects

import java.util
import java.util.Date

import scala.collection.JavaConversions._

/**
  *
  * Created by linseb on 15/12/16.
  */
class TemporalEvaluator {

  def eval[T](t: Temporal[T], date: Date): Temporal[T] = {
    t match {
      case Just(o) => Just(o)
      case Absent() => Absent()
      case Temp(o) =>
        val active = o.toList.filter(
          timeSlize => timeSlize.from.compareTo(date) <= 0 && timeSlize.to.after(date)
        )
        if (active.isEmpty) Absent()
        else Just(evalFields(active.head.t, date))
    }
  }

  def evalFields[T](o: T, date: Date): T = {
    o.getClass.getDeclaredFields.foreach(field => {
      if (field.getType.getSimpleName.equals("Temporal")) {
        field.setAccessible(true)
        field.set(o,
          this.eval(
            field.get(o).asInstanceOf[Temporal[Any]],
            date
          ))
      }
      if (field.getType.getSimpleName.equals("List")) {
        field.setAccessible(true)
        val evaluatedElements = field.get(o).asInstanceOf[java.util.List[Temporal[Any]]].map({
          case element@Temp(_) => eval(element.asInstanceOf[Temporal[Any]], date)
          case element => element
        }).filter(elem => elem match {
          case Absent() => false
          case _ => true
        })
        field.set(o, new util.ArrayList(evaluatedElements))
      }
    })
    o
  }

}



