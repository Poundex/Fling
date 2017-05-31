package net.poundex.fling.fx.ui.activitylist

import fling.activity.Activity
import fling.ui.View
import javafx.beans.value.ChangeListener
import javafx.collections.ListChangeListener
import javafx.scene.control.TreeCell
import javafx.scene.control.TreeItem
import javafx.scene.control.TreeView
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

	}

	final Closure viewBuilder = {
		model.update()
		vbox(styleClass: ['sidebar'], padding: 15, spacing: 10) {
			textField(text: bind(model.nameFieldProperty()), onAction: controller.&onNameFieldAction)
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
