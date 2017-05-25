package net.poundex.fling.demo.todo.todo0

import fling.activity.Activity
import fling.activity.ActivityResult
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

	@Autowired
	CreateTodoItem(GroupService groupService)
	{
		this.groupService = groupService
	}

	@Override
	ActivityResult start(Object... args)
	{
		return new ActivityResult(this, groupService.create(CreateTodoItemGroup))
	}
}
