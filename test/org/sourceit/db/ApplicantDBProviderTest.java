package org.sourceit.db;

import org.sourceit.entities.Applicant;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import java.util.List;

public class ApplicantDBProviderTest {

    private ApplicantDBProvider provider = ApplicantDBProvider.INSTANCE;

    @BeforeSuite
     public void beforeDelete() {
        try {
            for (Applicant applicant : provider.getApplicants()) {
                provider.deleteApplicant(applicant.getId());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @AfterSuite
    public void beforeDelete1() {
        try {
            for (Applicant applicant : provider.getApplicants()) {
                provider.deleteApplicant(applicant.getId());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getApplicants() {
        try {
            List applicants = ApplicantDBProvider.INSTANCE.getApplicants();
            Assert.assertTrue(applicants.size() == 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void saveApplicant() {
        try {
            provider.saveApplicant(new Applicant(1L,"Computer Science","Kadachigov","Serhii",2016));

            Applicant applicant = null;
            Long tempId = null;

            for (Applicant temp : provider.getApplicants()) {
                if (temp.getProfessionName().equalsIgnoreCase("Computer Science")) {
                    temp = provider.getApplicant(temp.getId());
                    tempId = temp.getId();
                    System.out.println(tempId);
                }
            }
            Assert.assertTrue(applicant.getId() == tempId);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void deleteApplicant() {
        try {
            provider.deleteApplicant(1L);

            List applicants = provider.getApplicants();

            Assert.assertTrue(applicants.size() == 0);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getApplicantWithResult() {
        try {
            provider.saveApplicant(new Applicant(1L,"Computer Science","Kadachigov","Serhii",2016));
            provider.saveApplicant(new Applicant(1L,"Computer Science","Kadachigov1","Serhii1",2016));
            provider.saveApplicant(new Applicant(1L,"Computer Science","Kadachigov2","Serhii2",2016));
            List applicants = provider.getApplicants();

            Assert.assertTrue(applicants.size() == 3);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void updateApplicant() {
        try {
            Applicant applicant = new Applicant(1L,"Computer Science","Kadachigov3","Serhii3",2016);
            provider.saveApplicant(applicant);
            Assert.assertEquals(provider.getApplicant(3L).getFirstName(), "Serhii3");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}