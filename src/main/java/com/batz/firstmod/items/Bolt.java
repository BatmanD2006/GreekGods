package com.batz.firstmod.items;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ai.attributes.Attribute;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.effect.LightningBoltEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

public class Bolt extends Item {
    public Bolt(Properties properties) {
        super(properties);
    }
@todo Change Lightning Color

    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {

        PlayerEntity player = Minecraft.getInstance().player;
        if (!(worldIn instanceof ServerWorld))
            return new ActionResult<>(ActionResultType.PASS, playerIn.getHeldItem(handIn));
        ServerWorld world = (ServerWorld) worldIn;

        RayTraceResult block = player.pick(30.0D, 0.0F, false);
        if (block.getType() == RayTraceResult.Type.BLOCK) {
            BlockPos blockpos = ((BlockRayTraceResult) block).getPos();
            double x1 = blockpos.getX();
            double y1 = blockpos.getY();
            double z1 = blockpos.getZ();

            LightningBoltEntity lightBolt = new LightningBoltEntity(worldIn, x1, y1, z1, false);
            world.addLightningBolt(lightBolt);
            lightBolt.setGlowing(true);
            return ActionResult.resultSuccess(playerIn.getHeldItem(handIn));

        }
        return ActionResult.resultSuccess(playerIn.getHeldItem(handIn));


    }


}
