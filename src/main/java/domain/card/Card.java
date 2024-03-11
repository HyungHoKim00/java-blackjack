package domain.card;

import static domain.card.Number.ACE;

public record Card(Shape shape, Number number) {
    public int getNumberValue() {
        return number.getNumber();
    }

    public boolean isAce() {
        return number == ACE;
    }
}
