package com.batz.firstmod;


import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.IForgeRegistry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Properties;

@Mod("firstmod")
@Mod.EventBusSubscriber(modid = "firstmod", bus= Mod.EventBusSubscriber.Bus.MOD)
public class FirstMod
{
    private static final Logger LOGGER = LogManager.getLogger();

    public FirstMod() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);
        final IEventBus modEventBus= FMLJavaModLoadingContext.get().getModEventBus();

        MinecraftForge.EVENT_BUS.register(this);


        ModItems.ITEMS.register(modEventBus);
        ModBlocks.BLOCKS.register(modEventBus);

    }
    @SubscribeEvent
    public static void CreateBlockItems(final RegistryEvent.Register<Item> event){
        final IForgeRegistry<Item> registry = event.getRegistry();

        ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get).forEach(block -> {
            final Item.Properties properties = new Item.Properties();
            final BlockItem blockItem= new BlockItem(block, properties);
            blockItem.setRegistryName(block.getRegistryName());
            registry.register(blockItem);

        });
    }

    private void setup(final FMLCommonSetupEvent event){
    }

    private void doClientStuff(final FMLClientSetupEvent event) {
    }






}




