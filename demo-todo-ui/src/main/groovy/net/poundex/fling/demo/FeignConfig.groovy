package net.poundex.fling.demo

import feign.Feign
import feign.gson.GsonDecoder
import feign.gson.GsonEncoder
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
				encoder(new GsonEncoder()).
				decoder(new GsonDecoder()).
				target(TodoServiceClient, "http://localhost:8080")
	}
}
