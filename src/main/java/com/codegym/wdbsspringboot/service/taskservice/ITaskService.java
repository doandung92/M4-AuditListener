package com.codegym.wdbsspringboot.service.taskservice;

import com.codegym.wdbsspringboot.model.AppUser;
import com.codegym.wdbsspringboot.model.Task;
import com.codegym.wdbsspringboot.service.GeneralService;

public interface ITaskService extends GeneralService<Task> {
    Iterable<Task> findAllByUser(AppUser user);
}
