package net.poundex.fling.fx.ui.information

import fling.activity.Information
import fling.ui.Model
import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Component

/**
 * Created by poundex on 26/05/17.
 */
@Component @Scope("component")
class InformationModel extends Model
{
	Information information
	Closure remover
}
