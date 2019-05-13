import Ini.IniDeserializer;

import java.io.File;
import java.util.function.Function;

public class Program {
    public static void main(String[] args) {
        File file = new File("D:\\Dropbox\\Учёба\\Университет\\3 семестр\\Объектно-ориентированное программирование\\lab_1\\Input files\\lab01_input_correct_09.ini");

        var a = IniDeserializer.deserialize(file);
        System.out.println(a);

        System.out.println(a.getString("NCMD", "TidPacketVersionForResetChannel"));
        System.out.println(a.getFloat("NCMD", "TidPacketVersionForResetChannel"));
        System.out.println(a.getInt("NCMD", "TidPacketVersionForResetChannel"));
    }
}
