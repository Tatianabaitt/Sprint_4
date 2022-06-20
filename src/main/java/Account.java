public class Account {

    private final String name;

    public Account(String name) {
        this.name = name;
    }

    public boolean checkNameToEmboss() {

        if (name.isBlank()) {
            System.out.println("Передана пустая строка или строка состоящая из одних пробелов.");
            return false;
        } else if (name.length() < 3 || name.length() > 19) {
            System.out.println("Передана строка не удовлетворяет требованиям длины.");
            return false;
        } else if (spaceCount() != 1) {
            System.out.println("В переданной строке отсутвуют пробелы или больше одного пробела.");
            return false;
        } else if (name.length() != name.trim().length()) {
            System.out.println("В переданной строке на первом или последнем месте пробел.");
            return false;
        } else {
            return true;
        }
    }

    private int spaceCount(){
        int spaceCount = 0;
        for (char c : name.toCharArray()) {
            if (c == ' ') {
                spaceCount++;
            }
        }
        return spaceCount;
    }

}