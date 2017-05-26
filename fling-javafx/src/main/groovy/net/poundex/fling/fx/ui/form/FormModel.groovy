package net.poundex.fling.fx.ui.form

import fling.ui.Group
import fling.ui.Model
import groovyx.javafx.beans.FXBindable
import net.poundex.fling.activity.PreparedAction
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
	List<PreparedAction> actions
}
