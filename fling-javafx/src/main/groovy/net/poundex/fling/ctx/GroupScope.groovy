package net.poundex.fling.ctx

import fling.ui.Group
import org.springframework.beans.factory.ObjectFactory
import org.springframework.beans.factory.config.Scope

/**
 * Created by poundex on 20/05/17.
 */
class GroupScope implements Scope
{
	static final String GROUP_SCOPE = 'group'

	private final Map<UUID, Map<String, Object>> groups = [:].withDefault { [:] }

	@Override
	Object get(String name, ObjectFactory<?> objectFactory)
	{
		groups[GroupContextHolder.currentContext].with {
			if ( ! get(name))
				put(name, objectFactory.getObject())
			return get(name)
		}
	}

	@Override
	Object remove(String name) {
		return null
	}

	@Override
	void registerDestructionCallback(String name, Runnable callback) {

	}

	@Override
	Object resolveContextualObject(String key) {
		return null
	}

	@Override
	String getConversationId() {
		return null
	}
}
