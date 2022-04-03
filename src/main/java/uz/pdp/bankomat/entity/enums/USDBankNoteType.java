package uz.pdp.bankomat.entity.enums;

public enum USDBankNoteType {
    _0(0),_1(1), _5(5), _10(10), _20(20), _50(50),_100(100);

    private final int value;

    USDBankNoteType(final int newValue) {
        value = newValue;
    }

    public int getValue() { return value; }
}
