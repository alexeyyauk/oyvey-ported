package me.alpha432.oyvey.mixin.accessor;

import net.minecraft.client.multiplayer.MultiPlayerGameMode;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin( MultiPlayerGameMode.class )
public interface AccessorMultiPlayerGameMode
{

    @Invoker( "ensureHasSentCarriedItem" )
    void oyvey$syncSlot();

}
