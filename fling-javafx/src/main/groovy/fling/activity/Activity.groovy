package fling.activity

import fling.ui.Group

/**
 * Created by poundex on 19/05/17.
 */
interface Activity
{
	String getName()
	String getTitle()

	Group start(Object... args)
}
