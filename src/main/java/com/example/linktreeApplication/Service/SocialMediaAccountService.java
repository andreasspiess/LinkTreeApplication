package com.example.linktreeApplication.Service;

import com.example.linktreeApplication.Entity.SocialMediaAccount;
import com.example.linktreeApplication.Repo.SocialMediaAccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SocialMediaAccountService {

    @Autowired
    private SocialMediaAccountRepo socialMediaAccountRepo;

    public List<SocialMediaAccount> findAll() {
        return socialMediaAccountRepo.findAll();
    }

    public void save(SocialMediaAccount socialMediaAccount) {
        socialMediaAccountRepo.save(socialMediaAccount);
    }

    public SocialMediaAccount get(Long id) {
        return socialMediaAccountRepo.findById(id).orElse(null);
    }

    public void delete(Long id) {
        socialMediaAccountRepo.deleteById(id);
    }

    public SocialMediaAccount findById(Long id) {
        return socialMediaAccountRepo.findById(id).orElse(null);
    }

}
