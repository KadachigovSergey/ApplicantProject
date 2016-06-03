package org.sourceit.db;

import org.sourceit.entities.SpecialitySubject;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.List;

public class SpecialitySubjectDBProviderTest {


    private SpecialitySubjectDBProvider provider = SpecialitySubjectDBProvider.INSTANCE;

    @BeforeMethod
    public void beforeDelete() {
        try {
            for (SpecialitySubject specialitySubject : provider.getSpecialitySubjects()) {
                provider.deleteSpecialitySubject(specialitySubject.getId());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @AfterSuite
    public void beforeDelete1() {
        try {
            for (SpecialitySubject specialitySubject : provider.getSpecialitySubjects()) {
                provider.deleteSpecialitySubject(specialitySubject.getId());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getSpecialitySubjects() {
        try {
            List specialitySubjects = SpecialitySubjectDBProvider.INSTANCE.getSpecialitySubjects();
            Assert.assertTrue(specialitySubjects.size() == 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void saveSpecialitySubject() {
        try {
            provider.saveSpecialitySubject(new SpecialitySubject(1L, 1L, "Computer Science", "Science"));
            SpecialitySubject specialitySubject = null;
            Long tempId = null;

            for (SpecialitySubject temp : provider.getSpecialitySubjects()) {
                if (temp.getProfessionName().equalsIgnoreCase("Computer Science")) {
                    tempId = temp.getId();
                }
            }
            Assert.assertTrue(specialitySubject.getId() == tempId);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void deleteProfession() {
        try {
            provider.deleteSpecialitySubject(1L);
            List specialitySubjects = provider.getSpecialitySubjects();
            Assert.assertTrue(specialitySubjects.size() == 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getProfessionsWithResult() {
        try {
            provider.saveSpecialitySubject(new SpecialitySubject(1L, 1L, "Computer Science", "Science"));
            provider.saveSpecialitySubject(new SpecialitySubject(1L, 1L, "Computer Science1", "Science1"));
            provider.saveSpecialitySubject(new SpecialitySubject(1L, 1L, "Computer Science2", "Science2"));
            List SpecialitySubjects = provider.getSpecialitySubjects();

            Assert.assertTrue(SpecialitySubjects.size() == 3);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void updateProfession() {
        try {
            SpecialitySubject specialitySubject = new SpecialitySubject(1L, 1L, "Computer Science3", "Science3");
            provider.saveSpecialitySubject(specialitySubject);

            Assert.assertEquals(provider.getSpecialitySubject(3L).getProfessionName(), "Computer Science3");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}