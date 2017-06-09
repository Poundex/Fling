package net.poundex.fling.demo.todo.todo

import fling.ui.Model
import groovyx.javafx.beans.FXBindable
import net.poundex.fling.demo.todo.CategoryModel
import net.poundex.fling.demo.todo.TodoModel
import net.poundex.fling.demo.todo.TodoService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Component

/**
 * Created by poundex on 22/05/17.
 */
@Component @Scope("component")
class TodoItemViewStarterModel extends Model
{
	@FXBindable String id = ""

	private final TodoService todoService

	@Autowired
	TodoItemViewStarterModel(TodoService todoService)
	{
		this.todoService = todoService
	}

	Collection<CategoryModel> getCategories()
	{
		return todoService.categories
	}
}
