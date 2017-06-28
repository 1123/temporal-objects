package org.temporalobjects

import java.time.{LocalDateTime, ZoneId}
import java.util.Date

import org.scalatest.{FlatSpec, Matchers}

/**
  * Created by linseb on 17/12/16.
  */
class TemporalEvaluatorSpec extends FlatSpec with Matchers {

  private val date0 = date(2016, 12, 17, 17, 12)
  private val date1 = date(2016, 12, 18, 17, 12)
  private val date2 = date(2016, 12, 19, 17, 12)
  private val date3 = date(2016, 12, 20, 17, 12)
  private val date4 = date(2016, 12, 21, 17, 12)
  private val date5 = date(2016, 12, 22, 17, 12)

  "an object with a temporal single relationship" should "be able to have different versions of this relationship over time" in {
    val company = Company(
      TempOneToMany(List()), // company without employees
      TempOneToOne(List(
        TempValue("abc company", date0, date1), // company was named "abc company" between date0 and date1
        TempValue("def company", date1, date2) // company was named "def company" between date1 and date2
      )))
  }

  "an object with a temporal multi relationship" should "be able to have multiple relations at the same time" in {
    val company = Company(
      TempOneToMany(
        List(
          TempValue(Employee("foo1", "bar1"), date1, date3),
          TempValue(Employee("foo2", "bar2"), date2, date4)
        )
      ), // company has two employees over time. Their employment periods overlap.
      TempOneToOne(List()) // company without name at any given point in time
    )
  }

  private def date(year: Int, month: Int, day: Int, hour: Int, minute: Int) : Date = {
    Date.from(
      LocalDateTime.now()
        .withYear(year).withMonth(month).withDayOfMonth(day).withHour(hour).withMinute(minute)
        .atZone(ZoneId.systemDefault()).toInstant
    )
  }

}

