package microservices.book.multiplication.domain;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
/**
* This represents a Multiplication (a * b).
*/
@RequiredArgsConstructor
@NoArgsConstructor(force=true)
@Getter
@ToString
@EqualsAndHashCode
public final class Multiplication {

	// Both factors
	private final int factorA;
	private final int factorB;

	// Empty constructor for JSON (de)serialization
//	Multiplication() {
//		this(0, 0);
//	}
	
}
