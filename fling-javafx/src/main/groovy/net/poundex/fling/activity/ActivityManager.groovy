package net.poundex.fling.activity

import fling.activity.Activity
import groovy.transform.PackageScope
import org.springframework.stereotype.Service

/**
 * Created by poundex on 19/05/17.
 */
@PackageScope
@Service
class ActivityManager
{
	Optional<Activity> currentActivity = Optional.empty()

	private List<Closure> activityStartListeners = []

	void startActivity(Activity activity)
	{
		activityStartListeners*.call(activity)
		currentActivity = Optional.of(activity)
	}

	void addActivityStartListener(Closure onActivityStarted)
	{
		activityStartListeners << onActivityStarted
	}
}
