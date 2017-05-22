package net.poundex.fling.activity

import fling.activity.Activity
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
 * Created by poundex on 19/05/17.
 */
@Service
class ActivityService
{
	private final Map<String, Activity> activities
	private final ActivityManager activityManager

	@Autowired
	ActivityService(Map<String, Activity> activities, ActivityManager activityManager)
	{
		this.activities = new LinkedHashMap<>(activities.sort())
		this.activityManager = activityManager
	}

	Map<String, Activity> getActivities()
	{
		return activities.asImmutable()
	}

	void start(Activity activity)
	{
		activityManager.startActivity(activity)
	}

	void addActivityStartListener(Closure listener)
	{
		activityManager.addActivityStartListener(listener)
	}
}
