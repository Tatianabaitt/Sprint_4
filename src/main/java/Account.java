public class Account {
    private final String name;

    public Account(String name) {
        this.name = name;
    }

    public boolean checkNameToEmboss() {
        if (name == null) {
            return false;
        }
        boolean nameIsNotBlank = !name.isBlank();
        boolean nameIsLengthInvalid = name.length() >= 3 & name.length() <= 19;
        boolean nameIsSpaceOne = name.indexOf(' ') == name.lastIndexOf(' ');
        boolean nameIsEndSpacesNotExist = name.length() == name.trim().length();
        if (!nameIsNotBlank && nameIsLengthInvalid && nameIsSpaceOne && nameIsEndSpacesNotExist) {
            System.out.println("Переданная строка не удволетворяет требованиям: " +
                    "строка не пустая, " +
                    "длины от 3 до 19 символов, " +
                    "в строке присуствует один пробел, который находится ни на первом месте  и ни на последем");
        }
        return nameIsNotBlank && nameIsLengthInvalid && nameIsSpaceOne && nameIsEndSpacesNotExist;
    }
}