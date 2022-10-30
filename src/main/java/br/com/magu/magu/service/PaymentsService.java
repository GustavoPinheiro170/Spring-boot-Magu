package br.com.magu.magu.service;

import br.com.magu.magu.models.Payment.PaymentCreateRequestDTO;
import com.google.inject.internal.ErrorsException;
import com.mercadopago.client.MercadoPagoClient;
import com.mercadopago.client.payment.PaymentClient;
import com.mercadopago.exceptions.MPApiException;
import com.mercadopago.exceptions.MPException;
import org.springframework.stereotype.Service;

import java.io.IOException;


@Service("PaymentService")
public interface PaymentsService {

    PaymentClient paymentCreateRequest(PaymentCreateRequestDTO request) throws MPException, MPApiException, ErrorsException, IOException;

}
