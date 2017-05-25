package net.poundex.fling.demo.todo.todoem

import fling.activity.Action
import fling.activity.Activity
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

	@Autowired
	TodoList(GroupService groupService)
	{
		this.groupService = groupService
	}

	@Override
	ActivityResult start(Object... args)
	{
		return new ActivityResult(this, groupService.create(TodoListGroup), [
		        new Action("Create", {
			        println "CREATE"
		        }, true)
		])
	}
}
