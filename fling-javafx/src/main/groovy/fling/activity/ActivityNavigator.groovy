package fling.activity

/**
 * Created by poundex on 24/05/17.
 */
interface ActivityNavigator
{
	void start(String activityName, Map<String, ?> args)
	void start(Activity activity)
	void start(Activity activity, Map<String, ?> args)

	ActivityResult redirect(String activityName, List<Information> information, Map<String, ?> args)

	void refresh(ActivityResult activityResult)
}