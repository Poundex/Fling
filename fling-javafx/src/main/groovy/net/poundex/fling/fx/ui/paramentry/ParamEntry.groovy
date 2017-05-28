package net.poundex.fling.fx.ui.paramentry

import fling.activity.Activity
import fling.activity.ActivityNavigator
import fling.activity.ActivityResult
import javafx.beans.property.SimpleStringProperty
import net.poundex.fling.group.GroupService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

/**
 * Created by poundex on 28/05/17.
 */
@Component
class ParamEntry implements Activity
{
	final String name = "!!PARAMS"
	final String title = "Parameters"

	private final GroupService groupService
	private final ActivityNavigator activityNavigator

	@Autowired
	ParamEntry(GroupService groupService, ActivityNavigator activityNavigator)
	{
		this.groupService = groupService
		this.activityNavigator = activityNavigator
	}

	@Override
	ActivityResult start(Map<String, ?> args)
	{
		return ActivityResult.
				builder().
				activity(this).
				view(groupService.create(ParamEntryGroup, { ParamEntryModel model ->
					args.params.each { String paramName, Map<String, ?> paramProps ->
						model.params[paramName] = paramProps
						model.paramValues[paramName] = new SimpleStringProperty("")
					}
					model.destination = args['destination']
				})).
				action("Go", { ActivityResult self ->
					String activityName = self.view.model.destination
					activityNavigator.start(activityName, self.view.model.params.keySet().collectEntries {
						[it, self.view.model.paramValues[it].get()]
					})
				}, true).
				build()
	}


}
