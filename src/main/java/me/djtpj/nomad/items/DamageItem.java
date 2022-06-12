package me.djtpj.nomad.items;

import lombok.Getter;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;

import java.util.UUID;

public abstract class DamageItem extends NomadItem {
    @Getter
    protected int damage, knockback;

    public DamageItem(Material type, String name, int damage) {
        super(type, name);

        setDamage(damage);
    }

    public DamageItem(Material type, String name) {
        super(type, name);
    }

    public void setDamage(int damage) {
        this.damage = damage;

        changeMeta(m -> {
            AttributeModifier modifier = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", this.damage, AttributeModifier.Operation.ADD_NUMBER);
            m.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, modifier);
        });
    }

    public void setKnockback(int knockback) {
        this.knockback = knockback;

        changeMeta(m -> {
            AttributeModifier modifier = new AttributeModifier(UUID.randomUUID(), "generic.attackKnockback", this.knockback, AttributeModifier.Operation.ADD_NUMBER);
            m.addAttributeModifier(Attribute.GENERIC_ATTACK_KNOCKBACK, modifier);
        });
    }
}
