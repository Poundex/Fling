package net.poundex.fling.fx.ui.information

import fling.ui.View
import javafx.geometry.Pos
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Component

/**
 * Created by poundex on 26/05/17.
 */
@Component @Scope("group")
class InformationView extends View<InformationModel, InformationController>
{
	@Autowired
	InformationView(InformationModel model, InformationController controller)
	{
		super(model, controller)
	}

	final Closure viewBuilder = {
		InfoType infoType = InfoType.valueOf(model.information.type.name())
		borderPane(styleClass: ['info']) {
			left(align: Pos.CENTER) {
				icon(icon: infoType.icon, iconSize: '1.5em', extraStyles: [infoType.cssClass])
			}
			center(align: Pos.CENTER_LEFT) {
				label(text: model.information.message)
			}
			right {
				button(text: 'X', styleClass: [infoType.cssClass], onAction: controller.&dismiss)
			}
		}
	}
}
