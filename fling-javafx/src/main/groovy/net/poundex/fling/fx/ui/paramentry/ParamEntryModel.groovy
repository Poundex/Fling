package net.poundex.fling.fx.ui.paramentry

import fling.ui.Model
import javafx.beans.Observable
import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Component

/**
 * Created by poundex on 28/05/17.
 */
@Component @Scope("group")
class ParamEntryModel extends Model
{
	Map<String, Map<String, ?>> params = [:]
	Map<String, Observable> paramValues = [:]
	String destination
}
