package net.poundex.fling.fx.ui.activitylist

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

/**
 * Created by poundex on 19/05/17.
 */
@Component
class ActivityListComponent extends fling.ui.Component<ActivityListController, ActivityListView, ActivityListModel>
{
	@Autowired
	ActivityListComponent(ActivityListController controller, ActivityListView view, ActivityListModel model)
	{
		super(controller, view, model)
	}
}
