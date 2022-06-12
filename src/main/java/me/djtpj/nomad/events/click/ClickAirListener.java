package me.djtpj.nomad.events.click;

import me.djtpj.nomad.items.NomadItem;
import org.bukkit.event.block.Action;

/** Listener that fires everytime the specified item is clicked on the air
 * @see NomadItem
 * @see me.djtpj.nomad.events.NomadListener
 */
public abstract class ClickAirListener extends ClickListener {
    public ClickAirListener(NomadItem item) {
        super(item, Action.RIGHT_CLICK_AIR, Action.LEFT_CLICK_AIR);
    }
}
