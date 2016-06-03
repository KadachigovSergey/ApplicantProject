package org.sourceit.db;

import org.testng.Assert;
import org.sourceit.entities.Profession;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.List;

public class ProfessionDBProviderTest {

    private ProfessionDBProvider provider = ProfessionDBProvider.INSTANCE;

    @BeforeMethod
    public void beforeDelete() {
        try {
            for (Profession profession : provider.getProfessions()) {
                provider.deleteProfession(profession.getId());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @AfterSuite
    public void beforeDelete1() {
        try {
            for (Profession profession : provider.getProfessions()) {
                provider.deleteProfession(profession.getId());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getProfessions() {
        try {
            List professions = ProfessionDBProvider.INSTANCE.getProfessions();
            Assert.assertTrue(professions.size() == 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void saveProfession() {
        try {
            provider.saveProfession(new Profession("Computer Science"));

            Profession profession = null;
            Long tempId = null;

            for (Profession temp : provider.getProfessions()) {
                if (temp.getProfessionName().equalsIgnoreCase("Computer Science")) {
                    tempId = temp.getId();
                }
            }
            assert false;
            Assert.assertTrue(profession.getId() == tempId);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void deleteProfession() {
        try {
            provider.deleteProfession(1L);
            List professions1 = provider.getProfessions();

            Assert.assertTrue(professions1.size() == 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getProfessionsWithResult() {
        try {
            provider.saveProfession(new Profession("Computer Science"));
            provider.saveProfession(new Profession("Nuclear Physics"));
            provider.saveProfession(new Profession("System administration"));
            List professions = provider.getProfessions();

            Assert.assertTrue(professions.size() == 3);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void updateProfession() {
        try {
            Profession profession = new Profession("Nuclear Reactors");
            provider.saveProfession(profession);

            Assert.assertEquals(provider.getProfession(3L).getProfessionName(), "Nuclear Reactors");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}