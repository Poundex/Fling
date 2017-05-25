package fling.activity

import fling.ui.Group

/**
 * Created by poundex on 24/05/17.
 */
class ActivityResult
{
	final Group view
	final Activity activity
	final List<Action> actions

	ActivityResult(Activity activity, Group view, List<Action> actions = [])
	{
		this.view = view
		this.activity = activity
		this.actions = actions
	}
}
