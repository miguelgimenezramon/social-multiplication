package microservices.book.multiplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import microservices.book.multiplication.domain.Multiplication;
import microservices.book.multiplication.service.MultiplicationService;

@Slf4j
@RestController
@RequestMapping("/multiplications")
public class MultiplicationController {

	private final MultiplicationService multiplicationservice;
	private final int serverPort;
	
	@Autowired
	public MultiplicationController (final MultiplicationService multiplicationservice, @Value("${server.port}") int serverPort) {
		this.multiplicationservice = multiplicationservice; 
		this.serverPort = serverPort;
	}
	
	@GetMapping("/random")
	public Multiplication getRandomMultiplication() {
		log.info("Generating a random multiplication from server @ {}", serverPort);
		return multiplicationservice.createRandomMultiplication();
	}
}
