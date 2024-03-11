package domain.deck;

import static org.assertj.core.api.Assertions.assertThat;

import domain.card.Card;
import domain.card.Number;
import domain.card.Shape;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class UserDeckTest {
    @Test
    @DisplayName("유저 카드 덱에 카드를 추가할 수 있다.")
    void pushCardTest() {
        Card card = new Card(Shape.CLOVER, Number.ACE);
        UserDeck userDeck = new UserDeck();

        userDeck.addCard(card);

        assertThat(userDeck.getCards()).contains(card);
    }

    @Test
    @DisplayName("덱 카드의 숫자의 합을 구할 수 있다.")
    void sumCardTest() {
        UserDeck userDeck = new UserDeck();

        userDeck.addCard(new Card(Shape.CLOVER, Number.THREE));
        userDeck.addCard(new Card(Shape.CLOVER, Number.EIGHT));

        assertThat(userDeck.sumCard()).isEqualTo(11);
    }

    @Test
    @DisplayName("ACE 카드는 합이 11 이하일 때 숫자가 11로 사용된다.")
    void sumCardContainingAceTest() {
        UserDeck userDeck = new UserDeck();

        userDeck.addCard(new Card(Shape.CLOVER, Number.ACE));
        userDeck.addCard(new Card(Shape.CLOVER, Number.TWO));

        assertThat(userDeck.sumCard()).isEqualTo(13);
    }

    @Test
    @DisplayName("ACE 카드는 합이 11 초과일 때 숫자가 1로 사용된다.")
    void sumCardContainingAceTest2() {
        UserDeck userDeck = new UserDeck();

        userDeck.addCard(new Card(Shape.CLOVER, Number.ACE));
        userDeck.addCard(new Card(Shape.CLOVER, Number.TWO));
        userDeck.addCard(new Card(Shape.CLOVER, Number.TEN));

        assertThat(userDeck.sumCard()).isEqualTo(13);
    }

    @Test
    @DisplayName("카드의 합이 21 초과이면 busted이다.")
    void bustedTest() {
        UserDeck userDeck = new UserDeck();

        userDeck.addCard(new Card(Shape.CLOVER, Number.JACK));
        userDeck.addCard(new Card(Shape.CLOVER, Number.QUEEN));
        userDeck.addCard(new Card(Shape.CLOVER, Number.KING));

        assertThat(userDeck.busted()).isTrue();
    }

    @Test
    @DisplayName("카드의 합이 21 이하이면 busted이지 않다.")
    void notBustedTest() {
        UserDeck userDeck = new UserDeck();

        userDeck.addCard(new Card(Shape.CLOVER, Number.JACK));
        userDeck.addCard(new Card(Shape.CLOVER, Number.QUEEN));

        assertThat(userDeck.busted()).isFalse();
    }
}
