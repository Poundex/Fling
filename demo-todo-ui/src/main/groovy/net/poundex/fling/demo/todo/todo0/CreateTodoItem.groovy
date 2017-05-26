package net.poundex.fling.demo.todo.todo0

import feign.FeignException
import fling.activity.Activity
import fling.activity.ActivityNavigator
import fling.activity.ActivityResult
import fling.activity.Information
import net.poundex.fling.demo.todo.TodoModel
import net.poundex.fling.demo.todo.TodoServiceClient
import net.poundex.fling.group.GroupService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

/**
 * Created by poundex on 25/05/17.
 */
@Component
class CreateTodoItem implements Activity
{
	final String name = 'TODO0'
	final String title = 'Create Todo Item'

	private final GroupService groupService
	private final ActivityNavigator activityNavigator
	private final TodoServiceClient todoServiceClient

	@Autowired
	CreateTodoItem(GroupService groupService, TodoServiceClient todoServiceClient, ActivityNavigator activityNavigator) //, ActivityNavigator activityNavigator)
	{
		this.groupService = groupService
		this.todoServiceClient = todoServiceClient
		this.activityNavigator = activityNavigator
	}

	@Override
	ActivityResult start(Object... args)
	{
		return ActivityResult.
				builder().
				activity(this).
				view(groupService.create(CreateTodoItemGroup)).
				action('Save', this.&commit, true).build()
	}

	private ActivityResult commit(ActivityResult previous)
	{
		try
		{
			TodoModel item = todoServiceClient.save(previous.view.model.todoItem)
			activityNavigator.redirect("TODO", [new Information(
					Information.Type.SUCCESS, "Cre-ated Todo Item with id ${item.id}")], item.id)
		} catch (FeignException fex)
		{
			if (fex.status() == 422)
//				return new ActivityResult(this, createTodoItemGroup)
				null
		}
	}
}
