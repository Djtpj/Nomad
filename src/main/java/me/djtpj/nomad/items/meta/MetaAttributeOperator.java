package me.djtpj.nomad.items.meta;

import org.bukkit.inventory.meta.ItemMeta;

public interface MetaAttributeOperator {

    // changeMeta(m -> m.setDisplayName("foo"));

    void op(ItemMeta meta);

    default ItemMeta run(ItemMeta meta) {
        op(meta);
        return meta;
    }
}
