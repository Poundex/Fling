package net.poundex.fling.fx.ui.form

import fling.activity.Action
import fling.ui.Group
import fling.ui.Model
import groovyx.javafx.beans.FXBindable
import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Component

/**
 * Created by poundex on 20/05/17.
 */
@Component @Scope("group")
class FormModel extends Model
{
	@FXBindable String title
	Group cardContent
	List<Action> actions
}
