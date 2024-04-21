package net.sagel.omnicraft.blocks;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.PillarBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.sagel.omnicraft.items.ItemRegistry;

public class BlockRegistry {

    public static <T extends Block> T register(T block, String name, boolean shouldRegisterItem){
        Identifier id = new Identifier("omnicraft", name);

        if(shouldRegisterItem){
            BlockItem blockItem = new BlockItem(block, new Item.Settings());
            Registry.register(Registries.ITEM, id, blockItem);
        }

        return Registry.register(Registries.BLOCK, id, block);
    }

    public static void initialize(){
    }

    public static final Block OMNICRYSTAL_BLOCK = register(new Block(FabricBlockSettings.create()
                    .sounds(BlockSoundGroup.COPPER).strength(4f).requiresTool()),
            "omnicrystal_block", true);

    public static final PillarBlock GALVAN_DEBRIS = register(new PillarBlock(FabricBlockSettings.create()
                    .sounds(BlockSoundGroup.ANCIENT_DEBRIS).strength(10f).requiresTool()),
            "galvan_debris", true);
}
