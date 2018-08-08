package de.telra.gateway;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import de.telran.model.Token;
import org.junit.Test;
import org.springframework.web.client.RestTemplate;

import de.telran.gateway.UserGateway;
import de.telran.model.User;

public class UserGatewayTest {
//	RestTemplate s = mock(RestTemplate.class);

	@Test
	public void testRegisterUser() {
		UserGateway gateway = new UserGateway(new RestTemplate());
		boolean register = gateway.register(createTestUser());
		assertTrue("user created", register);
	}

	@Test
	public void testLoginUser() {
		UserGateway gateway = new UserGateway(new RestTemplate());
		Token token = gateway.login(new User("123test1234", "12345"));
		System.out.println("TOKEN "+token.toString());
		assertNotNull("token", token.toString());
	}
	private User createTestUser() {
		User user = new User();
		user.setFirstName("Sergey");
		user.setLastName("Lukichev");
		user.setPassword("test");
		user.setRepeatPassword("test");
		user.setUsername("sergey2");
		return user;
	}

}
