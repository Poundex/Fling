package net.poundex.fling.demo.todo.todoem

import fling.ui.Model
import javafx.collections.FXCollections
import javafx.collections.ObservableList
import net.poundex.fling.demo.todo.TodoModel
import net.poundex.fling.demo.todo.TodoServiceClient
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Component

/**
 * Created by poundex on 22/05/17.
 */
@Component @Scope("group")
class TodoListModel extends Model
{
	ObservableList<TodoModel> todoItems = FXCollections.observableList([])

	private final TodoServiceClient todoServiceClient

	@Autowired
	TodoListModel(TodoServiceClient todoServiceClient)
	{
		this.todoServiceClient = todoServiceClient
	}

	@Override
	void beforeViewRender()
	{
		todoItems.addAll(todoServiceClient.index())
	}
}
