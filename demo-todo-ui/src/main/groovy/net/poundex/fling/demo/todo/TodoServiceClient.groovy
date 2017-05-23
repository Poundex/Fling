package net.poundex.fling.demo.todo

import feign.RequestLine

/**
 * Created by poundex on 22/05/17.
 */
interface TodoServiceClient
{
	@RequestLine("GET /todoItem")
	List<TodoModel> index()

}
