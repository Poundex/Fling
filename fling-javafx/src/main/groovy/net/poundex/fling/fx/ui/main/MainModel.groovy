package net.poundex.fling.fx.ui.main

import fling.activity.Activity
import fling.ui.Model
import groovyx.javafx.beans.FXBindable
import net.poundex.fling.activity.ActivityService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

import javax.annotation.PostConstruct

/**
 * Created by poundex on 19/05/17.
 */
@Component
class MainModel extends Model
{
	@FXBindable String currentActivityName = "--"

	private final ActivityService activityService

	@Autowired
	MainModel(ActivityService activityService)
	{
		this.activityService = activityService
	}

	@PostConstruct
	void init()
	{
		activityService.addActivityStartListener { Activity activity ->
			currentActivityName = activity.name
		}
	}
}
