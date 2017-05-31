package fling.activity

import groovy.transform.Immutable
import net.poundex.fling.fx.ActionType

/**
 * Created by poundex on 25/05/17.
 */
@Immutable
class Action
{
	String name
	Closure action
	ActionType actionType = ActionType.NORMAL
}
