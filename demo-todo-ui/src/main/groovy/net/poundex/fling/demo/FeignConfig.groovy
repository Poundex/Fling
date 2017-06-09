package net.poundex.fling.demo

import feign.Feign
import feign.Response
import feign.codec.ErrorDecoder
import feign.jackson.JacksonDecoder
import feign.jackson.JacksonEncoder
import fling.util.springerrors.ValidationException
import groovy.json.JsonSlurper
import net.poundex.fling.demo.todo.CategoryServiceClient
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
	TodoServiceClient todoServiceClient(ErrorDecoder springErrorDecoder)
	{
		return Feign.
				builder().
				errorDecoder(springErrorDecoder).
				encoder(new JacksonEncoder()).
				decoder(new JacksonDecoder()).
				target(TodoServiceClient, "http://localhost:8080")
	}

	@Bean
	CategoryServiceClient categoryServiceClient(ErrorDecoder springErrorDecoder)
	{
		return Feign.
				builder().
				errorDecoder(springErrorDecoder).
				encoder(new JacksonEncoder()).
				decoder(new JacksonDecoder()).
				target(CategoryServiceClient, "http://localhost:8080")
	}

	@Bean
	ErrorDecoder springErrorsDecoder()
	{
		return new ErrorDecoder() {
			@Override
			Exception decode(String methodKey, Response response)
			{
				if (response.status() == 422)
					return new ValidationException(new JsonSlurper().parse(response.body().asInputStream())['errors'])

				return new ErrorDecoder.Default().decode(methodKey, response)
			}
		}
	}



}
