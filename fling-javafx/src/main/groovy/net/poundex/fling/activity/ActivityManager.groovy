package net.poundex.fling.activity

import fling.activity.Activity
import fling.activity.ActivityResult
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
	private List<Closure> activityResultListeners = []

	void startActivity(Activity activity, Map args)
	{
		activityStartListeners.each {
			if (it.maximumNumberOfParameters > 1)
				it(activity, args)
			else
				it(activity)
		}
		currentActivity = Optional.of(activity)
	}

	void activityResult(ActivityResult activityResult)
	{
		activityResultListeners*.call(activityResult)
	}

	void addActivityStartListener(Closure onActivityStarted)
	{
		activityStartListeners << onActivityStarted
	}

	void addActivityResultListener(Closure closure)
	{
		activityResultListeners << closure
	}

}
