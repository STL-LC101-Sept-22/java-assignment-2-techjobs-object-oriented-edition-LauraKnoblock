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
        assertEquals(job1.getName(), "Product tester");
        assertEquals(job1.getEmployer().toString(), "ACME");
        assertEquals(job1.getLocation().toString(),"Desert");
        assertEquals(job1.getPositionType().toString(),"Quality control");
        assertEquals(job1.getCoreCompetency().toString(), "Persistence");
        assertTrue(job1 instanceof Job);
        assertTrue(job1.getEmployer() instanceof Employer);
        assertTrue(job1.getLocation() instanceof Location);
        assertTrue(job1.getPositionType() instanceof PositionType);
        assertTrue(job1.getCoreCompetency() instanceof CoreCompetency);


    }

    @Test
    public void testJobsForEquality() {
        Job job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job job2 = new Job("Puppeteer", new Employer("Big Bird"), new Location("123 Sesame Street"), new PositionType("Puppeteer"), new CoreCompetency("Imagination"));
        assertFalse(job1.getId() == (job2.getId()));

    }

    @Test
    public void testToStringStartsAndEndsWithNewLine() {
        Job job = new Job("Web Developer", new Employer("LaunchCode"), new Location("StL"), new PositionType("Back-end developer"), new CoreCompetency("Java"));
        char firstChar = job.toString().charAt(0);
        char lastChar = job.toString().charAt(job.toString().length() - 1);
        assertEquals(firstChar, '\n');
        assertEquals(lastChar, '\n');
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData() {
        Job job = new Job("Web Developer", new Employer("LaunchCode"), new Location("StL"), new PositionType("Back-end developer"), new CoreCompetency("Java"));
        assertEquals(job.toString(), "\nID: " + job.getId() + "\n" +
                "Name: Web Developer\n" +
                "Employer: LaunchCode\n" +
                "Location: StL\n" +
                "Position Type: Back-end developer\n" +
                "Core Competency: Java\n");

    }

    @Test
    public void testToStringHandlesEmptyField() {
        Job job = new Job("", new Employer("LaunchCode"), new Location("StL"), new PositionType("Back-end developer"), new CoreCompetency("Java"));
        assertEquals(job.toString(),"\nID: "+ job.getId() + "\n" +
                "Name: Data not available\n" +
                "Employer: LaunchCode\n" +
                "Location: StL\n" +
                "Position Type: Back-end developer\n" +
                "Core Competency: Java\n");
    }
}