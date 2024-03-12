package ru.job4j.stream;

import java.util.List;
import java.util.stream.Collectors;

public class Profiles {

    public static List<Address> collect(List<Profile> profiles) {
        return profiles.stream()
                .map(profile -> profile.getAddress())
                .collect(Collectors.toList());
    }

    public static List<Address> collectSortWithoutDuplicate(List<Profile> profiles) {
        List<Address> result = collect(profiles);
        return result.stream()
                .sorted(new AdressComparator())
                .distinct()
                .collect(Collectors.toList());
    }
}