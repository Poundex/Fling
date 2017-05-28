package net.poundex.fling.demo.todo.todo1

import fling.ui.Group
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Component

/**
 * Created by poundex on 22/05/17.
 */
@Component @Scope("group")
class EditTodoItemGroup extends Group<EditTodoItemController, EditTodoItemView, EditTodoItemModel>
{
	@Autowired
	EditTodoItemGroup(EditTodoItemController controller, EditTodoItemView view, EditTodoItemModel model)
	{
		super(controller, view, model)
	}
}
