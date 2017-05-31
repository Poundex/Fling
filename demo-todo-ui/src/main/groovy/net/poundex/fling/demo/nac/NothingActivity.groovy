package net.poundex.fling.demo.nac

import fling.activity.Activity
import fling.activity.ActivityResult
import fling.activity.Information
import net.poundex.fling.fx.ActionType
import net.poundex.fling.group.GroupService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

/**
 * Created by poundex on 19/05/17.
 */
@Component
class NothingActivity implements Activity
{
	final String name = 'NOOP'
	final String title = 'Do Nothing'

	private final GroupService groupService

	@Autowired
	NothingActivity(GroupService groupService)
	{
		this.groupService = groupService
	}

	@Override
	ActivityResult start(Map<String, ?> args)
	{
		return ActivityResult.
				builder().
				activity(this).
				view(groupService.create(NothingGroup)).
				information(new Information(
						Information.Type.INFO, "Information")).
				information(new Information(
						Information.Type.SUCCESS, "Success")).
				information(new Information(
						Information.Type.WARNING, "Warning")).
				information(new Information(
						Information.Type.ERROR, "Error")).
				action("Normal", { null }).
				action("Danger", {null}, ActionType.DANGER).
				action("Primary", {null}, ActionType.PRIMARY).
				action("Aux", {null}, ActionType.AUX).
				build()

	}
}
