package net.poundex.fling.activity

import fling.activity.Activity
import fling.activity.ActivityNavigator
import fling.activity.ActivityResult
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
 * Created by poundex on 19/05/17.
 */
@Service
class ActivityService implements ActivityNavigator
{
	private final Map<String, Activity> activities
	private final ActivityManager activityManager

	@Autowired
	ActivityService(Map<String, Activity> activities, ActivityManager activityManager)
	{
		this.activities = new LinkedHashMap<>(activities.collectEntries { k, v -> [v.name, v] }.sort())
		this.activityManager = activityManager
	}

	Map<String, Activity> getActivities()
	{
		return activities.asImmutable()
	}

	void start(String activityName, Object... args)
	{
		if (activities[activityName])
			start(activities[activityName], args)
	}

	void start(Activity activity, Object... args)
	{
		activityManager.startActivity(activity, args)
		ActivityResult activityResult = new ActivityResult()
		activityResult.view = activity.start(args)
		activityManager.activityResult(activityResult)
	}

	void addActivityStartListener(Closure listener)
	{
		activityManager.addActivityStartListener(listener)
	}

	void addActivityResultListener(Closure listener) {
		activityManager.addActivityResultListener(listener)
	}

}
