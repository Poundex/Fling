package net.poundex.fling.demo.todo.todo1

import fling.ui.View
import net.poundex.fling.demo.todo.TodoItemForm
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Component

/**
 * Created by poundex on 22/05/17.
 */
@Component @Scope("component")
class EditTodoItemView extends View<EditTodoItemModel, EditTodoItemController> implements TodoItemForm
{
	@Autowired
	EditTodoItemView(EditTodoItemModel model, EditTodoItemController controller)
	{
		super(model, controller)
	}

	Closure viewBuilder = {
		renderPartial(todoItemForm, delegate, [editable: true])
	}
}
