package org.example;

import java.util.ArrayList;
import java.sql.Timestamp;
import java.util.List;

public class Petition {
    private String title;
    private String description;
    private List<Signature> signatures;
    private String id;

    public Petition(String title, String description) {
        this.title = title;
        this.description = description;
        this.signatures = new ArrayList<>();
        this.id = String.valueOf(new Timestamp(System.currentTimeMillis()).getTime());
    }

    // Getters and setters
    public String getId() {
        return this.id;
    }

    public String getTitle() {
        return this.title;
    }

    public String getDescription() {
        return this.description;
    }

    public List<Signature> getSignatures() {
        return this.signatures;
    }

    public void addSignature(String name, String email) {
        Signature s = new Signature(name, email);
        signatures.add(s);
    }
}

