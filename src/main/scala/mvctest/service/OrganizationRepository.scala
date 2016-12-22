package mvctest.service

import mvctest.domain.Organization
import mvctest.domain.temporal.Temporal
import org.springframework.data.mongodb.repository.MongoRepository

/**
  *
  * Created by linseb on 15/12/16.
  */
trait OrganizationRepository extends MongoRepository[Temporal[Organization], String] {


}



