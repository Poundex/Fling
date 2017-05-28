package net.poundex.fling.fx.ui.activitylist

import fling.activity.Activity
import fling.ui.Model
import javafx.collections.FXCollections
import net.poundex.fling.activity.ActivityService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

import javax.annotation.PostConstruct

/**
 * Created by poundex on 19/05/17.
 */
@Component
class ActivityListModel extends Model
{
	private final ActivityService activityService

	final javafx.collections.ObservableList<Activity> activities = FXCollections.observableArrayList()
	Activity selectedActivity

	@Autowired
	ActivityListModel(ActivityService activityService)
	{
		this.activityService = activityService
	}

	@PostConstruct
	void init()
	{
	}

	void update()
	{
		activities.addAll activityService.activities.values().findAll { ! it.name.startsWith('!!') }
	}
}
