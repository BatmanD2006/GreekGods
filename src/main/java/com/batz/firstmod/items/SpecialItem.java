package com.batz.firstmod.items;

import com.batz.firstmod.ModItems;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.ai.goal.ZombieAttackGoal;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import javax.swing.*;
import java.util.List;

public class SpecialItem extends Item{

    public SpecialItem(Properties properties) {
        super(properties);
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        super.addInformation(stack, worldIn, tooltip, flagIn);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        if(!playerIn.getCooldownTracker().hasCooldown(this)) {
            playerIn.addPotionEffect(new EffectInstance(Effects.GLOWING, 200, 5));
            playerIn.addPotionEffect(new EffectInstance(Effects.BLINDNESS));
            //FIX
            playerIn.getCooldownTracker().setCooldown(this, 1000);
            return ActionResult.resultSuccess(playerIn.getHeldItem(handIn));
        }
        return ActionResult.resultFail(playerIn.getHeldItem(handIn));
    }

}
