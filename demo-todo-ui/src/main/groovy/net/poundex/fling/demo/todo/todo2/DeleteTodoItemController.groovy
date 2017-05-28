package net.poundex.fling.demo.todo.todo2

import fling.ui.Controller
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Component

/**
 * Created by poundex on 28/05/17.
 */
@Component @Scope("group")
class DeleteTodoItemController extends Controller<DeleteTodoItemModel>
{
	@Autowired
	DeleteTodoItemController(DeleteTodoItemModel model)
	{
		super(model)
	}
}
