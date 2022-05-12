package com.slasher.repository;

import com.slasher.model.AdmPresident;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@RequestScoped
@Transactional(Transactional.TxType.REQUIRES_NEW)
public class AdmPresidentRepository {

    @Inject
    EntityManager em;

    public void create(AdmPresident admPresident) {
        em.persist(admPresident);
    }

    public AdmPresident update(AdmPresident admPresident) {
        return em.merge(admPresident);
    }

    public void delete(AdmPresident admPresident) {
        em.remove(admPresident);
    }

    public AdmPresident findById(Long id) {
        return em.find(AdmPresident.class, id);
    }

    public List<AdmPresident> listAll() {
        return em.createQuery("SELECT a FROM AdmPresident a", AdmPresident.class).getResultList();
    }

    public List<AdmPresident> searchBySimilarName(String name) {
        return em.createQuery("SELECT a FROM AdmPresident a WHERE a.name LIKE :name", AdmPresident.class)
                .setParameter("name","%" + name + "%")
                .getResultList();
    }

}
