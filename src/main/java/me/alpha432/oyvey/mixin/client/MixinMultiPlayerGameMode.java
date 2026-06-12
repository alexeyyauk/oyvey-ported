package me.alpha432.oyvey.mixin.client;

import me.alpha432.oyvey.features.modules.combat.CriticalsModule;
import net.minecraft.client.multiplayer.MultiPlayerGameMode;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin( MultiPlayerGameMode.class )
public class MixinMultiPlayerGameMode
{

    @Inject( method = "attack",
            at = @At( value = "INVOKE",
                    target = "Lnet/minecraft/client/multiplayer/MultiPlayerGameMode;ensureHasSentCarriedItem()V",
                    shift = At.Shift.AFTER ) )
    private void criticalsSendCritPacket(
            Player player,
            Entity entity,
            CallbackInfo ci
                                        )
    {
        final var criticals = CriticalsModule.INSTANCE;
        if ( criticals != null && criticals.isEnabled() && player instanceof LocalPlayer localPlayer )
            criticals.sendCrit( localPlayer, entity );
    }

}
