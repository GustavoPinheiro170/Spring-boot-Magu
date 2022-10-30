package br.com.magu.magu.models.Payment;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.mercadopago.client.payment.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class PaymentCreateRequestDTO {
    private  PaymentAdditionalInfoRequest additionalInfo;
    private  BigDecimal applicationFee;
    private  Boolean binaryMode;
    private  String callbackUrl;
    private  Long campaignId;
    private  Boolean capture;
    private  BigDecimal couponAmount;
    private  String couponCode;
    private  OffsetDateTime dateOfExpiration;
    private  String description;
    private  Long differentialPricingId;
    private  String externalReference;
    private  Integer installments;
    private  String issuerId;
    private  String merchantAccountId;
    private  PaymentMerchantServicesRequest merchantServices;
    private  Map<String, Object> metadata;
    private  BigDecimal netAmount;
    private  String notificationUrl;
    private  PaymentOrderRequest order;
    private  PaymentPayerRequestDTO payer;
    private  String paymentMethodId;
    private  String paymentMethodOptionId;
    private  String processingMode;
    private  String token;
    private  BigDecimal transactionAmount;
    private  PaymentTransactionDetailsRequest transactionDetails;
    private  PaymentPointOfInteractionRequest pointOfInteraction;
    private  Long sponsorId;
    private  String statementDescriptor;
    private  List<PaymentTaxRequest> taxes;
}
