package microservices.book.multiplication.event;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@RequiredArgsConstructor
@NoArgsConstructor(force=true)
@Getter
@ToString
@EqualsAndHashCode
public class MultiplicationSolvedEvent {
	
	private final Long multiplicationResultAttemptId;
	private final Long userId;
	private final boolean correct;

}
