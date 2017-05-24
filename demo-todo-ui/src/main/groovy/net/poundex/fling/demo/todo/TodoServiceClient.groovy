package net.poundex.fling.demo.todo

import feign.Param
import feign.RequestLine

/**
 * Created by poundex on 22/05/17.
 */
interface TodoServiceClient
{
	@RequestLine("GET /todoItem")
	List<TodoModel> index()

	@RequestLine("GET /todoItem/show/{id}")
	TodoModel get(@Param('id') long id)
}
