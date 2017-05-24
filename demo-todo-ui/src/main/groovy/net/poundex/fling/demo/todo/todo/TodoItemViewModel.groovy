package net.poundex.fling.demo.todo.todo

import fling.ui.Model
import net.poundex.fling.demo.todo.TodoModel
import net.poundex.fling.demo.todo.TodoServiceClient
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Component

/**
 * Created by poundex on 22/05/17.
 */
@Component @Scope("group")
class TodoItemViewModel extends Model
{
	TodoModel todoItem

	private final TodoServiceClient todoServiceClient

	@Autowired
	TodoItemViewModel(TodoServiceClient todoServiceClient)
	{
		this.todoServiceClient = todoServiceClient
	}

	void setTodoItemID(long id)
	{
		todoItem = todoServiceClient.get(id)
	}
}
