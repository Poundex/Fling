package net.poundex.fling.util

/**
 * Created by poundex on 26/05/17.
 */
class ClosureExtension
{
	static <T> Closure<T> withDelegate(final Closure<T> self, Object newDelegate)
	{
		return self.rehydrate(newDelegate, self.owner, self.thisObject)
	}
}
