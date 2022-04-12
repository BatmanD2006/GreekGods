package com.batz.firstmod;

import com.batz.firstmod.items.Bolt;
import com.batz.firstmod.items.Holygrail;
import com.batz.firstmod.items.SpecialItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItems {

    public static final DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS, "firstmod");

    public static final RegistryObject<Item> SLASHER = ITEMS.register("slasher",
            () -> new Item(new Item.Properties().maxStackSize(32).group(ItemGroup.TOOLS)));

    public static final RegistryObject<SpecialItem> SPECIAL = ITEMS.register("special",
            () -> new SpecialItem(new Item.Properties().group(ItemGroup.TOOLS)));


    public static final RegistryObject<Holygrail> HOLY_GRAIL = ITEMS.register("holy_grail",
            () -> new Holygrail(new Item.Properties().maxStackSize(1).group(ItemGroup.FOOD)));

    public static final RegistryObject<Bolt> BOLT=  ITEMS.register("bolt",
            () -> new Bolt(new Item.Properties().maxStackSize(1).group(ItemGroup.FOOD)));




}