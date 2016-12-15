package mvctest.domain

import java.util.UUID
import javax.persistence.{Entity, Id}

/**
  * Created by linseb on 15/12/16.
  */
@Entity
class Organization {

  @Id
  val uuid : UUID = UUID.randomUUID()

}
