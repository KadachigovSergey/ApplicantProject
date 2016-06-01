package org.sourceit.db;

import org.sourceit.entities.Applicant;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;


import java.util.List;

public class ApplicantDBProviderTest {

    private ApplicantDBProvider provider = ApplicantDBProvider.INSTANCE;
    @Test

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
            System.out.println("ff1");
            System.out.println(applicant.getId()+" "+tempId+" "+tempId);
            System.out.println("ff");


            Assert.assertTrue(applicant.getId() == tempId);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
//
//    @Test
//    public void deleteProfession() {
//        try {
//            provider.deleteProfession(1L);
//
//            List professions = provider.getProfessions();
//
//            Assert.assertTrue(professions.size() == 0);
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    @Test
//    public void getProfessionsWithResult() {
//        try {
//            // 2
//            provider.saveProfession(new Profession("Computer Science"));
//            // 3
//            provider.saveProfession(new Profession("Nuclear Physics"));
//            // 4
//            provider.saveProfession(new Profession("System administration"));
//            List professions = provider.getProfessions();
//            System.out.println(professions.size());
//
//            Assert.assertTrue(professions.size() == 3);
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    @Test
//    public void updateProfession() {
//        try {
//            Profession profession = new Profession("Nuclear Reactors");
//            profession.setId(3L);
//            provider.saveProfession(profession);
//
//            Assert.assertEquals(provider.getProfession(3L).getProfessionName(), "Nuclear Reactors");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }


}
