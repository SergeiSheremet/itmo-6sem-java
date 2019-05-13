package Ini;

import java.io.File;
import java.util.HashMap;
import java.util.Scanner;

public class IniDeserializer {

    private IniDeserializer(){}

    public static IniObject deserialize(File file) {
        HashMap<String, HashMap<String, Object>> model = null;

        if (!file.getName().matches(".*\\.ini$")) {
            return null;
        }

        try {
            Scanner scanner = new Scanner(file);
            model = new HashMap<>();
            String currentSection = null;

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();

                if (line.matches("\\s*(;.*)?")) {
                    continue;
                }

                line = line.split(";")[0];

                if (line.matches("\\[\\w+]\\s*")) {
                    currentSection = line.replaceAll("(?:\\[(.*?)])?.*", "$1");
                    model.put(currentSection, new HashMap<>());
                } else if (line.matches("\\w+\\s*=\\s*[\\w.]+\\s*")) {
                    var parameterValuePair = line.replaceAll("\\s+", "").split("=", 2);
                    var parameter = parameterValuePair[0];
                    var value = parameterValuePair[1];
                    model.get(currentSection).put(parameter, value);
                } else {
                    return null;
                }
            }
        } catch (Exception e) {
            return null;
        }

        return new IniObject(model);
    }
}
