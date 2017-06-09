package net.poundex.fling.fx.ui.activityview

import fling.activity.Activity
import fling.activity.ActivityResult
import fling.activity.Information
import fling.ui.Model
import javafx.beans.property.ObjectProperty
import javafx.beans.property.SimpleObjectProperty
import javafx.collections.FXCollections
import javafx.scene.Node
import javafx.scene.layout.VBox
import net.poundex.fling.activity.ActivityService
import net.poundex.fling.activity.PreparedAction
import net.poundex.fling.fx.ui.form.FormModel
import net.poundex.fling.fx.ui.information.InformationComponent
import net.poundex.fling.fx.ui.information.InformationModel
import net.poundex.fling.component.ComponentService
import net.poundex.fling.fx.SceneGraphBuilderHolder
import net.poundex.fling.fx.ui.form.FormComponent
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
	private final ObjectFactory<FormComponent> formGroupFactory
	private final ComponentService groupService


	@Autowired
	ActivityViewModel(ActivityService activityService, SceneGraphBuilderHolder sceneGraphBuilderHolder, ObjectFactory<FormComponent> formGroupFactory, ComponentService groupService)
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
		FormComponent formCard = groupService.create(FormComponent) { FormModel model ->
			model.actions = activityResult.actions.collect {
				new PreparedAction(it, activityResult)
			}
			model.title = activityResult.activity.title
		}
		formCard.model.cardContent = activityResult.view
		VBox content = new VBox(25)
		activityResult.information.each { Information information ->
			InformationComponent group = groupService.create(InformationComponent, { InformationModel model ->
				model.information = information
			})
			Node panel = group.render(sceneGraphBuilderHolder.sceneGraphBuilder)
			group.model.remover = { content.children.remove(panel) }
			content.children << panel
		}
		content.children << formCard.render(sceneGraphBuilderHolder.sceneGraphBuilder)
		viewContent.set(content)
	}
}