package codigo;

import java.util.Random;

class NameGenerator {

    private static String[] Beginning = { "Le", "Fer", "Ale", "Je", "Lo","Wel",
            "Ro", "Di", "An", "Mor", "Jag", "Mer", "Jar", "Leo","Gui",
            "Fi", "Thi", "Cris", "Fa", "Ri", "Au", "Rei", "Ant", "Mu" , "Jo",
            "Ema", "Lu" ,"Ri", "Thi", "Ti", "And", "Edi", "Ric","Tra", "Re", "Al", "Be", "Clo", "Ar", "Je", "Sa", "Hen", "Lu" };
    private static String[] Middle = { "an", "na", "xan", "i", "dri", "ri","lher","ling",
            "red", "li", "a", "lori", "cres", "mur", "on", "ba", "vu", "ve",
            "car", "gus", "bi", "nu", "nar","la", "" };
    private static String[] End = { "dro", "do", "dre", "son", "val", "er", "der","me","ton",
            "o", "pe", "to", "go", "el", "io", "nho", "son" , "go", "lho","nal", "ca","de","na","ne","la", ""};




    private static Random rand = new Random();

    public static String generateName() {

        return Beginning[rand.nextInt(Beginning.length)] +
                Middle[rand.nextInt(Middle.length)]+
                End[rand.nextInt(End.length)];

    }

}
