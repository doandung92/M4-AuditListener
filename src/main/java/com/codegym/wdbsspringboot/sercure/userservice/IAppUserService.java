package com.codegym.wdbsspringboot.sercure.userservice;


import com.codegym.wdbsspringboot.model.AppUser;

public interface IAppUserService {
    AppUser getUserByUsername(String username);
    AppUser getCurrentUser();
}
