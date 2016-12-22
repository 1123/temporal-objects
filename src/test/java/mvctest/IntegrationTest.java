package mvctest;

import com.mongodb.MongoClient;
import mvctest.domain.Organization;
import mvctest.domain.temporal.Temp;
import mvctest.domain.temporal.Temporal;
import mvctest.domain.temporal.TimeSlize;
import mvctest.service.OrganizationRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.net.UnknownHostException;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = TestConfig.class)
public class IntegrationTest {

    @Autowired
    private OrganizationRepository organizationRepository;

    @Test
    public void run() throws InterruptedException {
        organizationRepository.deleteAll();
        Organization org = new Organization();
        Temporal<Organization> toStore = new Temp<>(Collections.singletonList(new TimeSlize<>(org, new Date(), new Date())));
        organizationRepository.save(toStore);
        List<Temporal<Organization>> retrieved = organizationRepository.findAll();
    }
}

@Configuration
@EnableMongoRepositories
class TestConfig extends AbstractMongoConfiguration {

    @Override
    protected String getDatabaseName() {
        return "test";
    }

    @Bean
    @Override
    public MongoClient mongo() throws UnknownHostException {
        return new MongoClient();
    }

}