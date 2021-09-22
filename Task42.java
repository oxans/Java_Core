package HW4;

import java.util.*;

class Task42 {

    public static void main(String[] args) {
        Phonebook phonebook = new Phonebook();

        phonebook.add(2304578, "Ivanov");
        phonebook.add(5678794, "Ivanov");
        phonebook.add(3456783, "Petrov");
        phonebook.add(3456278, "Sidorov");
        phonebook.add(9786053, "Sidorov");
        phonebook.add(6475893, "Sidorov");

        phonebook.get("Ivanov");
        phonebook.get("Petrov");
        phonebook.get("Sidorov");
        phonebook.get("Akulshin");
    }

    static class Phonebook {

        private Map<Integer, String> phonebook;

        Phonebook() {
            phonebook = new HashMap<>();
        }

        public void add(int number, String surname) {
            phonebook.put(number, surname);
        }

        public void get(String surname) {
            if (phonebook.containsValue(surname)) {
                Set<Map.Entry<Integer, String>> set = phonebook.entrySet();
                for (Map.Entry<Integer, String> temp : set) {
                    if (temp.getValue().equals(surname)) {
                        System.out.println(temp.getValue() + " : " + temp.getKey());
                    }
                }
            } else {
                System.out.println("Such a name is not on the list.");
            }
        }

    }
}