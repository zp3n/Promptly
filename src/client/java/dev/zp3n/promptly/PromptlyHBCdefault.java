package dev.zp3n.promptly;

import net.minecraft.client.Minecraft;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientEntityEvents;
import net.minecraft.client.player.LocalPlayer;

public class PromptlyHBCdefault implements ClientModInitializer{

    @Override
    public void onInitializeClient() {
        ClientEntityEvents.ENTITY_LOAD.register((entity, world) -> {
            Minecraft mc = Minecraft.getInstance();

            // ロードされたエンティティが「自分自身（プレイヤー）」であるかチェック
            if (entity instanceof LocalPlayer && entity == mc.player) {

                // ここに実行したい処理（設定変更など）を書く
                Minecraft.getInstance().options.toggleAttack().set(false);

            }
        });
    }
}