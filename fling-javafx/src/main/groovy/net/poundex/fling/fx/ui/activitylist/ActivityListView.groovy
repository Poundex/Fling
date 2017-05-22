package net.poundex.fling.fx.ui.activitylist

import fling.activity.Activity
import fling.ui.View
import groovyx.javafx.SceneGraphBuilder
import javafx.beans.value.ChangeListener
import javafx.collections.ListChangeListener
import javafx.scene.control.ListView
import javafx.scene.control.TextField
import javafx.scene.control.TitledPane
import javafx.scene.control.TreeCell
import javafx.scene.control.TreeItem
import javafx.scene.control.TreeView
import javafx.scene.layout.BorderPane
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

import javax.annotation.PostConstruct

/**
 * Created by poundex on 19/05/17.
 */
@Component
class ActivityListView extends View<ActivityListModel, ActivityListController>
{
	private TreeView<Activity> mainListView
	private TreeItem root = new TreeItem()

	@Autowired
	ActivityListView(ActivityListModel model, ActivityListController controller)
	{
		super(model, controller)
	}

	@PostConstruct
	void init()
	{
		model.activities.addListener ({ ListChangeListener.Change<Activity> c ->
			while(c.next()) c.addedSubList.each { root.children << new TreeItem(it) }
		} as ListChangeListener<Activity>)
		model.update()
	}

	final Closure viewBuilder = {
		vbox(styleClass: ['sidebar'], padding: 15, spacing: 10) {
			textField()
			mainListView = treeView(
					styleClass: ['activityTree'],
					cellFactory: this.&activityListCell,
					onMouseClicked: controller.&onActivityClicked,
					root: root,
					showRoot: false,
			)
		}

		mainListView.selectionModel.selectedItemProperty().addListener({ prop, oldv, newv ->
			model.selectedActivity = newv.value
		} as ChangeListener<TreeItem<Activity>>)
	}

	private TreeCell<Activity> activityListCell(TreeView lv)
	{
		return new TreeCell<Activity>() {
			@Override
			protected void updateItem(Activity o, boolean b)
			{
				super.updateItem(o, b)
				styleClass << 'activityTree'
				if (o)
					setText("${o.title} (${o.name})")
			}
		}
	}
}
