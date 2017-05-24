package net.poundex.fling.demo.todo.todo

import fling.ui.View
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Component

/**
 * Created by poundex on 22/05/17.
 */
@Component @Scope("group")
class TodoItemViewView extends View<TodoItemViewModel, TodoItemViewController>
{
	@Autowired
	TodoItemViewView(TodoItemViewModel model, TodoItemViewController controller)
	{
		super(model, controller)
	}

	Closure viewBuilder = {
		vbox {
			label(text: 'Todo Task', styleClass: ['control-label'])
			label(text: model.todoItem.itemText)
		}
	}
}
