package br.com.magu.magu.service.impl;

import br.com.magu.magu.models.Payment.PaymentCreateRequestDTO;
import br.com.magu.magu.service.PaymentsService;
import br.com.magu.magu.utils.IntegrationUtil;
import com.fasterxml.jackson.core.type.TypeReference;
import com.google.inject.internal.ErrorsException;
import com.mercadopago.client.common.IdentificationRequest;
import com.mercadopago.client.payment.PaymentClient;
import com.mercadopago.client.payment.PaymentCreateRequest;
import com.mercadopago.client.payment.PaymentPayerRequest;
import com.mercadopago.core.MPRequestOptions;
import com.mercadopago.exceptions.MPApiException;
import com.mercadopago.exceptions.MPException;
import com.mercadopago.resources.payment.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import java.io.IOException;

public class paymentServiceImpl implements PaymentsService {

    @Autowired
    private IntegrationUtil integrationUtil;

    @Value("${url.mp}")
    private String urlMp;

    private static final TypeReference<Payment> payment = new TypeReference<>() {};
    @Override
    public PaymentClient paymentCreateRequest(PaymentCreateRequestDTO request) throws MPException, MPApiException, ErrorsException, IOException {

        PaymentClient client = new PaymentClient();

        PaymentCreateRequest paymentCreateRequest =
                PaymentCreateRequest.builder()
                        .transactionAmount(request.getTransactionAmount())
                        .token(request.getToken())
                        .description(request.getDescription())
                        .installments(request.getInstallments())
                        .paymentMethodId(request.getPaymentMethodId())
                        .payer(
                                PaymentPayerRequest.builder()
                                        .email(request.getPayer().getEmail())
                                        .firstName(request.getPayer().getFirstName())
                                        .identification(
                                                IdentificationRequest.builder()
                                                        .type(request.getPayer().getIdentification().getType())
                                                        .number(request.getPayer().getIdentification().getNumber())
                                                        .build())
                                        .build())
                        .build();

        MPRequestOptions requestOptions = MPRequestOptions.builder()
                .accessToken("TEST-1111532151519208-112707-af85addc21cb7eb4eaf4438217a2c95b-248275892")
                .build();
        client.create(paymentCreateRequest, requestOptions);
        return client;
    }

}
