package br.com.magu.magu.repository.mapper;

import br.com.magu.magu.repository.model.ClientAddress;
import br.com.magu.magu.repository.model.ClientDetails;
import br.com.magu.magu.repository.model.ClientDocuments;
import br.com.magu.magu.repository.model.RegistredClient;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RegistredClientRowMapper implements RowMapper<RegistredClient> {
  public RegistredClient mapRow(ResultSet rs, int rowNum) throws SQLException {

    RegistredClient registredClient = new RegistredClient();
    ClientDetails clientDetails = new ClientDetails();
    ClientAddress clientAddress = new ClientAddress();
    ClientDocuments clientDocuments = new ClientDocuments();

    clientDetails.setId(String.valueOf(rs.getInt("id")));
    clientDetails.setName(rs.getString("name"));
    clientDetails.setEmail(rs.getString("email"));
    clientDetails.setLastName(rs.getString("last_name"));
    clientDetails.setBirthDate(rs.getString("birth_date"));
    clientDetails.setUser(rs.getString("user"));

    clientAddress.setStreet(rs.getString("street"));
    clientAddress.setCity(rs.getString("city"));
    clientAddress.setState(rs.getString("state"));
    clientAddress.setNeighborhood(rs.getString("neighborhood"));
    clientAddress.setZipCode(rs.getString("zipcode"));
    clientAddress.setNumber(rs.getString("number"));

    clientDocuments.setDocumentNumber(rs.getString("document_number"));
    clientDocuments.setDocumentType(rs.getString("document_type"));

    clientDetails.setClientDocuments(clientDocuments);
    registredClient.setClientAddress(clientAddress);
    registredClient.setClientDetails(clientDetails);

    return registredClient;

    }
}
