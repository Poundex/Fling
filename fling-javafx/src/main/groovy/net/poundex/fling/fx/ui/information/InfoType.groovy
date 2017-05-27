package net.poundex.fling.fx.ui.information

import de.jensd.fx.glyphs.materialicons.MaterialIcon
/**
 * Created by poundex on 13/09/15.
 */
enum InfoType {

	INFO('info-info', MaterialIcon.INFO),
	SUCCESS('info-success', MaterialIcon.CHECK),
	WARNING('info-warning', MaterialIcon.WARNING),
	ERROR('info-error', MaterialIcon.ERROR)

	String cssClass
	MaterialIcon icon

	InfoType(String cssClass, MaterialIcon icon)
	{
		this.cssClass = cssClass
		this.icon = icon
	}
}