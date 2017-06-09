package net.poundex.fling.demo.todo

import feign.RequestLine

/**
 * Created by poundex on 22/05/17.
 */
interface CategoryServiceClient
{
	@RequestLine("GET /category")
	List<CategoryModel> index()
//
//	@RequestLine("GET /todoItem/show/{id}")
//	TodoModel get(@Param('id') long id)
//
//	@RequestLine("POST /todoItem/save")
//	@Headers("Content-Type: application/json")
//	TodoModel save(TodoModel todoItem)
//
//	@RequestLine("PUT /todoItem/update/{id}")
//	@Headers("Content-Type: application/json")
//	TodoModel save(@Param('id') long id, TodoModel todoItem)
//
//	@RequestLine("DELETE /todoItem/delete/{id}")
//	void delete(@Param('id') long id)

}
