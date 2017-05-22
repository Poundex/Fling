package net.poundex.fling.fx.ui.form

import fling.ui.Group
import fling.ui.Model
import org.springframework.beans.factory.config.BeanDefinition
import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Component

/**
 * Created by poundex on 20/05/17.
 */
@Component @Scope("group")
class FormModel extends Model
{
	Group cardContent
}
