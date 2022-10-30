package br.com.magu.magu.models.Payment;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.mercadopago.client.common.IdentificationRequest;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class PaymentPayerRequestDTO {

        private String type;
        private  String id;
        private  String email;
        private  IdentificationRequestDTO identification;
        private  String firstName;
        private  String lastName;
        private  String entityType;
}
