package net.poundex.fling.demo.todo.todoem

import fling.activity.Activity
import fling.ui.Group
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

	private final TodoListGroup todoListGroup

	@Autowired
	TodoList(GroupService groupService)
	{
		this.todoListGroup = groupService.create(TodoListGroup)
	}

	@Override
	Group getView()
	{
		return todoListGroup
	}
}
