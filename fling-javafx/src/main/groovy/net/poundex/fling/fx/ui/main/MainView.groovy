package net.poundex.fling.fx.ui.main

import fling.ui.View
import net.poundex.fling.fx.ui.activitylist.ActivityListComponent
import net.poundex.fling.fx.ui.activityview.ActivityViewComponent
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

/**
 * Created by poundex on 19/05/17.
 */
@Component
class MainView extends View<MainModel, MainController>
{
	private final ActivityListComponent activityListGroup
	private final ActivityViewComponent activityViewGroup

	@Autowired
	MainView(MainModel model, MainController controller, ActivityListComponent activityListGroup, ActivityViewComponent activityViewGroup)
	{
		super(model, controller)
		this.activityListGroup = activityListGroup
		this.activityViewGroup = activityViewGroup
	}

	final Closure viewBuilder = {
		scene(width: 1024, height: 768, stylesheets: ['/styles/material.css', '/styles/application.css']) {
			borderPane {
				left {
					activityListGroup.render(delegate)
				}
				borderPane {
					activityViewGroup.render(delegate)

					bottom {
						label(text: bind(model.currentActivityNameProperty()))
					}
				}
			}
		}
	}
}
