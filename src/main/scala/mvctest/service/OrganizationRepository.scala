package mvctest.service

import java.util.UUID
import javax.persistence.{Entity, Id}

import mvctest.domain.Organization
import org.springframework.data.mongodb.repository.MongoRepository

/**
  *
  * Created by linseb on 15/12/16.
  */
trait OrganizationRepository extends MongoRepository[Organization, String] {


}



