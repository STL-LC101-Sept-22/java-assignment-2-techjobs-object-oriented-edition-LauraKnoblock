package org.launchcode.techjobs.oo.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.*;

import static org.junit.Assert.*;

/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)
public class JobTest {

    @Test
    public void testSettingJobId() {
        Job job1 = new Job();
        Job job2 = new Job();
        assertFalse(job1.getId() == job2.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        Job job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertTrue(job1.getName().equals("Product tester"));
        assertTrue(job1.getEmployer().toString().equals("ACME"));
        assertTrue(job1.getLocation().toString().equals("Desert"));
        assertTrue(job1.getPositionType().toString().equals("Quality control"));
        assertTrue(job1.getCoreCompetency().toString().equals("Persistence"));
//        assertEquals(job1 instanceof Job);



    }

    @Test
    public void testJobsForEquality() {
        Job job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job job2 = new Job("Puppeteer", new Employer("Big Bird"), new Location("123 Sesame Street"), new PositionType("Puppeteer"), new CoreCompetency("Imagination"));
        assertFalse(job1.getId() == (job2.getId()));

    }

}
