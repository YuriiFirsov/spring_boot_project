package com.spring_boot_project.dao;


import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

import com.spring_boot_project.entity.Worker;

import javax.persistence.EntityManager;

@Repository
public class WorkerDAOImpl implements WorkerDAO {

    @Autowired
    private EntityManager entityManager;

    @Override

    public List<Worker> getAllWorkers() {

        Session session = entityManager.unwrap(Session.class);
        List<Worker> workers = session.createQuery("from Worker", Worker.class).getResultList();
        return workers;
    }

    @Override
    public void saveNewWorker(Worker worker) {
        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(worker);
    }

    @Override
    public Worker getWorker(int id) {
        Session session = entityManager.unwrap(Session.class);
        return session.get(Worker.class, id);
    }

    @Override
    public void deleteWorker(int id) {
        Session session = entityManager.unwrap(Session.class);

        Query<Worker> query = session.createQuery("delete from Worker where id = :workerId");
        query.setParameter("workerId", id);
        query.executeUpdate();
    }


}
