package Lesson_9;

import java.util.*;

public class PhoneBook {
    private Map<String, List<String>> contactLog = new HashMap<>();

    public void add(String lastName, String phoneNumber) {
        if (contactLog.containsKey(lastName)) {
            List<String> phoneNumbers = contactLog.get(lastName);
            if (!phoneNumbers.contains(phoneNumber)) {
                phoneNumbers.add(phoneNumber);
            }
        } else {
            List<String> phoneNumbers = new ArrayList<>();
            phoneNumbers.add(phoneNumber);
            contactLog.put(lastName, phoneNumbers);
        }
    }

    public List<String> get(String lastName) {
        return contactLog.getOrDefault(lastName, Collections.emptyList());
    }
}
