package com.example.fipe.service;

public class LimpaString {
    public String removeSpecialCharacters(String input) {
        String normalizedString = java.text.Normalizer.normalize(input, java.text.Normalizer.Form.NFD);
        return normalizedString.replaceAll("\\p{M}", "");
    }
}
