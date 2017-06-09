package net.poundex.fling.demo.todo.todo1

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Component

/**
 * Created by poundex on 22/05/17.
 */
@Component @Scope("component")
class EditTodoItemComponent extends fling.ui.Component<EditTodoItemController, EditTodoItemView, EditTodoItemModel>
{
	@Autowired
	EditTodoItemComponent(EditTodoItemController controller, EditTodoItemView view, EditTodoItemModel model)
	{
		super(controller, view, model)
	}
}
