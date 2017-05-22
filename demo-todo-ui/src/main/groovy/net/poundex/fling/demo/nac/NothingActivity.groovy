package net.poundex.fling.demo.nac

import fling.activity.Activity
import fling.ui.Group
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

	private final NothingGroup nothingGroup

	@Autowired
	NothingActivity(NothingGroup nothingGroup)
	{
		this.nothingGroup = nothingGroup
	}

	@Override
	Group getView()
	{
		return nothingGroup
	}
}
