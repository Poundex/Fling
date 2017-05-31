package net.poundex.fling.demo.todo.todo2

import fling.activity.Activity
import fling.activity.ActivityNavigator
import fling.activity.ActivityResult
import fling.activity.Information
import net.poundex.fling.demo.todo.TodoServiceClient
import net.poundex.fling.fx.ActionType
import net.poundex.fling.group.GroupService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

/**
 * Created by poundex on 28/05/17.
 */
@Component
class DeleteTodoItem implements Activity
{
	final String name = "TODO2"
	final String title = "Delete Todo Item"

	private final ActivityNavigator activityNavigator
	private final GroupService groupService
	private final TodoServiceClient todoServiceClient

	@Autowired
	DeleteTodoItem(ActivityNavigator activityNavigator, GroupService groupService, TodoServiceClient todoServiceClient)
	{
		this.activityNavigator = activityNavigator
		this.groupService = groupService
		this.todoServiceClient = todoServiceClient
	}

	@Override
	ActivityResult start(Map<String, ?> args)
	{
		if(args['id'] && args['confirm'])
			return doDelete(args['id'].toLong())
		else if(args['id'])
			return confirmDelete(args['id'].toLong())
		else
			return startDelete()

	}

	private ActivityResult doDelete(long id)
	{
		todoServiceClient.delete(id)
		return activityNavigator.redirect('TODOEM', [ new Information(
				Information.Type.SUCCESS, "Item with id ${id} deleted") ], [:])
	}

	private ActivityResult confirmDelete(long id)
	{
		ActivityResult summary = activityNavigator.run('TODO', [id: id])
		return ActivityResult.
				builder().
				activity(this).
				view(groupService.create(DeleteTodoItemGroup, { DeleteTodoItemModel model ->
					model.summary = summary.view
				})).
				action("Cancel", { activityNavigator.redirect('TODO', [
				        new Information(Information.Type.INFO, "Delete cancelled")
				], [id: id])}).
				action("Delete", { activityNavigator.redirect('TODO2', [],  [id: id, confirm: true]) }, ActionType.DANGER).
				build()
	}

	private ActivityResult startDelete()
	{
		activityNavigator.redirect('!!PARAMS', [], [destination: 'TODO2', params: [id: [type: 'number']]])
	}
}
