package net.poundex.fling.demo.todo.todo2

import fling.ui.Group
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Component

/**
 * Created by poundex on 28/05/17.
 */
@Component @Scope("group")
class DeleteTodoItemGroup extends Group<DeleteTodoItemController, DeleteTodoItemView, DeleteTodoItemModel>
{
	@Autowired
	DeleteTodoItemGroup(DeleteTodoItemController controller, DeleteTodoItemView view, DeleteTodoItemModel model)
	{
		super(controller, view, model)
	}
}
