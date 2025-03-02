package org.example;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.io.IOException;

import org.example.model.human.*;
import org.example.model.unit.*;
import org.example.utils.JsonManager;

/**
 * Unit test for simple App.
 */
public class AppTest
        extends TestCase {
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest(String testName) {
        super(testName);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(AppTest.class);
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp() {
        assertTrue(true);
    }


    void testJsonSerialization() throws IOException {
        Human rector = new Human("Ivan", "Petrenko", "Oleh", Sex.MALE);
        University oldUniversity = new University("Kyiv University", rector);

        for (int i = 1; i <= 2; i++) {
            Faculty faculty = new Faculty("Faculty " + i, rector);
            oldUniversity.addFaculty(faculty);

            for (int j = 1; j <= 2; j++) {
                Department department = new Department("Department " + j, rector);
                faculty.addDepartment(department);

                for (int k = 1; k <= 2; k++) {
                    Group group = new Group("Group " + k, rector);
                    department.addGroup(group);

                    for (int m = 1; m <= 2; m++) {
                        Student student = new Student("Student " + m, "LastName", "MiddleName", m % 2 == 0 ? Sex.MALE : Sex.FEMALE);
                        group.addStudent(student);
                    }
                }
            }
        }

        String filePath = "university_test.json";
        JsonManager.saveToJsonFile(oldUniversity, filePath);
        University newUniversity = JsonManager.loadFromJsonFile(filePath);

        assertEquals("The deserialized university should be equal to the original", oldUniversity, newUniversity);
    }
}
