package net.poundex.fling.demo.todo.todo

import fling.ui.Controller
import net.poundex.fling.demo.todo.TodoModel
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Component

/**
 * Created by poundex on 22/05/17.
 */
@Component @Scope("group")
class TodoItemViewController extends Controller<TodoItemViewModel>
{
	@Autowired
	TodoItemViewController(TodoItemViewModel model)
	{
		super(model)
	}
}
