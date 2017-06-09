package net.poundex.fling.demo.todo.todoem

import fling.activity.Activity
import fling.activity.ActivityNavigator
import fling.activity.ActivityResult
import net.poundex.fling.demo.todo.TodoServiceClient
import net.poundex.fling.fx.ActionType
import net.poundex.fling.component.ComponentService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

/**
 * Created by poundex on 22/05/17.
 */
@Component
class TodoList implements Activity
{
	final String name = "TODOEM"
	final String title = "Todo List"

	private final ComponentService groupService
	private final ActivityNavigator activityNavigator
	private final TodoServiceClient todoServiceClient

	@Autowired
	TodoList(ComponentService groupService, ActivityNavigator activityNavigator, TodoServiceClient todoServiceClient)
	{
		this.groupService = groupService
		this.activityNavigator = activityNavigator
		this.todoServiceClient = todoServiceClient
	}

	@Override
	ActivityResult start(Map<String, ?> args)
	{
		return ActivityResult.
				builder().
				activity(this).
				view(groupService.create(TodoListComponent, { TodoListModel model ->
					model.todoItems.addAll(todoServiceClient.index())
				})).
				action('Create', this.&create, ActionType.PRIMARY).
				build()
	}

	private ActivityResult create(ActivityResult activityResult)
	{
		return activityNavigator.redirect("TODO0", [], [:])
	}
}
