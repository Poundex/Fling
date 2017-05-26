package net.poundex.fling.demo.todo.todo0

import net.poundex.fling.demo.todo.TodoItemFormModel
import net.poundex.fling.demo.todo.TodoModel
import net.poundex.fling.demo.todo.TodoServiceClient
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Component

/**
 * Created by poundex on 25/05/17.
 */
@Component @Scope("group")
class CreateTodoItemModel extends TodoItemFormModel
{
	TodoModel todoItem = new TodoModel()

	private final TodoServiceClient todoServiceClient

	@Autowired
	CreateTodoItemModel(TodoServiceClient todoServiceClient)
	{
		this.todoServiceClient = todoServiceClient
	}

}
