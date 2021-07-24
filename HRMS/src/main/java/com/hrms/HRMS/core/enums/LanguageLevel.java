package com.hrms.HRMS.core.enums;

public enum LanguageLevel {
    ONE(1),
    TWO(2),
    THIRD(3),
    FOUR(4),
    FIVE(5);

    private int level;

    LanguageLevel(int level) {
        this.level = level;
    }

    public int getLevel() {
        return level;
    }
}
