package com.slasher.util;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Default;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnit;

@ApplicationScoped
public class EntityManagerProducer {

    @PersistenceUnit
    private EntityManagerFactory emf;

    @PostConstruct
    public void init() {
        if (emf == null) {
            emf = Persistence.createEntityManagerFactory("com.slasher_war_1.0-SNAPSHOTPU");
        }
    }

    @Dependent
    @Produces
    @Default
    public EntityManager createEntityManager() {
        return emf.createEntityManager();
    }

    public void closeEntityManager(@Disposes EntityManager em) {
        if (em.isOpen()) {
            em.close();
        }
    }
}
