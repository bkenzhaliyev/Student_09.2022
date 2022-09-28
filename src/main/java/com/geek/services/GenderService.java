package com.geek.services;

import com.geek.dao.GenderDao;
import com.geek.models.Gender;

import java.util.List;

public class GenderService {
    private GenderDao gendersDao = new GenderDao();

    public GenderService() {
    }

    public Gender findGender(int id) {
        return gendersDao.findById(id);
    }

    public Gender findGenderTitle(String title) {
        return gendersDao.findByGenderTitle(title);
    }

    public void saveGender(Gender gender) {
        gendersDao.save(gender);
    }

    public void deleteGender(Gender gender) {
        gendersDao.delete(gender);
    }

    public void updateGender(Gender gender) {
        gendersDao.update(gender);
    }

    public List<Gender> findAllGender() {
        return gendersDao.findAll();
    }

}
