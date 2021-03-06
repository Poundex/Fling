package net.poundex.fling.demo.todo.todo0

import net.poundex.fling.demo.todo.CategoryModel
import net.poundex.fling.demo.todo.TodoItemFormModel
import net.poundex.fling.demo.todo.TodoModel
import net.poundex.fling.demo.todo.TodoService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Component

/**
 * Created by poundex on 25/05/17.
 */
@Component @Scope("component")
class CreateTodoItemModel extends TodoItemFormModel
{
	TodoModel todoItem = new TodoModel()

	private final TodoService todoService

	@Autowired
	CreateTodoItemModel(TodoService todoService)
	{
		this.todoService = todoService
	}

	Collection<CategoryModel> getCategories()
	{
		return todoService.categories
	}
}
