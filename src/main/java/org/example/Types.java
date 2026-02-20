package org.example;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public enum Types {
    // LEAFS
    CRONOS_7023L("Cronos_7023"),
    CRONOS_6021L("Cronos_6021"),

    CRONOS_6001_A("Cronos 6001-A"),
    CRONOS_6003("Cronos 6003"),
    CRONOS_7023("Cronos 7023"),

    CRONOS_6021_NG("Cronos 6021-NG"),
    CRONOS_6001_NG("Cronos 6001-NG"),
    CRONOS_6003_NG("Cronos 6003-NG"),
    CRONOS_6031_NG("Cronos 6031-NG"),
    CRONOS_7021_NG("Cronos 7021-NG"),
    CRONOS_7023_NG("Cronos 7023-NG"),

    ARES_7023("Ares 7023"),
    ARES_7031("Ares 7031"),
    ARES_7021("Ares 7021"),

    ARES_8023_15("Ares 8023 15"),
    ARES_8023_200("Ares 8023 200"),
    ARES_8023_2_5("Ares8023 2,5"),

    // BRANCHES
    CRONOS_L("Cronos L", CRONOS_7023L, CRONOS_6021L),
    CRONOS_OLD("Cronos Old", CRONOS_6001_A, CRONOS_6003, CRONOS_7023),
    CRONOS_NG("Cronos-NG", CRONOS_6001_NG, CRONOS_6003_NG, CRONOS_6021_NG, CRONOS_6031_NG, CRONOS_7021_NG, CRONOS_7023_NG),

    ARES_TB("Ares TB", ARES_7023, ARES_7031, ARES_7021),
    ARES_THS("Ares THS", ARES_8023_15, ARES_8023_200, ARES_8023_2_5),

    // ROOTS
    CRONOS("CRONOS", CRONOS_L, CRONOS_OLD, CRONOS_NG),
    ARES("ARES", ARES_TB, ARES_THS);

    private final String label;
    private final List<Types> children;

    Types(String label) {
        this.label = label;
        this.children = Collections.emptyList();
    }

    Types(String label, Types... children) {
        this.label = label;
        this.children = Arrays.asList(children);
    }

    public String getLabel() {
        return label;
    }

    public List<Types> getChildren() {
        return children;
    }
}
