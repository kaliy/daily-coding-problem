package org.kaliy.dailycodingproblem;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class XorLinkedListTest {

    private XorLinkedList<String> nineElementsList = new XorLinkedList<>();

    @BeforeEach
    void setUp() {
        Stream.of("one", "two", "three", "four", "five", "six", "seven", "eight", "nine").forEach(nineElementsList::addLast);
    }

    @Test
    void returnsEmptyIfRequestedNegativeIndex() {
        assertThat(nineElementsList.get(-1)).isEmpty();
    }

    @Test
    void returnsEmptyIfRequestedIndexIsHigherThanTotalElementsNumber() {
        assertThat(nineElementsList.get(9)).isEmpty();
    }

    @Test
    void returnsFirstElementsOfList() {
        assertThat(nineElementsList.get(0)).contains("one");
    }

    @Test
    void returnsLastElementsOfList() {
        assertThat(nineElementsList.get(8)).contains("nine");
    }

    @Test
    void returnsElementCloserToTheBeginning() {
        assertThat(nineElementsList.get(2)).contains("three");
    }

    @Test
    void returnsElementCloserToTheEnd() {
        assertThat(nineElementsList.get(6)).contains("seven");
    }

    @Test
    void returnsElementInTheMiddle() {
        assertThat(nineElementsList.get(4)).contains("five");
    }
}
