package net.poundex.fling.demo.todo.todo

import fling.activity.Action
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
//	private final ActivityNavigator activityNavigator

	@Autowired
	TodoItemView(GroupService groupService)//, ActivityNavigator activityNavigator)
	{
		this.groupService = groupService
//		this.activityNavigator = activityNavigator
	}

	@Override
	ActivityResult start(Object... args)
	{
		if (args.size() < 1 || ! args[0] instanceof Long)
			return startResult
		else
			return getViewItemResult(args[0])
	}

	private ActivityResult getStartResult()
	{
		return new ActivityResult(this,
				groupService.create(TodoItemViewStarterGroup))
	}

	private ActivityResult getViewItemResult(long id)
	{
		return new ActivityResult(this,
				groupService.create(TodoItemViewGroup) { TodoItemViewModel model ->
					model.todoItemID = id
				},
				[
				        new Action("Edit", {
					       println "EDIT ${id}"
				        }, false),
				]
		)
	}
}
