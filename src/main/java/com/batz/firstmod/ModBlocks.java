package com.batz.firstmod;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =  new DeferredRegister<Block>(ForgeRegistries.BLOCKS, "firstmod");

    public static final RegistryObject<Block> DOOM = BLOCKS.register("doom", () -> new Block(Block.Properties.create(Material.ROCK).sound(SoundType.STONE)));




}
