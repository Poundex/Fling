package net.poundex.fling.demo.todo.todoem

import fling.ui.Group
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Component

/**
 * Created by poundex on 22/05/17.
 */
@Component @Scope("group")
class TodoListGroup extends Group<TodoListController, TodoListView, TodoListModel>
{
	@Autowired
	TodoListGroup(TodoListController controller, TodoListView view, TodoListModel model)
	{
		super(controller, view, model)
	}
}
