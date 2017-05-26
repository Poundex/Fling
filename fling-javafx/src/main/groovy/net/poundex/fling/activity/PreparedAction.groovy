package net.poundex.fling.activity

import fling.activity.Action
import fling.activity.ActivityResult
import javafx.event.ActionEvent
import javafx.event.EventHandler

/**
 * Created by poundex on 26/05/17.
 */
class PreparedAction implements EventHandler<ActionEvent>
{
	@Delegate
	private final Action action
	private final ActivityResult activityResult

	PreparedAction(Action action, ActivityResult activityResult)
	{
		this.action = action
		this.activityResult = activityResult
	}

	@Override
	void handle(ActionEvent event) {
		action.action(activityResult)
	}
}
