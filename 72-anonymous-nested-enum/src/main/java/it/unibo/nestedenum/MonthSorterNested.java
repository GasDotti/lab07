package it.unibo.nestedenum;

import java.util.Comparator;
import java.util.Locale;
import java.util.Objects;

/**
 * Implementation of {@link MonthSorter}.
 */
public final class MonthSorterNested implements MonthSorter {

    @Override
    public Comparator<String> sortByDays() {
        return null;
    }

    @Override
    public Comparator<String> sortByOrder() {
        return null;
    }

    public enum Months {
        
        JANUARY (1, "january", 31),
        FEBRUARY (2, "february", 28),
        MARCH (3, "march", 31),
        APRIL (4, "april", 30),
        MAY (5, "may", 31),
        JUNE (6, "june", 30),
        JULY (7, "july", 31),
        AUGUST(8, "august", 31),
        SEPTEMBER(9, "september", 30),
        OCTOBER(10, "october", 31),
        NOVEMBER(11, "november", 30),
        DECEMBER(12, "december", 31);

        private final int id;
        private final String finalName;
        private final int days;

        private Months(final int id, final String finalName, final int days){
            this.id = id;
            this.finalName = finalName;
            this.days = days;
        }
        public static Months FromString (String name){
            for (Months m : Months.values()){
                if(m.finalName.equals(name)){
                    return m;
                }
            }
            return null;
        }
        @Override
        public String toString() {
            return this.finalName;
        }
    }

    private static class SortByMonthsOrder implements Comparator<String>{
        @Override
        public int compare(String o1, String o2) {
            return Months.FromString(o1).id - Months.FromString(o2).id;
        }
    }
    private static class SortByMonthsDays implements Comparator<String>{
        @Override
        public int compare(String o1, String o2) {
            return Months.FromString(o1).days - Months.FromString(o2).days;
        }
    }
}
