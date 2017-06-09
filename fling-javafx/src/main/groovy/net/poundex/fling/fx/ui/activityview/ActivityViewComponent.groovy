package net.poundex.fling.fx.ui.activityview

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

/**
 * Created by poundex on 19/05/17.
 */
@Component
class ActivityViewComponent extends fling.ui.Component<ActivityViewController, ActivityViewView, ActivityViewModel>
{
	@Autowired
	ActivityViewComponent(ActivityViewController controller, ActivityViewView view, ActivityViewModel model)
	{
		super(controller, view, model)
	}
}
