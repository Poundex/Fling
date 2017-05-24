package net.poundex.fling.demo.todo.todo

import fling.ui.Group
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Component

/**
 * Created by poundex on 22/05/17.
 */
@Component @Scope("group")
class TodoItemViewGroup extends Group<TodoItemViewController, TodoItemViewView, TodoItemViewModel>
{
	@Autowired
	TodoItemViewGroup(TodoItemViewController controller, TodoItemViewView view, TodoItemViewModel model)
	{
		super(controller, view, model)
	}
}
