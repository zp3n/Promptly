package dev.zp3n.promptly;

import java.util.HashMap;
import java.util.Map;

public class CommandRewriter {

    private static final Map<String, String> commandMap = new HashMap<>();

    static {
        // ここに変換ルールを書く
        commandMap.put("/cas", "/warp castle");
        commandMap.put("/eli", "/warp elizabeth");
        commandMap.put("/da", "/warp da");
        commandMap.put("/crp", "/warp crypts");
        commandMap.put("/mus", "/warp mus");
        commandMap.put("/tay", "/warp taylor");
        commandMap.put("/wiz", "/warp wizard_tower");
        commandMap.put("/car", "/warp carnival");
        commandMap.put("/sto", "/warp stonks");
        commandMap.put("/bar", "/warp barn");
        commandMap.put("/des", "/warp desert");
        commandMap.put("/tra", "/warp trapper");
        commandMap.put("/par", "/warp park");
        commandMap.put("/jun", "/warp jungle");
        commandMap.put("/how", "/warp howl");
        commandMap.put("/gal", "/warp galatea");
        commandMap.put("/mur", "/warp murkwater");
        commandMap.put("/gol", "/warp gold");
        commandMap.put("/de", "/warp deep");
        commandMap.put("/dw", "/warp dwarves");
        commandMap.put("/for", "/warp forge");
        commandMap.put("/bas", "/warp basecamp");
        commandMap.put("/crs", "/warp crystals");
        commandMap.put("/nuc", "/warp nucleus");
        commandMap.put("/spi", "/warp spider");
        commandMap.put("/nes", "/warp top");
        commandMap.put("/ara", "/warp arachne");
        commandMap.put("/end", "/warp end");
        commandMap.put("/dra", "/warp drag");
        commandMap.put("/voi", "/warp void");
        commandMap.put("/net", "/warp nether");
        commandMap.put("/ku", "/warp kuudra");
        commandMap.put("/was", "/warp wasteland");
        commandMap.put("/tai", "/warp dragontail");
        commandMap.put("/sca", "/warp scarleton");
        commandMap.put("/smo", "/warp smold");
        commandMap.put("/rif", "/warp rift");
        commandMap.put("/bay", "/warp bayou");

        // 必要ならどんどん追加
    }

    public static String rewrite(String input) {
        // 完全一致の場合
        if (commandMap.containsKey(input)) {
            return commandMap.get(input);
        }

        // 引数付き対応（例: /home 1 → /warp home 1）
        for (String key : commandMap.keySet()) {
            if (input.startsWith(key + " ")) {
                return commandMap.get(key) + input.substring(key.length());
            }
        }

        return input; // 変換なし
    }
}