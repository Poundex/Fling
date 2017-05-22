package net.poundex.fling.fx.ui.activityview

import fling.activity.Activity
import fling.ui.View
import groovyx.javafx.SceneGraphBuilder
import javafx.beans.value.ChangeListener
import javafx.collections.ListChangeListener
import javafx.scene.control.TreeCell
import javafx.scene.control.TreeItem
import javafx.scene.control.TreeView
import net.poundex.fling.fx.ui.activitylist.ActivityListController
import net.poundex.fling.fx.ui.activitylist.ActivityListModel
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

import javax.annotation.PostConstruct

/**
 * Created by poundex on 19/05/17.
 */
@Component
class ActivityViewView extends View<ActivityViewModel, ActivityViewController>
{
	private TreeView<Activity> mainListView
	private TreeItem root = new TreeItem()

	@Autowired
	ActivityViewView(ActivityViewModel model, ActivityViewController controller)
	{
		super(model, controller)
	}

	final Closure viewBuilder = {
		def pane = scrollPane(padding: [25, 25, 25, 25], fitToWidth: true, fitToHeight: true)

		model.viewContent.addListener({ a, b, c ->
			pane.content = c
		} as ChangeListener)

		model.update()
	}

}
