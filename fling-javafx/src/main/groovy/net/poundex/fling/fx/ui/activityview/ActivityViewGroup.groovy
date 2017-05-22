package net.poundex.fling.fx.ui.activityview

import fling.ui.Group
import groovy.ui.text.AutoIndentAction
import org.springframework.beans.factory.ObjectFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

/**
 * Created by poundex on 19/05/17.
 */
@Component
class ActivityViewGroup extends Group<ActivityViewController, ActivityViewView, ActivityViewModel>
{
	@Autowired
	ActivityViewGroup(ActivityViewController controller, ActivityViewView view, ActivityViewModel model)
	{
		super(controller, view, model)
	}
}
