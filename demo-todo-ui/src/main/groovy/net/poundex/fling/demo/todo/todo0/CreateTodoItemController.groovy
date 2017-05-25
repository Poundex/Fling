package net.poundex.fling.demo.todo.todo0

import fling.ui.Controller
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Component

/**
 * Created by poundex on 25/05/17.
 */
@Component @Scope("group")
class CreateTodoItemController extends Controller<CreateTodoItemModel>
{
	@Autowired
	CreateTodoItemController(CreateTodoItemModel model)
	{
		super(model)
	}
}
