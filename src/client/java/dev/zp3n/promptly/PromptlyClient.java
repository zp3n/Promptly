package dev.zp3n.promptly;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.message.v1.ClientSendMessageEvents;
import dev.zp3n.promptly.config.PromptlyConfig;
import net.minecraft.client.Minecraft;

public class PromptlyClient implements ClientModInitializer {

	@Override
	public void onInitializeClient() {

		// ★追加
		PromptlyConfig.load();

		ClientSendMessageEvents.ALLOW_COMMAND.register((command) -> {

			String original = "/" + command;
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