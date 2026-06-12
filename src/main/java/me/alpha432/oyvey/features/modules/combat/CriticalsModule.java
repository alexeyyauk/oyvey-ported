package me.alpha432.oyvey.features.modules.combat;

import me.alpha432.oyvey.event.impl.network.PacketEvent;
import me.alpha432.oyvey.features.modules.Module;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.network.protocol.game.ServerboundInteractPacket;
import net.minecraft.network.protocol.game.ServerboundMovePlayerPacket;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.boss.enderdragon.EndCrystal;

public class CriticalsModule extends Module
{
    public static CriticalsModule INSTANCE;
    public CriticalsModule()
    {
        super( "Criticals", "Makes you do critical hits", Category.COMBAT );
        INSTANCE = this;
    }

    public void sendCrit(
            final LocalPlayer player,
            final Entity entity
                             )
    {
            if ( entity == null || entity instanceof EndCrystal || !player.onGround() || !( entity instanceof LivingEntity ) )
                return;

            boolean bl = player.horizontalCollision;
            player.connection.send( new ServerboundMovePlayerPacket.Pos(
                    player.getX(),
                    player.getY() + 0.1f,
                    player.getZ(),
                    false,
                    bl
            ) );
            player.connection.send( new ServerboundMovePlayerPacket.Pos(
                    player.getX(),
                    player.getY(),
                    player.getZ(),
                    false,
                    bl
            ) );
            player.crit( entity );
    }

    @Override
    public String getDisplayInfo()
    {
        return "Packet";
    }

}
