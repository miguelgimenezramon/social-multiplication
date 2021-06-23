package microservices.book.multiplication.service;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import microservices.book.multiplication.domain.Multiplication;


@TestInstance(Lifecycle.PER_CLASS)
@ExtendWith(SpringExtension.class)
@Import(MultiplicationServiceImpl.class)
public class MultiplicationServiceJunit5Test {
	
	@MockBean
	private RandomGeneratorService randomGeneratorService;
	
	@Autowired
	private MultiplicationService multiplicationService;
	
	//@Test	
	public void createRandomMultiplicationTest() {
		// given (our mocked Random Generator service will return first 50, then 30)
		given(randomGeneratorService.generateRandomFactor()).willReturn(50, 30);
		// when
		Multiplication multiplication = multiplicationService.createRandomMultiplication();
		// then
		assertThat(multiplication.getFactorA()).isEqualTo(50);
		assertThat(multiplication.getFactorB()).isEqualTo(30);
		//assertThat(multiplication.getResult()).isEqualTo(1500);
	}
}

