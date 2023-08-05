package utilities;

public enum Value {
    
    ZERO,
    ONE,
    TWO,
    THREE,
    FOUR,
    FIVE,
    SIX,
    SEVEN,
    EIGHT,
    NINE,
    UNCLASSIFIED,
    GO,
    GOBACK,
    CLOSE;

    public boolean isClass(){
        return this.ordinal() < 10;
    }
}
