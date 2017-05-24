package net.poundex.fling.demo.nac

import fling.activity.Activity
import fling.ui.Group
import net.poundex.fling.group.GroupService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

/**
 * Created by poundex on 19/05/17.
 */
@Component
class NothingActivity implements Activity
{
	final String name = 'NOOP'
	final String title = 'Do Nothing'

	private final GroupService groupService

	@Autowired
	NothingActivity(GroupService groupService)
	{
		this.groupService = groupService
	}

	@Override
	Group start(Object... args)
	{
		return groupService.create(NothingGroup)
	}
}
