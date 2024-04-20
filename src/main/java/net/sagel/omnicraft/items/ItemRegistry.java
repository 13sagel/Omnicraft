package net.sagel.omnicraft.items;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.sagel.omnicraft.Omnicraft;


public class ItemRegistry {

    // We can use generics to make it so we dont need to
    // cast to an item when using this method.
    public static <T extends Item> T register(T item, String ID) {
        // Create the identifier for the item.
        Identifier itemID = new Identifier(Omnicraft.MOD_ID, ID);

        // Register the item.
        T registeredItem = Registry.register(Registries.ITEM, itemID, item);

        // Return the registered item!
        return registeredItem;
    }

    //Lambdas take in class methods to set in-game variables
    public static final ItemGroup OMNICRAFT_ITEMGROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(Omnicraft.MOD_ID, "omnicraft_main"),
            FabricItemGroup.builder()
                    .icon(() -> new ItemStack(ItemRegistry.OMNICRYSTAL))
                    .displayName(Text.translatable("itemGroup.omnicraft"))
                    .entries((displayContext, entries) -> {
                        entries.add(ItemRegistry.OMNICRYSTAL);
                        entries.add(ItemRegistry.OMNITRIXV1);
                        entries.add(ItemRegistry.HERO_WATCH);
                        entries.add(ItemRegistry.OMNITRIX_FACE);
                    }).build());



    public static void initialize() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register((itemGroup) -> itemGroup.add(ItemRegistry.SILVER_INGOT));

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register((itemGroup) -> itemGroup.add(ItemRegistry.SILVER_SWORD));
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register((itemGroup) -> itemGroup.add(ItemRegistry.SILVER_SHOVEL));
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register((itemGroup) -> itemGroup.add(ItemRegistry.SILVER_PICKAXE));
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register((itemGroup) -> itemGroup.add(ItemRegistry.SILVER_AXE));
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register((itemGroup) -> itemGroup.add(ItemRegistry.SILVER_HOE));

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register((itemGroup) -> itemGroup.add(ItemRegistry.SILVER_HELMET));
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register((itemGroup) -> itemGroup.add(ItemRegistry.SILVER_CHESTPLATE));
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register((itemGroup) -> itemGroup.add(ItemRegistry.SILVER_LEGGINGS));
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register((itemGroup) -> itemGroup.add(ItemRegistry.SILVER_BOOTS));

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register((itemGroup) -> itemGroup.add(ItemRegistry.CHOCOLATE));
    }

    //BASE
    public static final Item OMNICRYSTAL = register(new Item(new FabricItemSettings()), "omnicrystal");
    public static final Item SILVER_INGOT = register(new Item(new FabricItemSettings()), "silver_ingot");

    //OMNITRIXES - Remember to remove "-1" in JSONs!!!!!!!!!!!!
    public static final Item OMNITRIXV1 = register(new Item(new FabricItemSettings().maxCount(1)), "omnitrixv1");
    public static final Item OMNITRIX_FACE = register(new Item(new FabricItemSettings()), "omnitrix_face");
    public static final Item HERO_WATCH = register(new Item(new FabricItemSettings().maxCount(1)), "hero_watch");

    //TOOLS - attack damage = base + value + 1, speed = 4 + value
    public static final Item SILVER_SWORD = register(new SwordItem(SilverMaterial.INSTANCE, 3, -2.4f,
            new FabricItemSettings()), "silver_sword");
    public static final Item SILVER_SHOVEL = register(new ShovelItem(SilverMaterial.INSTANCE, 1.5f, -3f,
            new FabricItemSettings()), "silver_shovel");
    public static final Item SILVER_PICKAXE = register(new PickaxeItem(SilverMaterial.INSTANCE, 1, -2.8f,
            new FabricItemSettings()), "silver_pickaxe");
    public static final Item SILVER_AXE = register(new AxeItem(SilverMaterial.INSTANCE, 6f, -3f,
            new FabricItemSettings()), "silver_axe");
    public static final Item SILVER_HOE = register(new HoeItem(SilverMaterial.INSTANCE, -3, 0f,
            new FabricItemSettings()), "silver_hoe");

    //ARMOR
    public static final Item SILVER_HELMET = register(new ArmorItem(SilverArmorMaterial.INSTANCE, ArmorItem.Type.HELMET,
            new FabricItemSettings()), "silver_helmet");
    public static final Item SILVER_CHESTPLATE = register(new ArmorItem(SilverArmorMaterial.INSTANCE, ArmorItem.Type.CHESTPLATE,
            new FabricItemSettings()), "silver_chestplate");
    public static final Item SILVER_LEGGINGS = register(new ArmorItem(SilverArmorMaterial.INSTANCE, ArmorItem.Type.LEGGINGS,
            new FabricItemSettings()), "silver_leggings");
    public static final Item SILVER_BOOTS = register(new ArmorItem(SilverArmorMaterial.INSTANCE, ArmorItem.Type.BOOTS,
            new FabricItemSettings()), "silver_boots");

    //FOOD
    public static final Item CHOCOLATE = register(new Item(new FabricItemSettings()
            .food(new FoodComponent.Builder().hunger(3).snack().build())), "chocolate");
}
