package net.poundex.fling.activity

import fling.activity.Activity
import fling.activity.ActivityNavigator
import fling.activity.ActivityResult
import fling.activity.Information
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
 * Created by poundex on 19/05/17.
 */
@Service
class ActivityService implements ActivityNavigator
{
	private final Map<String, Activity> activities = new TreeMap<>({ l, r -> l <=> r })
	private final ActivityManager activityManager

	@Autowired
	ActivityService(ActivityManager activityManager)
	{
		this.activityManager = activityManager
	}

	Map<String, Activity> getActivities()
	{
		return activities.asImmutable()
	}

	@Override
	void start(String activityName, Map<String, ?> args)
	{
		if (activities[activityName])
			start(activities[activityName], args)
	}

	@Override
	void start(Activity activity, Map<String, ?> args = [:])
	{
		activityManager.startActivity(activity, args)
		ActivityResult activityResult = activity.start(args)
		activityManager.activityResult(activityResult)
	}

	@Override
	ActivityResult redirect(String activityName, List<Information> information, Map<String, ?> args)
	{
		activityManager.startActivity(activities[activityName], args)
		ActivityResult activityResult = activities[activityName].start(args)
		activityResult.information.addAll(information)
		activityManager.activityResult(activityResult)
		return activityResult
	}

	@Override
	void refresh(ActivityResult activityResult)
	{
		activityManager.activityResult(activityResult)
	}

	@Override
	ActivityResult run(String activityName, Map<String, ?> args)
	{
		activities[activityName].start(args)
	}

	void addActivityStartListener(Closure listener)
	{
		activityManager.addActivityStartListener(listener)
	}

	void addActivityResultListener(Closure listener) {
		activityManager.addActivityResultListener(listener)
	}

	void register(Activity activity)
	{
		activities[activity.name] = activity
	}

}
