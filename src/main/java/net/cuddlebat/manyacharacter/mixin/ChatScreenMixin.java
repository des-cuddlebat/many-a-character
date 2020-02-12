package net.cuddlebat.manyacharacter.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

import net.minecraft.client.gui.screen.ChatScreen;
import net.minecraft.server.network.packet.ChatMessageC2SPacket;

@Mixin(ChatScreen.class)
public class ChatScreenMixin
{
	@ModifyConstant(
		method = "init()V",
		constant = @Constant(intValue = 256))
	public int ctorIncreaseLimit(int twoHundredFiftySix)
	{
		return 16384;
	}
}