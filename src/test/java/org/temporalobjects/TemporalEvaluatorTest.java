package org.temporalobjects;

import org.junit.Test;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * Created by linseb on 22/12/16.
 */
public class TemporalEvaluatorTest {

    private Date date1 = date(2016, 12, 18, 17, 12);
    private Date date2 = date(2016, 12, 19, 17, 12);
    private Date date3 = date(2016, 12, 20, 17, 12);
    private Date date4 = date(2016, 12, 21, 17, 12);

    private List<Temporal<Employee>> employees =
        Collections.singletonList(
            new Temp<>(
                Collections.singletonList(
                    new Version<>(
                        new Employee(new Just<>("John"), new Just<>("Doe")),
                        date3, date4
                    )
                )
            )
        );

    private Temporal<Company> temporalCompany = new Temp<>(
            Collections.singletonList(
                    new Version<>(
                            new Company(
                                    employees,
                                    new Just<>("ACME")
                            ),
                            date1,
                            date4
                    )
            )
    );

    @Test
    public void test() {
        Temporal<Company> company = new TemporalEvaluator().eval(temporalCompany, date2);
    }

    private Date date(int year, int month, int day, int hour, int minute) {
        return Date.from(
                LocalDateTime.now()
                        .withYear(year).withMonth(month).withDayOfMonth(day).withHour(hour).withMinute(minute)
                        .atZone(ZoneId.systemDefault()).toInstant()
        );
    }

}
