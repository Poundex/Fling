package net.poundex.fling.demo.todo.todo1

import net.poundex.fling.demo.todo.CategoryModel
import net.poundex.fling.demo.todo.TodoItemFormModel
import net.poundex.fling.demo.todo.TodoModel
import net.poundex.fling.demo.todo.TodoService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Component

/**
 * Created by poundex on 22/05/17.
 */
@Component @Scope("component")
class EditTodoItemModel extends TodoItemFormModel
{
	TodoModel todoItem

	private final TodoService todoService

	@Autowired
	EditTodoItemModel(TodoService todoService)
	{
		this.todoService = todoService
	}

	Collection<CategoryModel> getCategories()
	{
		return todoService.categories
	}
}
