package microservices.book.multiplication.service;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import microservices.book.multiplication.domain.Multiplication;
import microservices.book.multiplication.domain.MultiplicationResultAttempt;
import microservices.book.multiplication.domain.User;

@TestInstance(Lifecycle.PER_CLASS)
@ExtendWith(SpringExtension.class)
public class MultiplicationServiceImplJUnit5Test {

	private MultiplicationServiceImpl multiplicationServiceImpl;

	@Mock
	private RandomGeneratorService randomGeneratorService;

	@BeforeAll
	public void setUp() {
		// With this call to initMocks we tell Mockito to process the annotations
		MockitoAnnotations.openMocks(this);
		multiplicationServiceImpl = new MultiplicationServiceImpl(randomGeneratorService);
	}

	@Test
	public void createRandomMultiplicationTest() {

		// given (our mocked Random Generator service will return first 50, then 30)
		given(randomGeneratorService.generateRandomFactor()).willReturn(50, 30);
		
		// when
		Multiplication multiplication = multiplicationServiceImpl.createRandomMultiplication();

		// assert
		assertThat(multiplication.getFactorA()).isEqualTo(50);
		assertThat(multiplication.getFactorB()).isEqualTo(30);
		//assertThat(multiplication.getResult()).isEqualTo(1500);
	}	
	
	@Test
	public void checkCorrectAttempTest() {
		Multiplication multiplication = new Multiplication(50,60);
		User user = new User("Miguel");
		MultiplicationResultAttempt attempt = new MultiplicationResultAttempt(user, multiplication, 3000, false);
		boolean attemptResult = multiplicationServiceImpl.checkAttempt(attempt);
		assertThat(attemptResult).isTrue();
	}
	
	@Test
	public void checkIncorrectAttempTest() {
		Multiplication multiplication = new Multiplication(50,60);
		User user = new User("Miguel");
		MultiplicationResultAttempt attempt = new MultiplicationResultAttempt(user, multiplication, 3010, false);
		boolean attemptResult = multiplicationServiceImpl.checkAttempt(attempt);
		assertThat(attemptResult).isFalse();
		
	}
}
