package microservices.book.multiplication.configuration;

import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// Anotacin que le indica a SpringBoot puede ser origen de definiciones de beans
// es decir ejecuta estos metodos para inyectar estos beans y meterlos en el contexto de aplicacion
@Configuration
public class RabbitMQConfiguration {
	
	//@values sirve para hacer referencia en una propiedad que meteremos en el fichero.properties
	@Bean
	public TopicExchange multiplicationExchange( @Value("${multiplication.exchange}") final String exchangeName){
		return new TopicExchange(exchangeName);		
	}
	
	@Bean
	public RabbitTemplate rabbitTemplate(final ConnectionFactory connectionFactory) {
		RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);	
		rabbitTemplate.setMessageConverter(produccerJackson2MessageConverter());
		return rabbitTemplate;
	}
	
	@Bean
	public Jackson2JsonMessageConverter produccerJackson2MessageConverter() {
		return new Jackson2JsonMessageConverter();
		
	}

}
