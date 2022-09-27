package br.com.magu.magu.models.Cards;

import com.mercadopago.exceptions.MPApiException;
import com.mercadopago.exceptions.MPException;
import com.mercadopago.net.MPHttpClient;
import com.mercadopago.net.MPRequest;
import com.mercadopago.net.MPResponse;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class CardTokenRequest  {
    private  String cardId;
    private  String customerId;
    private  String securityCode;

}
