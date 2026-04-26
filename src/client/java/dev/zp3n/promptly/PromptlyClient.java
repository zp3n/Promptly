package dev.zp3n.promptly;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.message.v1.ClientSendMessageEvents;
import dev.zp3n.promptly.config.PromptlyConfig;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;

public class PromptlyClient implements ClientModInitializer {

	@Override
	public void onInitializeClient() {

		// ★追加
		PromptlyConfig.load();

		ClientSendMessageEvents.ALLOW_COMMAND.register((command) -> {

			String original = "/" + command;
			if(command.equals("holdbreakclick") || command.equals("hbc")){
				Minecraft mc = Minecraft.getInstance();
				if(mc.options.toggleAttack().get()){
					mc.player.displayClientMessage(Component.literal("[Promptly] Attack/Destroy : Hold"),false);
					mc.player.playSound(SoundEvents.ARROW_HIT_PLAYER, 0.5F, 0.8F);
					mc.options.toggleAttack().set(false);
				}else{
					mc.player.displayClientMessage(Component.literal("[Promptly] Attack/Destroy : Toggle"), false);
					mc.player.playSound(SoundEvents.ARROW_HIT_PLAYER, 0.5F, 1.2F);
					mc.options.toggleAttack().set(true);
				}
				mc.options.save();
				return false;
			}

			String rewritten = CommandRewriter.rewrite(original);

			if (!original.equals(rewritten)) {
				Minecraft.getInstance().player.connection.sendCommand(
						rewritten.substring(1)
				);
				return false;
			}

			return true;
		});
	}
}