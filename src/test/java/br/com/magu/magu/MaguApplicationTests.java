package br.com.magu.magu;

import br.com.magu.magu.controller.MaguController;
import br.com.magu.magu.service.ClientService;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

@ExtendWith(MockitoExtension.class)
class MaguApplicationTests {

	@Mock private ClientService clientService;

	@InjectMocks private MaguController maguController;

	@Test
	void contextLoads() {
	}

}
