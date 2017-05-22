package net.poundex.fling.fx.ui.activitylist

import fling.ui.Group
import org.springframework.beans.factory.ObjectFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

/**
 * Created by poundex on 19/05/17.
 */
@Component
class ActivityListGroup extends Group<ActivityListController, ActivityListView, ActivityListModel>
{
	@Autowired
	ActivityListGroup(ActivityListController controller, ActivityListView view, ActivityListModel model)
	{
		super(controller, view, model)
	}
}
