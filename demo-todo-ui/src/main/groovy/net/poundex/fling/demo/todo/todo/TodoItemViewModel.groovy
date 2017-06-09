package net.poundex.fling.demo.todo.todo

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
@Component @Scope("group")
class TodoItemViewModel extends TodoItemFormModel
{
	TodoModel todoItem

	private final TodoService todoService

	@Autowired
	TodoItemViewModel(TodoService todoService)
	{
		this.todoService = todoService
	}

	Collection<CategoryModel> getCategories()
	{
		return todoService.categories
	}
}
