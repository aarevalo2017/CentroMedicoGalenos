/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import modelo.entity.Paciente;

/**
 *
 * @author QANOVA1
 */
@Stateless
public class PacienteFacade extends AbstractFacade<Paciente> {

    @PersistenceContext(unitName = "CentroMedicoGalenosPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PacienteFacade() {
        super(Paciente.class);
    }

    public Paciente getByRut(int rut) {
        try {
            Query q = em.createNamedQuery("Paciente.findByRut");
            q.setParameter("rut", rut);
            return (Paciente) q.getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }

}
