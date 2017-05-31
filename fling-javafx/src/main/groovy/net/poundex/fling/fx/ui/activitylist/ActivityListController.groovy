package net.poundex.fling.fx.ui.activitylist

import fling.activity.ActivityNavigator
import fling.ui.Controller
import javafx.event.ActionEvent
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
	private final ActivityNavigator activityService

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

	void onNameFieldAction(ActionEvent e)
	{
		activityService.start(model.nameField.toUpperCase(), [:])
		model.nameField = ""
	}
}
