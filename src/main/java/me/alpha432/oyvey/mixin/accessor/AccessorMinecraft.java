package me.alpha432.oyvey.mixin.accessor;

import net.minecraft.client.Minecraft;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin( Minecraft.class )
public interface AccessorMinecraft
{

    @Accessor( "rightClickDelay" )
    void oyvey$setRightClickDelay( int delay );

}
