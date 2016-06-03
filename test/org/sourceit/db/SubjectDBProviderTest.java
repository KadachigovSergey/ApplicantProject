package org.sourceit.db;

import org.sourceit.entities.Subject;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.List;

public class SubjectDBProviderTest {

    private SubjectDBProvider provider = SubjectDBProvider.INSTANCE;

    @BeforeMethod
    public void beforeDelete() {
        try {
            for (Subject subject : provider.getSubjects()) {
                provider.deleteSubject(subject.getId());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @AfterSuite
    public void AfterDelete() {
        try {
            for (Subject subject : provider.getSubjects()) {
                provider.deleteSubject(subject.getId());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getSubjects() {
        try {
            List subjects = provider.getSubjects();
            Assert.assertTrue(subjects.size() == 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void saveSubject() {
        try {
            provider.saveSubject(new Subject("science"));
            Subject subject = null;
            Long tempId = null;
            for (Subject temp : provider.getSubjects()) {
                if (temp.getSubjectName().equalsIgnoreCase("science")) {
                    tempId = temp.getId();
                }
            }
            assert false;
            Assert.assertTrue(subject.getId() == tempId);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void deleteSubject() {
        try {
            provider.deleteSubject(1L);
            List professions = provider.getSubjects();
            Assert.assertTrue(professions.size() == 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getSubjectsWithResult() {
        try {
            provider.saveSubject(new Subject("science"));
            provider.saveSubject(new Subject("science1"));
            provider.saveSubject(new Subject("science2"));
            List subjects = provider.getSubjects();

            Assert.assertTrue(subjects.size() == 3);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    public void updateSubject() {
        try {
            Subject subject = new Subject("science3");
            provider.saveSubject(subject);
            Assert.assertEquals(provider.getSubject(3L).getSubjectName(), "science3");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}