package tn.esprit.haythemLazaar;

import java.text.ParseException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tn.esprit.haythemLazaar.services.InterfaceService;

@SpringBootTest
class HaythemLazaarApplicationTests {

	@Autowired
	InterfaceService service;

	@Test
	void test() throws ParseException{
	}

}
