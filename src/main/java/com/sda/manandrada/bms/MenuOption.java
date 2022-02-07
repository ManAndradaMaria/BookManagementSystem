package com.sda.manandrada.bms;

public enum MenuOption {
    CREATE_BOOK("1", "Create Book"),
    CREATE_AUTHOR("2", "Create Author"),
    CREATE_REVIEW("3", "Create Review"),
    CREATE_BOOK_WITH_AUTHOR("4", "Create book with author"),
    VIEW_ALL_AUTHOR("5","View all author"),
    EXIT("Exit", "Close the application"),
    UNDEFINED("", "Menu option non-defined");

    //encapsulare private
    private final String option;
    private final String description;
    //nu pot extinde un enum, pt ca un enum extinde automat clasa Enum!!!!!!!

    // constructorul la enum are modificator de acces private la enum!!!!!!!atentie ne poate intreba la iterviu
    // constructorul e by default; pt ca fiecare instanta din enum e creata in interiorul enumul-ui si doar in interiorul enumului
    MenuOption(String option, String description) {
        this.option = option;
        this.description = description;
    }

    public String getOption() {
        return option;
    }

    public String getDescription() {
        return description;
    }
}
