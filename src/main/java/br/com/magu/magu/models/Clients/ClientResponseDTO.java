package br.com.magu.magu.models.Clients;


import br.com.magu.magu.models.ResponseResult;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ClientResponseDTO extends ResponseResult<AddressMainDTO> {

        private String last_name;
        private String live_mode;
        private Phone phone;
}

