package net.poundex.fling.demo.todo.todo1

import feign.FeignException
import fling.activity.Activity
import fling.activity.ActivityNavigator
import fling.activity.ActivityResult
import fling.activity.Information
import net.poundex.fling.demo.FeignConfig
import net.poundex.fling.demo.todo.TodoModel
import net.poundex.fling.demo.todo.TodoServiceClient
import net.poundex.fling.group.GroupService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

/**
 * Created by poundex on 22/05/17.
 */
@Component
class EditTodoItem implements Activity
{
	final String name = "TODO1"
	final String title = "Edit Todo Item"

	private final GroupService groupService
	private final ActivityNavigator activityNavigator
	private final TodoServiceClient todoServiceClient

	@Autowired
	EditTodoItem(GroupService groupService, ActivityNavigator activityNavigator, TodoServiceClient todoServiceClient)
	{
		this.groupService = groupService
		this.activityNavigator = activityNavigator
		this.todoServiceClient = todoServiceClient
	}

	@Override
	ActivityResult start(Map<String, ?> args)
	{
		if ( ! args['id'])
			return startResult
		else
			return getViewItemResult(args['id'].toLong())
	}

	private ActivityResult getStartResult(List<Information> extraInformation = [])
	{
		activityNavigator.redirect('!!PARAMS', extraInformation, [destination: 'TODO1', params: [id: [type: 'number']]])
	}

	private ActivityResult getViewItemResult(long id)
	{
		TodoModel todoModel
		try {
			 todoModel = todoServiceClient.get(id)
		} catch (FeignException fex) {
			if(fex.status() == 404)
				return getStartResult([
						new Information(Information.Type.ERROR, "Item with id ${id} not found")])
		}

		return ActivityResult.
				builder().
				activity(this).
				action('Save', this.&commit, true).
				view(groupService.create(EditTodoItemGroup,
						{ EditTodoItemModel model -> model.todoItem = todoModel })).
				build()
	}

	private ActivityResult commit(ActivityResult previous)
	{
		try {
			TodoModel item = todoServiceClient.save(previous.view.model.todoItem.id, previous.view.model.todoItem)
			activityNavigator.redirect("TODO", [new Information(
					Information.Type.SUCCESS, "Updated Todo Item with id ${item.id}")], [id: item.id])
		} catch (FeignConfig.ValidationException vex) {
			activityNavigator.refresh ActivityResult.builder(previous).with {
				vex.errors.each { err -> information(new Information(Information.Type.ERROR, err.message)) }
				it
			}.build()
		}
	}
}