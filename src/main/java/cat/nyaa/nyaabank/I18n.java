package cat.nyaa.nyaabank;

import org.librazy.nyaautils_lang_checker.LangKey;
import cat.nyaa.nyaacore.LanguageRepository;
import org.bukkit.plugin.java.JavaPlugin;

public class I18n extends LanguageRepository {
    private static I18n instance;
    private final NyaaBank plugin;
    private final String lang;

    @Override
    protected JavaPlugin getPlugin() {
        return plugin;
    }

    @Override
    protected String getLanguage() {
        return lang;
    }

    public I18n(NyaaBank plugin, String lang) {
        instance = this;
        this.plugin = plugin;
        this.lang = lang;
        load();
    }

    public static String format(@LangKey String key, Object... args) {
        return instance.get(key, args);
    }
}
