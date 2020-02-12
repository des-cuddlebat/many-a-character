package net.cuddlebat.manyacharacter.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

import net.minecraft.server.network.packet.ChatMessageC2SPacket;

@Mixin(ChatMessageC2SPacket.class)
public class ChatMessageC2SPacketMixin
{
	@ModifyConstant(
		method = "<init>(Ljava/lang/String;)V",
//		method = "(Ljava.lang.String;)Lnet/minecraft/server/network/packet/ChatMessageC2SPacket;",
		require = 2,
		constant = @Constant(intValue = 256))
	public int ctorIncreaseLimit(int twoHundredFiftySix)
	{
		return 16384;
	}
	
	@ModifyConstant(
		method = "read(Lnet/minecraft/util/PacketByteBuf;)V",
		constant = @Constant(intValue = 256))
	public int readIncreaseLimit(int twoHundredFiftySix)
	{
		return 16384;
	}
}