package fling.activity

import com.sun.org.apache.bcel.internal.generic.ARETURN
import fling.ui.Group
import groovy.transform.stc.ClosureParams
import groovy.transform.stc.SimpleType

/**
 * Created by poundex on 24/05/17.
 */
class ActivityResult
{
	final Group view
	final Activity activity
	final List<Action> actions
	final List<Information> information

	private ActivityResult(Group view, Activity activity, List<Action> actions, List<Information> information)
	{
		this.view = view
		this.activity = activity
		this.actions = actions
		this.information = information
	}

	private static class ActivityResultBuilder
	{
		private Group view
		private Activity activity
		private List<Action> actions = []
		private List<Information> information = []

		ActivityResultBuilder view(Group view)
		{
			this.view = view
			return this
		}

		ActivityResultBuilder activity(Activity activity)
		{
			this.activity = activity
			return this
		}

		ActivityResultBuilder action(String name, @ClosureParams(value = SimpleType, options = 'fling.activity.ActivityResult') Closure<ActivityResult> action, boolean primary = false)
		{
			actions << new Action(name, action, primary)
			return this
		}

		ActivityResultBuilder information(Information information)
		{
			this.information << information
			return this
		}

		ActivityResult build()
		{
			return new ActivityResult(view, activity, actions, information)
		}
	}

	static ActivityResultBuilder builder()
	{
		return new ActivityResultBuilder()
	}

	static ActivityResultBuilder builder(ActivityResult activityResult)
	{
		return new ActivityResultBuilder().with {
			activity(activityResult.activity)
			activityResult.information.each {
				information(it)
			}
			view(activityResult.view)
			activityResult.actions.each {
				action(it.name, it.action, it.primary)
			}
			it
		}
	}
}
