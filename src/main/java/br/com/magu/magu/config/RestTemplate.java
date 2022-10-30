package br.com.magu.magu.config;

import br.com.magu.magu.repository.Dao.LogsDAO;
import br.com.magu.magu.repository.Dao.RegisterServiceDAO;
import br.com.magu.magu.service.LogsService;
import br.com.magu.magu.service.RegisterServices;
import br.com.magu.magu.service.CardsService;
import br.com.magu.magu.service.ClientService;
import br.com.magu.magu.service.PaymentsService;
import br.com.magu.magu.service.impl.cardsServiceImpl;
import br.com.magu.magu.service.impl.clientServiceImpl;
import br.com.magu.magu.service.impl.paymentServiceImpl;
import br.com.magu.magu.utils.IntegrationUtil;
import com.mercadopago.client.cardtoken.CardTokenClient;
import com.mercadopago.client.customer.CustomerClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RestTemplate {

    @Bean
    ClientService clientService() {
            return new clientServiceImpl();
    }

    @Bean
    IntegrationUtil integrationUtil(){
        return new IntegrationUtil();
    }

    @Bean
    CustomerClient customerClient() { return new CustomerClient();}

    @Bean
    CardsService cardsService() { return new cardsServiceImpl();}

    @Bean
    PaymentsService paymentsService() { return new paymentServiceImpl();}

    @Bean
    CardTokenClient cardTokenClient() { return new CardTokenClient();}

    @Bean
    LogsService logsService() {return  new LogsDAO();}

    @Bean
    RegisterServices registerServices() {return  new RegisterServiceDAO();}



}
