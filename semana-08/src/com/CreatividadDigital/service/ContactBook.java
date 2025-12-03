package com.CreatividadDigital.service;

import com.CreatividadDigital.Modelo.Contact;

import java.util.HashMap;
import java.util.ArrayList;

public class ContactBook {
    private HashMap<String, Contact> contacts = new HashMap<>();

    public void addContact(Contact c) {
        contacts.put(c.getId(), c);
    }

    public Contact getContact(String id) {
        return contacts.get(id);
    }

    public boolean removeContact(String id) {
        return contacts.remove(id) != null;
    }

    public boolean contains(String id) {
        return contacts.containsKey(id);
    }

    public ArrayList<Contact> searchByName(String name) {
        ArrayList<Contact> result = new ArrayList<>();
        for (Contact c : contacts.values()) {
            if (c.getName().equalsIgnoreCase(name)) {
                result.add(c);
            }
        }
        return result;
    }

    public ArrayList<Contact> getAll() {
        return new ArrayList<>(contacts.values());
    }
}