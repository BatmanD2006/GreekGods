package com.batz.firstmod.items;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.LightningBoltEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

public class Bolt extends Item {
    public Bolt(Properties properties) {
        super(properties);
    }


    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        //double x= playerIn.getLookVec().getX();
        //double y= playerIn.getLookVec().getY();
        //double z= playerIn.getLookVec().getZ();

        if(!(worldIn instanceof ServerWorld)) return new ActionResult<>(ActionResultType.PASS, playerIn.getHeldItem(handIn));
        ServerWorld world = (ServerWorld) worldIn;

        RayTraceResult lookingAt = Minecraft.getInstance().objectMouseOver;
        if (lookingAt != null && lookingAt.getType() == RayTraceResult.Type.BLOCK) {
            double x = lookingAt.getHitVec().getX();
            double y= lookingAt.getHitVec().getY();
            double z = lookingAt.getHitVec().getZ();

            //LightningBoltEntity lightBolt= new LightningBoltEntity(worldIn, x, y, z, false);
            LightningBoltEntity lightBolt= new LightningBoltEntity(worldIn, x, y, z, false);
            //LightningBoltEntity lightBolt= new LightningBoltEntity(worldIn, playerIn.getPosX() + x*10D, playerIn.getPosY()+y*10D, playerIn.getPosZ()+z*10D, false);
            world.addLightningBolt(lightBolt);
            lightBolt.setGlowing(true);
            System.out.println(RayTraceUtil.getTargetBlock(playerIn, worldIn, 20));
            System.out.println(RayTraceUtil.getTargetBlockPos(playerIn, worldIn, 20));
            return ActionResult.resultSuccess(playerIn.getHeldItem(handIn));

        }
        return ActionResult.resultSuccess(playerIn.getHeldItem(handIn));



    }




}
