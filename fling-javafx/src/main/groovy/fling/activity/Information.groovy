package fling.activity

import groovy.transform.Immutable

/**
 * Created by poundex on 26/05/17.
 */
@Immutable
class Information
{
	public static enum Type {
		INFO, SUCCESS, WARNING, ERROR
	}

	Type type
	String message
}
