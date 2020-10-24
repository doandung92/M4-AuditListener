package com.codegym.wdbsspringboot.vm;

import com.codegym.wdbsspringboot.model.AppUser;
import com.codegym.wdbsspringboot.sercure.userservice.IAppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

public class AuditorAwareImpl implements AuditorAware<String> {
    @Autowired
    IAppUserService appUserService;

    @Override
    public Optional<String> getCurrentAuditor() {
        String name = "System";
        AppUser appUser = appUserService.getCurrentUser();
        if (appUser != null) name = appUser.getUsername();
        return Optional.ofNullable(name);
    }
}
