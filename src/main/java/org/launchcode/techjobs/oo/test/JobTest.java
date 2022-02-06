package org.launchcode.techjobs.oo.test;

import org.junit.Before;
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

    Job test_job1;
    Job test_job1_sameExceptId;
    Job test_job2;
    Job emptyJob;

    @Before
    public void createJobObject(){
        test_job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        test_job2 = new Job("Web Developer", new Employer("LaunchCode"), new Location("St. Louis"), new PositionType("Front-end developer"), new CoreCompetency("JavaScript"));
        test_job1_sameExceptId = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        emptyJob = new Job( "", new Employer(""), new Location(""), new PositionType(""), new CoreCompetency(""));
    }

    @Test
    public void emptyTest(){
        assertTrue(true == true);
    }

    @Test
    public void testSettingJobId(){

        assertFalse(test_job1.getId() == test_job2.getId());
        assertTrue(test_job2.getId() - test_job1.getId() == 1);

    }

    @Test
    public void testJobConstructorSetsAllFields(){

        //these test the String value of each object passed into constructor
        assertTrue(test_job1.getName() == "Product tester");
        assertTrue(test_job1.getCoreCompetency().getValue() == "Persistence");
        assertTrue(test_job1.getEmployer().getValue() == "ACME");
        assertTrue(test_job1.getLocation().getValue() == "Desert");
        assertTrue(test_job1.getPositionType().getValue() == "Quality control");

        //these test the class of each object passed into constructor
        assertTrue(test_job1.getCoreCompetency() instanceof CoreCompetency);
        assertTrue(test_job1.getEmployer() instanceof Employer);
        assertTrue(test_job1.getLocation() instanceof Location);
        assertTrue(test_job1.getPositionType() instanceof PositionType);

    }

    @Test
    public void testJobsForEquality(){
        assertFalse(test_job1 == test_job1_sameExceptId);
    }

    @Before
    public void testJobtoString(){
        emptyJob.toString();
    }

    @Test
    public void testToString(){
        String expected = "\n" +
                "ID: " + test_job1.getId() + "\n" +
                "Name: " + test_job1.getName() + "\n" +
                "Employer: " + test_job1.getEmployer().getValue() + "\n" +
                "Location: " + test_job1.getLocation().getValue() + "\n" +
                "Position Type: " + test_job1.getPositionType().getValue() + "\n" +
                "Core Competency: " + test_job1.getCoreCompetency().getValue() + "\n" +
                "\n";
        assertEquals(expected, test_job1.toString());

        //these test if empty job field returns "Data not available"
        assertEquals("Data not available", emptyJob.getName());
        assertEquals("Data not available", emptyJob.getEmployer().getValue());
        assertEquals("Data not available", emptyJob.getLocation().getValue());
        assertEquals("Data not available", emptyJob.getPositionType().getValue());
        assertEquals("Data not available", emptyJob.getCoreCompetency().getValue());

        //this tests if empty job returns "Oops! This job does not seem to exist."
        assertTrue(emptyJob.toString() == "Oops! This job does not seem to exist.");
    }

}
