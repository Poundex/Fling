package fling.activity

/**
 * Created by poundex on 24/05/17.
 */
interface ActivityNavigator
{
	void start(String activityName, Object... args)
	void start(Activity activity, Object... args)

	ActivityResult redirect(String activityName, List<Information> information, Object... args)

	void refresh(ActivityResult activityResult)
}