package net.sagel.omnicraft.materials;

import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import net.sagel.omnicraft.items.ItemRegistry;

public class SilverMaterial implements ToolMaterial {

    public static final SilverMaterial INSTANCE = new SilverMaterial();

    @Override
    public int getDurability() {
        return 170;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return 5.5f;
    }

    @Override
    public float getAttackDamage() {
        return 4f;
    }

    @Override
    public int getMiningLevel() {
        return 2;
    }

    @Override
    public int getEnchantability() {
        return 25;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(ItemRegistry.SILVER_INGOT);
    }
}
