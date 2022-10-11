package br.com.magu.magu.procedure.api.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@Table
@NamedStoredProcedureQueries({@NamedStoredProcedureQuery(name = "logProcedure", procedureName = "m_p_logs" /*, parameters = {
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_app_log", type = String.class)
} */ )})
public class Logs {
    @Id
    private int id;
    private String api_use;
    private Date data;

}
