package org.kaliy.dailycodingproblem;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class AutoCompleteTest {

    private AutoComplete autoComplete = new AutoComplete(Collections.singleton("word"));

    @Test
    void constructorThrowsExceptionOnNull() {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> new AutoComplete(null));
    }

    @Test
    void constructorThrowsExceptionOnEmptyString() {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> new AutoComplete(Collections.emptyList()));
    }

    @Test
    void throwsExceptionOnCompletingNull() {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> autoComplete.complete(null));
    }

    @Test
    void throwsExceptionOnCompletingEmptyString() {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> autoComplete.complete(""));
    }

    @Test
    void completesWordsFromTheDictionary() {
        var autoComplete = new AutoComplete(Arrays.asList("dog", "deer", "deal"));
        assertThat(autoComplete.complete("de")).containsOnly("deer", "deal");
    }

    @Test
    void completesWordsFromNonEnglishDictionary() {
        var autoComplete = new AutoComplete(Arrays.asList("креведко", "кресло", "кровь", "краска"));
        assertThat(autoComplete.complete("кре")).containsOnly("кресло", "креведко");
    }

    @Test
    void completesWordsOfAGivenStringEndingWithZ() {
        var autoComplete = new AutoComplete(Arrays.asList("azkaban", "azaza", "azerbaijan", "axe"));
        assertThat(autoComplete.complete("az")).containsOnly("azaza", "azkaban", "azerbaijan");
    }

    @Test
    void doesNotIncludeWordWithIncrementedLastLetter() {
        var autoComplete = new AutoComplete(Arrays.asList("aba", "ac", "abb"));
        assertThat(autoComplete.complete("ab")).containsOnly("aba", "abb");
    }

    @Test
    void includesGivenStringIfItIsPresentInDictionary() {
        var autoComplete = new AutoComplete(Arrays.asList("ab", "aba", "acc"));
        assertThat(autoComplete.complete("ab")).containsOnly("ab", "aba");
    }
}
