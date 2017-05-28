package net.poundex.fling.demo.todo.todo

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
class TodoItemView implements Activity
{
	final String name = "TODO"
	final String title = "Todo Item"

	private final GroupService groupService
	private final ActivityNavigator activityNavigator

	@Autowired
	TodoItemView(GroupService groupService, ActivityNavigator activityNavigator)
	{
		this.groupService = groupService
		this.activityNavigator = activityNavigator
	}

	@Override
	ActivityResult start(Map<String, ?> args)
	{
		if ( ! args['id'])
			return startResult
		else
			return getViewItemResult(args['id'].toLong())
	}

	private ActivityResult getStartResult()
	{
		return ActivityResult.
				builder().
				activity(this).
				view(groupService.create(TodoItemViewStarterGroup)).
				build()
	}

	private ActivityResult getViewItemResult(long id)
	{
		return ActivityResult.
				builder().
				activity(this).
				action('Edit', { activityNavigator.start("TODO1", [id: id]) }, false).
				view(groupService.create(TodoItemViewGroup,
						{ TodoItemViewModel model -> model.todoItemID = id })).
				build()
	}
}
