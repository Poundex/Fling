package net.poundex.fling.demo.todo.todo0

import fling.ui.View
import net.poundex.fling.demo.todo.CategoryServiceClient
import net.poundex.fling.demo.todo.TodoItemForm
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Component

/**
 * Created by poundex on 25/05/17.
 */
@Component @Scope("group")
class CreateTodoItemView extends View<CreateTodoItemModel, CreateTodoItemController> implements TodoItemForm
{
	private final CategoryServiceClient categoryServiceClient

	@Autowired
	CreateTodoItemView(CreateTodoItemModel model, CreateTodoItemController controller, CategoryServiceClient categoryServiceClient)
	{
		super(model, controller)
		this.categoryServiceClient = categoryServiceClient
	}

	final Closure viewBuilder = { Map args ->
		renderPartial(todoItemForm, delegate, [editable: true])
	}
}
