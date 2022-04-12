package com.batz.firstmod.items;

import com.sun.java.accessibility.util.java.awt.TextComponentTranslator;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.UseAction;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

import javax.swing.*;

public class Holygrail extends Item {
    public Holygrail(Properties properties) {
        super(properties);
    }

    @Override
    public UseAction getUseAction(ItemStack stack) {
        return UseAction.DRINK;
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        int time= playerIn.ticksExisted;
        if(!playerIn.getCooldownTracker().hasCooldown(this)) {
            playerIn.removePotionEffect(Effects.WITHER);
            //playerIn.abilities.setWalkSpeed(1);
            playerIn.inventory.changeCurrentItem(1);
            //while(playerIn.getCooldownTracker().setCooldown(this, 1000) > playerIn.getCooldownPeriod(100))
            playerIn.abilities.setWalkSpeed(2);
            //Correctly set walk speed cooldown because itr only sets cooldown for use with item not walk speed back to 1 stays at 2
            playerIn.getCooldownTracker().setCooldown(this, 1000);
            return ActionResult.resultSuccess(playerIn.getHeldItem(handIn));
        }
        return ActionResult.resultFail(playerIn.getHeldItem(handIn));
    }

    //onItemUseFinish, thats where all code goes including removing poition effects
}
