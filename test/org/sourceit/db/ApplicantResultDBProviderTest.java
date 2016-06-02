package org.sourceit.db;

import org.sourceit.entities.ApplicantResult;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.List;

public class ApplicantResultDBProviderTest {

    private ApplicantResultDBProvider provider = ApplicantResultDBProvider.INSTANCE;

    @BeforeMethod
    public void beforeDelete(){
        try {
            for (ApplicantResult profession : provider.getApplicantResults()) {
                provider.deleteApplicantResult(profession.getId());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @AfterSuite
    public void beforeDelete1() {
        try {
            for (ApplicantResult applicantResult : provider.getApplicantResults()) {
                provider.deleteApplicantResult(applicantResult.getId());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getApplicantResults() {
        try {
            List applicantResults = ApplicantResultDBProvider.INSTANCE.getApplicantResults();
            Assert.assertTrue(applicantResults.size() == 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void saveApplicantResult() {
        try {
            provider.saveApplicantResult(new ApplicantResult(1L,1L,1,"Serhii","Kadachigov","Science"));

            ApplicantResult applicantResult = null;
            Long tempId = null;

            for (ApplicantResult temp : provider.getApplicantResults()) {
                if (temp.getApplicantName().equalsIgnoreCase("Kadachigov")) {
                    tempId = temp.getId();
                }
            }

            Assert.assertTrue(applicantResult.getId() == tempId);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void deleteApplicantResult() {
        try {
            provider.deleteApplicantResult(1L);
            List applicantResults = provider.getApplicantResults();

            Assert.assertTrue(applicantResults.size() == 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getApplicantResultsWithResult() {
        try {
            provider.saveApplicantResult(new ApplicantResult(1L,1L,1,"Serhii","Kadachigov","Science"));
            provider.saveApplicantResult(new ApplicantResult(1L,1L,1,"Serhii1","Kadachigov1","Science1"));
            provider.saveApplicantResult(new ApplicantResult(1L,1L,1,"Serhii2","Kadachigov2","Science2"));
            List applicantResults = provider.getApplicantResults();

            Assert.assertTrue(applicantResults.size() == 3);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void updateApplicantResult() {
        try {
            ApplicantResult applicantResult = new ApplicantResult(1L,1L,1,"Serhii3","Kadachigov3","Science3");
            provider.saveApplicantResult(applicantResult);

            Assert.assertEquals(provider.getApplicantResult(3L).getApplicantName(), "Kadachigov3");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}