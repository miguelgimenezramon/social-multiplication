package microservices.book.multiplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import microservices.book.multiplication.domain.Multiplication;
import microservices.book.multiplication.service.MultiplicationService;

@RestController
@RequestMapping("/multiplications")
public class MultiplicationController {

	private final MultiplicationService multiplicationservice;
	
	@Autowired
	public MultiplicationController (final MultiplicationService multiplicationservice) {
		this.multiplicationservice = multiplicationservice; 
	}
	
	@GetMapping("/random")
	public Multiplication getRandomMultiplication() {
		return multiplicationservice.createRandomMultiplication();
	}
}
