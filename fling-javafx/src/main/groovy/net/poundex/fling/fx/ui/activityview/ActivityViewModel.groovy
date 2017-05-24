package net.poundex.fling.fx.ui.activityview

import fling.activity.Activity
import fling.activity.ActivityResult
import fling.ui.Model
import javafx.beans.property.ObjectProperty
import javafx.beans.property.SimpleObjectProperty
import javafx.collections.FXCollections
import javafx.scene.Node
import javafx.scene.layout.VBox
import net.poundex.fling.activity.ActivityService
import net.poundex.fling.group.GroupService
import net.poundex.fling.fx.SceneGraphBuilderHolder
import net.poundex.fling.fx.ui.form.FormGroup
import org.springframework.beans.factory.ObjectFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

import javax.annotation.PostConstruct

/**
 * Created by poundex on 19/05/17.
 */
@Component
class ActivityViewModel extends Model
{
	final javafx.collections.ObservableList<Activity> activities = FXCollections.observableArrayList()
	final ObjectProperty<Node> viewContent = new SimpleObjectProperty()

	private final ActivityService activityService
	private final SceneGraphBuilderHolder sceneGraphBuilderHolder
	private final ObjectFactory<FormGroup> formGroupFactory
	private final GroupService groupService


	@Autowired
	ActivityViewModel(ActivityService activityService, SceneGraphBuilderHolder sceneGraphBuilderHolder, ObjectFactory<FormGroup> formGroupFactory, GroupService groupService)
	{
		this.activityService = activityService
		this.sceneGraphBuilderHolder = sceneGraphBuilderHolder
		this.formGroupFactory = formGroupFactory
		this.groupService = groupService
	}

	@PostConstruct
	void init()
	{
		activityService.addActivityResultListener this.&onActivityResult
	}

	void update()
	{
		activities.addAll activityService.activities.values()
	}

	void onActivityResult(ActivityResult activityResult)
	{
		FormGroup formCard = groupService.create(FormGroup)
		formCard.model.cardContent = activityResult.view
		VBox content = new VBox(25)
		content.children << formCard.render(sceneGraphBuilderHolder.sceneGraphBuilder)
		viewContent.set(content)
	}

}
