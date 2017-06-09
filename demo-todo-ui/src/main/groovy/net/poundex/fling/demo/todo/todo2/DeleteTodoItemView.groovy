package net.poundex.fling.demo.todo.todo2

import fling.ui.View
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Component

/**
 * Created by poundex on 28/05/17.
 */
@Component @Scope("component")
class DeleteTodoItemView extends View<DeleteTodoItemModel, DeleteTodoItemController>
{
	@Autowired
	DeleteTodoItemView(DeleteTodoItemModel model, DeleteTodoItemController controller)
	{
		super(model, controller)
	}

	final Closure viewBuilder = {
		vbox(disable: true) {
			model.summary.render(delegate)
		}
	}
}
