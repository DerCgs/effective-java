package org.dercg.effectivejava.a_05_dependencyInjection;

import java.util.Objects;

// Dependency injection provides flexibility and testability
public class SpellChecker {
    private final Lexicon dictionary;

    // 优先考虑依赖注入来引用资源
    public SpellChecker(Lexicon dictionary){
        this.dictionary = Objects.requireNonNull(dictionary);
    }


}
