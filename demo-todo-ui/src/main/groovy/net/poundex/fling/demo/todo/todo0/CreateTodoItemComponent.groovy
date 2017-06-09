package net.poundex.fling.demo.todo.todo0

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Component

/**
 * Created by poundex on 25/05/17.
 */
@Component @Scope("component")
class CreateTodoItemComponent extends fling.ui.Component<CreateTodoItemController, CreateTodoItemView, CreateTodoItemModel>
{
	@Autowired
	CreateTodoItemComponent(CreateTodoItemController controller, CreateTodoItemView view, CreateTodoItemModel model)
	{
		super(controller, view, model)
	}
}
