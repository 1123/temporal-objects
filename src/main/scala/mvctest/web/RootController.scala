package mvctest.web

import mvctest.domain.Organization
import mvctest.service.OrganizationRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping

@Controller
class RootController {

  @RequestMapping(Array("/"))
  def handleRootRequest(): String = "redirect:/hotels"

  @Autowired
  def organizationRepo: OrganizationRepository

  def get(): java.util.List[Organization] = {
    organizationRepo.findAll()
  }
}
