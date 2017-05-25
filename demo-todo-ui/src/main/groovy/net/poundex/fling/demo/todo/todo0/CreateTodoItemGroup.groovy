package net.poundex.fling.demo.todo.todo0

import fling.ui.Group
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Component

/**
 * Created by poundex on 25/05/17.
 */
@Component @Scope("group")
class CreateTodoItemGroup extends Group<CreateTodoItemController, CreateTodoItemView, CreateTodoItemModel>
{
	@Autowired
	CreateTodoItemGroup(CreateTodoItemController controller, CreateTodoItemView view, CreateTodoItemModel model)
	{
		super(controller, view, model)
	}
}
