package net.sagel.omnicraft.materials;

import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.sagel.omnicraft.Omnicraft;
import net.sagel.omnicraft.items.ItemRegistry;

public class SilverArmorMaterial implements ArmorMaterial {

    public static final SilverArmorMaterial INSTANCE = new SilverArmorMaterial();

    //standard durability values
    private static final int[] BASE_DURABILITY = new int[] {13, 15, 16, 11};
    private static final int durabilityMultiplier = 12;

    private static final int PROTECTION_BOOTS = 1;
    private static final int PROTECTION_LEGGINGS = 3;
    private static final int PROTECTION_CHESTPLATE = 5;
    private static final int PROTECTION_HELMET = 2;

    private static final int[] PROTECTION_VALUES = new int[] {
            PROTECTION_BOOTS,
            PROTECTION_LEGGINGS,
            PROTECTION_CHESTPLATE,
            PROTECTION_HELMET
    };

    @Override
    public int getDurability(ArmorItem.Type type) {
        return BASE_DURABILITY[type.getEquipmentSlot().getEntitySlotId()] * durabilityMultiplier;
    }

    @Override
    public int getProtection(ArmorItem.Type type) {
        return PROTECTION_VALUES[type.getEquipmentSlot().getEntitySlotId()];
    }

    @Override
    public int getEnchantability() {
        return 15;
    }

    @Override
    public SoundEvent getEquipSound() {
        return SoundEvents.ITEM_ARMOR_EQUIP_GOLD;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(ItemRegistry.SILVER_INGOT);
    }

    @Override
    public String getName() {
        return Omnicraft.MOD_ID + ":silver";
    }

    @Override
    public float getToughness() {
        return 0.5f;
    }

    @Override
    public float getKnockbackResistance() {
        return 0.05f;
    }
}
