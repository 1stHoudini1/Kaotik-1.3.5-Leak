package com.mawuote.client.mixins.impl.blocks;

import org.spongepowered.asm.mixin.*;
import net.minecraft.block.*;
import net.minecraft.block.state.*;
import net.minecraft.world.*;
import net.minecraft.util.math.*;
import org.spongepowered.asm.mixin.injection.callback.*;
import com.mawuote.*;
import com.mawuote.client.modules.render.*;
import org.spongepowered.asm.mixin.injection.*;
import net.minecraft.util.*;
import com.mawuote.api.manager.event.impl.render.*;
import net.minecraftforge.common.*;
import net.minecraftforge.fml.common.eventhandler.*;

@Mixin({ Block.class })
public class MixinBlock
{
    @Inject(method = { "shouldSideBeRendered" }, at = { @At("HEAD") }, cancellable = true)
    public void shouldSideBeRendered(final IBlockState blockState, final IBlockAccess blockAccess, final BlockPos pos, final EnumFacing side, final CallbackInfoReturnable<Boolean> callback) {
        if (Kaotik.getModuleManager().isModuleEnabled("Wallhack")) {
            ModuleWallhack.processShouldSideBeRendered((Block)this, blockState, blockAccess, pos, side, callback);
        }
    }
    
    @Inject(method = { "getRenderLayer" }, at = { @At("HEAD") }, cancellable = true)
    public void getRenderLayer(final CallbackInfoReturnable<BlockRenderLayer> callback) {
        final EventBlockGetRenderLayer event = new EventBlockGetRenderLayer((Block)this);
        MinecraftForge.EVENT_BUS.post((Event)event);
        if (event.isCancelled()) {
            callback.cancel();
            callback.setReturnValue(event.getBlockRenderLayer());
        }
    }
    
    @Inject(method = { "getLightValue" }, at = { @At("HEAD") }, cancellable = true)
    public void getLightValue(final CallbackInfoReturnable<Integer> callback) {
        if (Kaotik.getModuleManager().isModuleEnabled("Wallhack")) {
            ModuleWallhack.processGetLightValue((Block)this, callback);
        }
    }
}
