package mvctest.domain

import java.time.{LocalDateTime, ZoneId}
import java.util.Date

import mvctest.domain.temporal.{Just, Temp}
import org.scalatest.{FlatSpec, Matchers}

/**
  * Created by linseb on 17/12/16.
  */
class OrganizationSpec extends FlatSpec with Matchers {

  "a test" should "run" in {
    val org = new Organization()
    org.name = Just("my_org")
  }

  def date(year: Int, month: Int, day: Int, hour: Int, minute: Int) : Date = {
    Date.from(
      LocalDateTime.now()
        .withYear(year).withMonth(month).withDayOfMonth(day).withHour(hour).withMinute(minute)
        .atZone(ZoneId.systemDefault()).toInstant
    )
  }

}

