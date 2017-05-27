package net.poundex.fling.demo.todo.todoem

import fling.activity.Activity
import fling.activity.ActivityNavigator
import fling.activity.ActivityResult
import net.poundex.fling.group.GroupService
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

	private final GroupService groupService
	private final ActivityNavigator activityNavigator

	@Autowired
	TodoList(GroupService groupService, ActivityNavigator activityNavigator)
	{
		this.groupService = groupService
		this.activityNavigator = activityNavigator
	}

	@Override
	ActivityResult start(Object... args)
	{
		return ActivityResult.
				builder().
				activity(this).
				view(groupService.create(TodoListGroup)).
				action('Create', this.&create, true).
				build()
	}

	private ActivityResult create(ActivityResult activityResult)
	{
		return activityNavigator.redirect("TODO0", [])
	}
}
