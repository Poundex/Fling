package net.poundex.fling.demo.nac

import fling.ui.Model
import groovyx.javafx.beans.FXBindable
import net.poundex.fling.ctx.GroupScope
import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Component

/**
 * Created by poundex on 19/05/17.
 */
@Component @Scope("component")
class NothingModel extends Model
{
	@FXBindable String text = "Nothing here"
}
