package net.poundex.fling.demo.todo.todo1

import fling.ui.Controller
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Component

/**
 * Created by poundex on 22/05/17.
 */
@Component @Scope("component")
class EditTodoItemController extends Controller<EditTodoItemModel>
{
	@Autowired
	EditTodoItemController(EditTodoItemModel model)
	{
		super(model)
	}
}
