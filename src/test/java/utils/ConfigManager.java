package utils;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;

public class ConfigManager {
    private static Properties PROPERTIES_CONF_DRIVER;
    private static Properties PROPERTIES_CONF;
    private static final String PATH_CONF = "src/test/resources/conf.properties";
    private static final String PATH_CONF_IOS = "src/test/resources/confIOS.properties";
    private static final String PATH_CONF_ANDROID = "src/test/resources/confAndroid.properties";
    public static final String NAME_DRIVER = "NameDriver";
    public static final String IOS = "IOS";
    public static final String ANDROID = "ANDROID";


    /**
     * Статический блок инициализации чтения данных из проперти файлов
     */
    static {
        try (FileReader fileInputStreamConf = new FileReader(PATH_CONF)) {
            PROPERTIES_CONF = new Properties();
            PROPERTIES_CONF.load(fileInputStreamConf);
            if (IOS.equals(PROPERTIES_CONF.getProperty(NAME_DRIVER))) {
                FileReader fileInputStreamConfDriver = new FileReader(PATH_CONF_IOS);
                PROPERTIES_CONF_DRIVER = new Properties();
                PROPERTIES_CONF_DRIVER.load(fileInputStreamConfDriver);
            } else if (ANDROID.equals(PROPERTIES_CONF.getProperty(NAME_DRIVER))) {
                FileReader fileInputStreamConfDriver = new FileReader(PATH_CONF_ANDROID);
                PROPERTIES_CONF_DRIVER = new Properties();
                PROPERTIES_CONF_DRIVER.load(fileInputStreamConfDriver);
            }
        } catch (IOException e) {
            System.out.println("error read properties" + e);
        }
    }

    /**
     * Метод для получения данных из файла conf ios, Android
     *
     * @return Capabilities данные из файла по ключу
     */
    public static String getPropertyConfDriver(String key) {
        return PROPERTIES_CONF_DRIVER.getProperty(key);
    }

    /**
     * Метод для получения данных из файла conf
     *
     * @return Capabilities данные из файла по ключу
     */
    public static String getPropertyConf(String key) {
        return PROPERTIES_CONF.getProperty(key);
    }


    /**
     * Метод для получения данных ключей из файла conf ios, Android
     */
    public static Set<String> getDriverPropertyStr() {
        Set<String> conf = PROPERTIES_CONF_DRIVER.stringPropertyNames();
        return conf;
    }

}
