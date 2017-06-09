package net.poundex.fling.demo.todo.todo1

import feign.FeignException
import fling.activity.Activity
import fling.activity.ActivityNavigator
import fling.activity.ActivityResult
import fling.activity.Information
import fling.util.springerrors.SpringValidationErrorsHandler
import net.poundex.fling.demo.todo.TodoModel
import net.poundex.fling.demo.todo.TodoService
import net.poundex.fling.fx.ActionType
import net.poundex.fling.component.ComponentService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

/**
 * Created by poundex on 22/05/17.
 */
@Component
class EditTodoItem implements Activity, SpringValidationErrorsHandler
{
	final String name = "TODO1"
	final String title = "Edit Todo Item"

	private final ComponentService groupService
	private final ActivityNavigator activityNavigator
	private final TodoService todoService

	@Autowired
	EditTodoItem(ComponentService groupService, ActivityNavigator activityNavigator, TodoService todoService)
	{
		this.groupService = groupService
		this.activityNavigator = activityNavigator
		this.todoService = todoService
	}

	@Override
	ActivityResult start(Map<String, ?> args)
	{
		if ( ! args['id'])
			return startResult
		else
			return getViewItemResult(args['id'].toLong())
	}

	private ActivityResult getStartResult(List<Information> extraInformation = [])
	{
		activityNavigator.redirect('!!PARAMS', extraInformation, [destination: 'TODO1', params: [id: [type: 'number']]])
	}

	private ActivityResult getViewItemResult(long id)
	{
		TodoModel todoModel
		try {
			 todoModel = todoService.get(id)
		} catch (FeignException fex) {
			if(fex.status() == 404)
				return getStartResult([
						new Information(Information.Type.ERROR, "Item with id ${id} not found")])
		}

		return ActivityResult.
				builder().
				activity(this).
				action('Save', this.&commit, ActionType.PRIMARY).
				view(groupService.create(EditTodoItemComponent,
						{ EditTodoItemModel model -> model.todoItem = todoModel })).
				build()
	}

	private ActivityResult commit(ActivityResult previous)
	{
		handlingSpringErrors(ActivityResult.builder(previous)) {
			TodoModel item = todoService.save(previous.view.model.todoItem.id, previous.view.model.todoItem)
			activityNavigator.redirect("TODO", [new Information(
					Information.Type.SUCCESS, "Updated Todo Item with id ${item.id}")], [id: item.id])
		}
	}
}
