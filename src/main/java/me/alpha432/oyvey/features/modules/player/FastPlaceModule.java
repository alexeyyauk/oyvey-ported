package me.alpha432.oyvey.features.modules.player;

import me.alpha432.oyvey.features.modules.Module;
import me.alpha432.oyvey.mixin.accessor.AccessorMinecraft;
import net.minecraft.client.Minecraft;
import net.minecraft.world.item.Items;

public class FastPlaceModule extends Module
{

    public FastPlaceModule()
    {
        super( "FastPlace", "Makes you throw exp faster", Category.PLAYER );
    }

    @Override
    public void onTick()
    {
        final var mc = Minecraft.getInstance();
        final var player = mc.player;
        if ( player == null ) return;

        if ( mc.player.isHolding( Items.EXPERIENCE_BOTTLE ) )
            ( (AccessorMinecraft) mc ).oyvey$setRightClickDelay( 0 );
    }

}
