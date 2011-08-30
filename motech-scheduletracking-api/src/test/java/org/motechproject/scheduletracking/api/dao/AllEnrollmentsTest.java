package org.motechproject.scheduletracking.api.dao;

import org.joda.time.LocalDate;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.motechproject.scheduletracking.api.domain.enrollment.Enrollment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:applicationScheduleTrackingAPI.xml", "classpath*:applicationPlatformScheduler.xml"})
public class AllEnrollmentsTest {
    @Autowired
    private AllEnrollments allEnrollments;
    private Enrollment enrollment;

    @Before
    public void setUp() {
        enrollment = new Enrollment("1324324", LocalDate.now(), "foo");
        allEnrollments.add(enrollment);
    }

    @Test
    public void shouldFindByExternalIdAndScheduleName() throws Exception {
        List<Enrollment> enrollments = allEnrollments.findByExternalIdAndScheduleName(enrollment.getExternalId(), enrollment.getScheduleName());
        assertThat(enrollments.size(), is(equalTo(1)));
        Enrollment found = enrollments.get(0);
        assertThat(found.getExternalId(), is(equalTo(enrollment.getExternalId())));
        assertThat(found.getScheduleName(), is(equalTo(enrollment.getScheduleName())));
    }

    @Test
    public void addEnrolment() {
        assertNotNull(enrollment.getId());
        assertNotNull(allEnrollments.get(enrollment.getId()));
    }

    @After
    public void tearDown() {
        allEnrollments.remove(enrollment);
    }
}
