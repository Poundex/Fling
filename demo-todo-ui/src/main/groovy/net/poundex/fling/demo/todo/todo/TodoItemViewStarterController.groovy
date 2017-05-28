package net.poundex.fling.demo.todo.todo

import fling.activity.ActivityNavigator
import fling.ui.Controller
import javafx.event.ActionEvent
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Component

/**
 * Created by poundex on 22/05/17.
 */
@Component @Scope("group")
class TodoItemViewStarterController extends Controller<TodoItemViewStarterModel>
{
	private final ActivityNavigator activityNavigator

	@Autowired
	TodoItemViewStarterController(TodoItemViewStarterModel model, ActivityNavigator activityNavigator)
	{
		super(model)
		this.activityNavigator = activityNavigator
	}

	void onButtonClicked(ActionEvent actionEvent)
	{
		if( ! model.id || ! model.id.isLong())
			return

		activityNavigator.start('TODO', [id: model.id.toLong()])
	}
}
