package net.poundex.fling.demo.todo.todo

import fling.activity.Activity
import fling.ui.Group
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

	@Autowired
	TodoItemView(GroupService groupService)
	{
		this.groupService = groupService
	}

	@Override
	Group start(Object... args)
	{
		if (args.size() < 1 || ! args[0] instanceof Long)
			groupService.create(TodoItemViewStarterGroup)
		else
			groupService.create(TodoItemViewGroup) { TodoItemViewModel model ->
				model.todoItemID = args[0]
			}
	}
}
