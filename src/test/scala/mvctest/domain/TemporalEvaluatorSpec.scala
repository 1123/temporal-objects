package mvctest.domain

import java.time.{LocalDateTime, ZoneId}
import java.util
import java.util.Date

import mvctest.domain.temporal._
import mvctest.service.TemporalEvaluator
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

  def fixture =
    new {
      val org = new Organization()
      org.name = Just("my_org")
      org.spaces = util.Arrays.asList(
        Temp(util.Arrays.asList(new TimeSlize[Space](new Space(Just("my_space")), date3, date4)))
      )
      val evaluator = new TemporalEvaluator
      val temporalOrg: Temporal[Organization] = Temp(
        util.Arrays.asList(
          new TimeSlize(
            org,
            date1,
            date4
          )
        )
      )
    }

  "the temporal evaluator" should "be able to determine the state of an object over time" in {
    val org2 = fixture.evaluator.eval(fixture.temporalOrg, date2)
    org2 match {
      case Just(x) =>
        x.name should equal (Just("my_org"))
        x.spaces should be (empty)
      case _ => fail()
    }
    val org3 = fixture.evaluator.eval(fixture.temporalOrg, date3)
    org3 match {
      case Just(org) =>
        org.name should equal(Just("my_org"))
        org.spaces should have length 1
        org.spaces.get(0) match {
          case Just(space) => space.name should be (Just("my_space"))
          case _ => fail()
        }
      case _ => fail()
    }
    fixture.evaluator.eval(fixture.temporalOrg, date5) should equal (Absent())
    fixture.evaluator.eval(fixture.temporalOrg, date0) should equal (Absent())
  }

  private def date(year: Int, month: Int, day: Int, hour: Int, minute: Int) : Date = {
    Date.from(
      LocalDateTime.now()
        .withYear(year).withMonth(month).withDayOfMonth(day).withHour(hour).withMinute(minute)
        .atZone(ZoneId.systemDefault()).toInstant
    )
  }

}

