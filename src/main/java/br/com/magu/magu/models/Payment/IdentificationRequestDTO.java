package br.com.magu.magu.models.Payment;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@Getter
@Builder
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true
)
public class IdentificationRequestDTO {
    private  String type;
    private  String number;
}
