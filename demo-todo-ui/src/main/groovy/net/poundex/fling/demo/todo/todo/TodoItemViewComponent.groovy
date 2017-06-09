package net.poundex.fling.demo.todo.todo

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Component

/**
 * Created by poundex on 22/05/17.
 */
@Component @Scope("component")
class TodoItemViewComponent extends fling.ui.Component<TodoItemViewController, TodoItemViewView, TodoItemViewModel>
{
	@Autowired
	TodoItemViewComponent(TodoItemViewController controller, TodoItemViewView view, TodoItemViewModel model)
	{
		super(controller, view, model)
	}
}
