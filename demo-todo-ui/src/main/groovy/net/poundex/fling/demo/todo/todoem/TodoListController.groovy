package net.poundex.fling.demo.todo.todoem

import fling.activity.ActivityNavigator
import fling.ui.Controller
import net.poundex.fling.demo.todo.TodoModel
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Component

/**
 * Created by poundex on 22/05/17.
 */
@Component @Scope("group")
class TodoListController extends Controller<TodoListModel>
{
	private final ActivityNavigator activityNavigator

	@Autowired
	TodoListController(TodoListModel model, ActivityNavigator activityNavigator)
	{
		super(model)
		this.activityNavigator = activityNavigator
	}

	void todoItemActivated(TodoModel item)
	{
		activityNavigator.start("TODO", [id: item.id])
	}
}
