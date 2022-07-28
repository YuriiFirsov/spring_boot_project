package com.spring_boot_project.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

import com.spring_boot_project.entity.Worker;

import javax.persistence.EntityManager;
import javax.persistence.Query;

@Repository
public class WorkerDAOImpl implements WorkerDAO {

    @Autowired
    private EntityManager entityManager;

    @Override

    public List<Worker> getAllWorkers() {
        Query query = entityManager.createQuery("from Worker", Worker.class);
        return (List<Worker>) query.getResultList();
    }

    @Override
    public Worker getWorker(int id) {
        Worker worker = entityManager.find(Worker.class, id);

        return worker;
    }

    @Override
    public void saveNewWorker(Worker worker) {

        Worker newWorker = entityManager.merge(worker);
        worker.setId(newWorker.getId());
    }

    @Override
    public void deleteWorker(int id) {


        Query query = entityManager.createQuery("delete from Worker where id =:workerId");
        query.setParameter("workerId", id);
        query.executeUpdate();
    }


}
