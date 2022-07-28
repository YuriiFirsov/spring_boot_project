package com.spring_boot_project.dao;

import com.spring_boot_project.entity.Worker;

import java.util.List;

public interface WorkerDAO {
    public List<Worker> getAllWorkers();

    public void saveNewWorker(Worker worker);

    public Worker getWorker(int id);

    public void deleteWorker(int id);


}
