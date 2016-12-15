package mvctest

import com.mongodb.MongoClient
import org.springframework.context.annotation.{Bean, ComponentScan, Configuration}
import org.springframework.boot.autoconfigure.EnableAutoConfiguration

@Configuration
@EnableAutoConfiguration
@ComponentScan
class SampleConfig {

  @Override
  @Bean
  def mongo(): MongoClient = {
    new MongoClient()
  }
}