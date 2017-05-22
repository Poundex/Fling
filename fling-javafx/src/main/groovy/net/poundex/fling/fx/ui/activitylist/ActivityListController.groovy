package net.poundex.fling.fx.ui.activitylist

import fling.ui.Controller
import javafx.scene.input.MouseEvent
import net.poundex.fling.activity.ActivityService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

/**
 * Created by poundex on 19/05/17.
 */
@Component
class ActivityListController extends Controller<ActivityListModel>
{
	private final ActivityService activityService

	@Autowired
	ActivityListController(ActivityListModel model, ActivityService activityService)
	{
		super(model)
		this.activityService = activityService
	}

	void onActivityClicked(MouseEvent me)
	{
		if (me.clickCount != 2)
			return

		activityService.start(model.selectedActivity)
	}
}
