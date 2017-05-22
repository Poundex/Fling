package net.poundex.fling.ctx

/**
 * Created by poundex on 20/05/17.
 */
class GroupContextHolder
{
	private static final ThreadLocal<UUID> group = new ThreadLocal<>()

	static UUID getCurrentContext()
	{
		return group.get()
	}

	static void setCurrentContext(UUID group)
	{
		this.group.set(group)
	}

}
