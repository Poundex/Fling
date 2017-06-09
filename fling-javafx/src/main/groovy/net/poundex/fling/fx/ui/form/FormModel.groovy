package net.poundex.fling.fx.ui.form

import fling.ui.Model
import groovyx.javafx.beans.FXBindable
import net.poundex.fling.activity.PreparedAction
import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Component

/**
 * Created by poundex on 20/05/17.
 */
@Component @Scope("component")
class FormModel extends Model
{
	@FXBindable String title
	fling.ui.Component cardContent
	List<PreparedAction> actions
}
