package mvctest.web

import com.typesafe.scalalogging.LazyLogging
import mvctest.domain.Organization
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
    organizationRepository.save(org)
  }

}
