package fling.activity
/**
 * Created by poundex on 19/05/17.
 */
interface Activity
{
	String getName()
	String getTitle()

	ActivityResult start(Object... args)
}
