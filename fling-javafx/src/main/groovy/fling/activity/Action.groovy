package fling.activity

import groovy.transform.Immutable

/**
 * Created by poundex on 25/05/17.
 */
@Immutable
class Action
{
	String name
	Closure action
	boolean primary = false
}
