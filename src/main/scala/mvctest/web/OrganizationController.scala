package mvctest.web

import java.util
import java.util.Date

import com.typesafe.scalalogging.LazyLogging
import mvctest.domain.{Organization, Space}
import mvctest.domain.temporal.{Just, Temp, Temporal, TimeSlize}
import mvctest.service.OrganizationRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.{RequestMapping, RequestMethod, RestController}

@RestController
class OrganizationController @Autowired()(private val organizationRepository: OrganizationRepository)
  extends LazyLogging {

  @RequestMapping(Array("/"))
  def get(): java.util.List[Organization] = {
    organizationRepository.findAll()
  }

  @RequestMapping(method = Array(RequestMethod.DELETE), value = Array("/"))
  def deleteAll() : Unit = {
    logger.info("Deleting all orgs.")
    organizationRepository.deleteAll()
  }

  @RequestMapping(method = Array(RequestMethod.POST), value = Array("/"))
  def post() : Unit = {
    logger.info("New organization posted.")
    val org = new Organization()
    org.spaces = new Temp[Space](
        List(
          new TimeSlize[Space](
            new Space(Just("my_space")),
            new Date(),
            null
          )
        )
      )
    org.name = Just("my_org")
    organizationRepository.save(org)
  }

}
