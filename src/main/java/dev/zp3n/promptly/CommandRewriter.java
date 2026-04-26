package dev.zp3n.promptly;

import dev.zp3n.promptly.config.PromptlyConfig;

public class CommandRewriter {

    public static String rewrite(String input) {

        for (var entry : PromptlyConfig.commands.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();

            if (input.equals(key)) {
                return value;
            }

            if (input.startsWith(key + " ")) {
                return value + input.substring(key.length());
            }
        }

        return input;
    }
}