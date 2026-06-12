package me.alpha432.oyvey.mixin.client;

import com.llamalad7.mixinextras.sugar.Local;
import me.alpha432.oyvey.event.impl.entity.player.TickEvent;
import net.minecraft.client.Minecraft;
import net.minecraft.util.profiling.ProfilerFiller;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import static me.alpha432.oyvey.util.traits.Util.EVENT_BUS;

@Mixin( Minecraft.class )
public class MixinMinecraft
{

    @Inject( method = "tick",
            at = @At( value = "INVOKE",
                    target = "Lnet/minecraft/client/renderer/GameRenderer;tick()V",
                    shift = At.Shift.AFTER ) )
    private void tickHook(
            CallbackInfo ci,
            @Local( name = "profilerFiller" ) ProfilerFiller profilerFiller
                         )
    {
        profilerFiller.popPush( "oyvey_tick_event" );
        EVENT_BUS.post( new TickEvent() );
    }

}
