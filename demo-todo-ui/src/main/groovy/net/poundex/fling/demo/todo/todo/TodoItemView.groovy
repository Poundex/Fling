package net.poundex.fling.demo.todo.todo

import feign.FeignException
import fling.activity.Activity
import fling.activity.ActivityNavigator
import fling.activity.ActivityResult
import fling.activity.Information
import net.poundex.fling.demo.todo.TodoModel
import net.poundex.fling.demo.todo.TodoService
import net.poundex.fling.component.ComponentService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

/**
 * Created by poundex on 22/05/17.
 */
@Component
class TodoItemView implements Activity
{
	final String name = "TODO"
	final String title = "Todo Item"

	private final ComponentService groupService
	private final ActivityNavigator activityNavigator
	private final TodoService todoService

	@Autowired
	TodoItemView(ComponentService groupService, ActivityNavigator activityNavigator, TodoService todoService)
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
		activityNavigator.redirect('!!PARAMS', extraInformation, [destination: 'TODO', params: [id: [type: 'number']]])
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
				action('Edit', { activityNavigator.start("TODO1", [id: id]) }).
				action('Delete', { activityNavigator.start("TODO2", [id: id]) }).
				view(groupService.create(TodoItemViewComponent,
						{ TodoItemViewModel model -> model.todoItem = todoModel })).
				build()
	}
}
