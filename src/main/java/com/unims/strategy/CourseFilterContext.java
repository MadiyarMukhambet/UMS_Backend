package com.unims.strategy;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@RequiredArgsConstructor
public class CourseFilterContext {

    private final Map<String, CourseFilterStrategy> strategyMap;

    public CourseFilterStrategy getStrategy(String key) {
        CourseFilterStrategy strategy = strategyMap.get(key);
        if (strategy == null) {
            throw new IllegalArgumentException("Unknown filter strategy: " + key);
        }
        return strategy;
    }
}
