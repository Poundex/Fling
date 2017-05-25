package net.poundex.fling.demo

import feign.Feign
import feign.jackson.JacksonDecoder
import feign.jackson.JacksonEncoder
import net.poundex.fling.demo.todo.TodoServiceClient
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

/**
 * Created by poundex on 22/05/17.
 */
@Configuration
class FeignConfig
{
	@Bean
	TodoServiceClient todoServiceClient()
	{
		return Feign.
				builder().
				encoder(new JacksonEncoder()).
				decoder(new JacksonDecoder()).
				target(TodoServiceClient, "http://localhost:8080")
	}
}
