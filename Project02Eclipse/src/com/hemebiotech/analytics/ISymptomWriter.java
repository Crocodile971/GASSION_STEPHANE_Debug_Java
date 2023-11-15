package com.hemebiotech.analytics;

import java.util.Map;


/**
 * Writing data to an output file.
 * Sort file alphabetically.
 * Creation of the file if it doesn't exist.
 *
 */
public interface ISymptomWriter {

    /**
     *
     * @param symptoms list sorted alphabetically
     */
    public void writeSymptoms(Map<String, Integer> symptoms);

}
