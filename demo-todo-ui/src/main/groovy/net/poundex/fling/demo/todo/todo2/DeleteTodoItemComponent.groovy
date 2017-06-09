package net.poundex.fling.demo.todo.todo2

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Component

/**
 * Created by poundex on 28/05/17.
 */
@Component @Scope("component")
class DeleteTodoItemComponent extends fling.ui.Component<DeleteTodoItemController, DeleteTodoItemView, DeleteTodoItemModel>
{
	@Autowired
	DeleteTodoItemComponent(DeleteTodoItemController controller, DeleteTodoItemView view, DeleteTodoItemModel model)
	{
		super(controller, view, model)
	}
}
