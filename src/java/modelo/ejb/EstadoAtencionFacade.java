/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import modelo.entity.EstadoAtencion;

/**
 *
 * @author QANOVA1
 */
@Stateless
public class EstadoAtencionFacade extends AbstractFacade<EstadoAtencion> {

    @PersistenceContext(unitName = "CentroMedicoGalenosPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EstadoAtencionFacade() {
        super(EstadoAtencion.class);
    }
    
}
