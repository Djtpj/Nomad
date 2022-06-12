package me.djtpj.nomad.items.meta;

import org.bukkit.inventory.meta.ItemMeta;

/**
 * Used to edit MetaData on NomadItem easier.
 * @see me.djtpj.nomad.items.NomadItem
 * @see me.djtpj.nomad.items.NomadItem#changeMeta(MetaAttributeOperator)
 */
public interface MetaAttributeOperator {

    void op(ItemMeta meta);

    default ItemMeta run(ItemMeta meta) {
        op(meta);
        return meta;
    }
}
