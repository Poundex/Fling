package fling.activity

import fling.ui.Component
import groovy.transform.stc.ClosureParams
import groovy.transform.stc.SimpleType
import net.poundex.fling.fx.ActionType

/**
 * Created by poundex on 24/05/17.
 */
class ActivityResult<T extends Component>
{
	final T view
	final Activity activity
	final List<Action> actions
	final List<Information> information

	private ActivityResult(T view, Activity activity, List<Action> actions, List<Information> information)
	{
		this.view = view
		this.activity = activity
		this.actions = actions
		this.information = information
	}

	static class ActivityResultBuilder<T extends Component>
	{
		private T view
		private Activity activity
		private List<Action> actions = []
		private List<Information> information = []

		ActivityResultBuilder view(T view)
		{
			this.view = view
			return this
		}

		ActivityResultBuilder activity(Activity activity)
		{
			this.activity = activity
			return this
		}

		ActivityResultBuilder action(String name,
		                             @ClosureParams(value = SimpleType, options = 'fling.activity.ActivityResult')
				                             Closure<ActivityResult> action,
		                             ActionType actionType = ActionType.NORMAL)
		{
			actions << new Action(name, action, actionType)
			return this
		}

		ActivityResultBuilder information(Information information)
		{
			this.information << information
			return this
		}

		ActivityResult<T> build()
		{
			return new ActivityResult(view, activity, actions, information)
		}
	}

	static ActivityResultBuilder<T> builder()
	{
		return new ActivityResultBuilder<T>()
	}

	static ActivityResultBuilder builder(ActivityResult activityResult)
	{
		return new ActivityResultBuilder().with {
			activity(activityResult.activity)
//			activityResult.information.each {
//				information(it)
//			}
			view(activityResult.view)
			activityResult.actions.each {
				action(it.name, it.action, it.actionType)
			}
			it
		}
	}
}
