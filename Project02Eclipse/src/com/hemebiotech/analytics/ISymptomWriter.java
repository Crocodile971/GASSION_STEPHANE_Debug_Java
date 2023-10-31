package com.hemebiotech.analytics;

import java.util.Map;

public interface ISymptomWriter {

    /**
     *
     * @param symptoms list sorted alphabetically
     */
    public void writeSymptoms(Map<String, Integer> symptoms);

}
