package Ini;

import org.jetbrains.annotations.NotNull;

import java.util.HashMap;

public class IniObject {
    private HashMap<String, HashMap<String, Object>> _data;

    IniObject(@NotNull HashMap<String, HashMap<String, Object>> map) {
        _data = (HashMap<String, HashMap<String, Object>>) map.clone();
    }

    public String getString(String section, String parameter) {
        return _data.get(section).get(parameter).toString();
    }

    public int getInt(String section, String parameter) {
        return Integer.parseInt(getString(section, parameter));
    }

    public float getFloat(String section, String parameter) {
        return Float.parseFloat(getString(section, parameter));
    }

    @Override
    public String toString() {
        return _data.toString();
    }
}
