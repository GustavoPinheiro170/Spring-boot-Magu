package br.com.magu.magu.procedure.api.procs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;

@Repository
public class LogsPROC {
    @Autowired
    private EntityManager em;

    public void postRegisterApi(String apiInfo){
        StoredProcedureQuery storedProcedureQuery;
        storedProcedureQuery = em.createNamedStoredProcedureQuery("M_P_LOGS");
        storedProcedureQuery.registerStoredProcedureParameter("p_app_log", String.class, ParameterMode.IN);
        storedProcedureQuery.setParameter("p_app_log" , apiInfo );
        storedProcedureQuery.execute();
    }
}
