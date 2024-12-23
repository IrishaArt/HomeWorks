package StreamAPI.Сensus;

import java.util.*;
import java.util.stream.Collectors;

import static StreamAPI.Сensus.Education.HIGHER;
import static StreamAPI.Сensus.Sex.*;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        List<String> names = Arrays.asList("Jack", "Connor", "Harry", "George", "Samuel", "John");
        List<String> families = Arrays.asList("Evans", "Young", "Harris", "Wilson", "Davies", "Adamson", "Brown");
        Collection<Person> persons = new ArrayList<>();
        for (int i = 0; i < 10_000_000; i++) {
            persons.add(new Person(
                    names.get(new Random().nextInt(names.size())),
                    families.get(new Random().nextInt(families.size())),
                    new Random().nextInt(100),
                    Sex.values()[new Random().nextInt(Sex.values().length)],
                    Education.values()[new Random().nextInt(Education.values().length)])
            );
        }

        long countChildren = persons.stream()
                .filter(person -> person.getAge()<18 )
                .count();
        System.out.println(countChildren);
        System.out.println("\n");

        List<String> menOfMilitaryAge = persons.stream()
                .filter(person -> person.getAge() >= 18 && person.getAge() <= 27 && person.getSex() == MAN)
                .map(person -> person.getFamily())
                .collect(Collectors.toList());
        System.out.println(menOfMilitaryAge);
        System.out.println("\n");

        List <String > workingPeople = persons.stream()
                .filter(person -> person.getEducation() == HIGHER)
                .filter(person -> person.getSex() == WOMAN && person.getAge()>=18 && person.getAge()<60 ||
                        person.getSex() == MAN && person.getAge()>=18 && person.getAge()<65)
                .sorted(Comparator.comparing(person -> person.getFamily()))
                .map(person -> person.getFamily())
                .collect(Collectors.toList());

        System.out.println(workingPeople);
    }
}
