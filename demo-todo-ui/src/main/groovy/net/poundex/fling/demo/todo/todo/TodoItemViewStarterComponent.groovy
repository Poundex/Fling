package net.poundex.fling.demo.todo.todo

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Component

/**
 * Created by poundex on 22/05/17.
 */
@Component @Scope("component")
class TodoItemViewStarterComponent extends fling.ui.Component<TodoItemViewStarterController, TodoItemViewStarterView, TodoItemViewStarterModel>
{
	@Autowired
	TodoItemViewStarterComponent(TodoItemViewStarterController controller, TodoItemViewStarterView view, TodoItemViewStarterModel model)
	{
		super(controller, view, model)
	}
}
