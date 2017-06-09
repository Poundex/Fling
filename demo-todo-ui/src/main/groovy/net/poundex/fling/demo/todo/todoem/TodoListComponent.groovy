package net.poundex.fling.demo.todo.todoem

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Component

/**
 * Created by poundex on 22/05/17.
 */
@Component @Scope("component")
class TodoListComponent extends fling.ui.Component<TodoListController, TodoListView, TodoListModel>
{
	@Autowired
	TodoListComponent(TodoListController controller, TodoListView view, TodoListModel model)
	{
		super(controller, view, model)
	}
}
