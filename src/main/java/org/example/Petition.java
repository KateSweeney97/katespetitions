package org.example;

import java.util.ArrayList;
import java.util.List;

public class Petition {
    private String title;
    private String description;
    private List<Signature> signatures;

    public Petition(String title, String description) {
        this.title = title;
        this.description = description;
        this.signatures = new ArrayList<>();
    }

    // Getters and setters
    public void addSignature(String name, String email) {
        Signature s = new Signature();
        s.name = name;
        s.email = email;
        signatures.add(s);
    }

    private class Signature {
        String name;
        String email;
    }
}

