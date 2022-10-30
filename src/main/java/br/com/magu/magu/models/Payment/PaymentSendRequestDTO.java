package br.com.magu.magu.models.Payment;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PaymentSendRequestDTO {
        private String token;
        private String issuer_id;
        private String payment_method_id;
        private BigDecimal transaction_amount;
        private Integer installments;
        private String description;
        private PaymentPayerRequestDTO payer;
}
