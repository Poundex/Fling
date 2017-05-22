package net.poundex.fling.fx.ui.activityview

import fling.activity.Activity
import fling.ui.Controller
import net.poundex.fling.activity.ActivityService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

import javax.annotation.PostConstruct

/**
 * Created by poundex on 19/05/17.
 */
@Component
class ActivityViewController extends Controller<ActivityViewModel>
{
	private final ActivityService activityService

	@Autowired
	ActivityViewController(ActivityViewModel model, ActivityService activityService)
	{
		super(model)
		this.activityService = activityService
	}

//	@PostConstruct
//	void init()
//	{
//		activityService.addActivityStartListener this.&onActivityStarted
//	}
//
//	private onActivityStarted(Activity activity)
//	{
//		model.viewContent.set(activity.view.view)
//	}
}
