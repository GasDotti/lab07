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
        return new SortByMonthsDays();
    }

    @Override
    public Comparator<String> sortByOrder() {
        return new SortByMonthsOrder();
    }

    public enum Months {
        
        JANUARY ("january", 31),
        FEBRUARY ("february", 28),
        MARCH ("march", 31),
        APRIL ("april", 30),
        MAY ("may", 31),
        JUNE ("june", 30),
        JULY ("july", 31),
        AUGUST("august", 31),
        SEPTEMBER("september", 30),
        OCTOBER("october", 31),
        NOVEMBER("november", 30),
        DECEMBER("december", 31);

        private final String finalName;
        private final int days;

        private Months(final String finalName, final int days){
            this.finalName = finalName;
            this.days = days;
        }
        public static Months FromString (String name){
            name = name.toLowerCase();

            Months output = null;
            for (Months m : Months.values()){
                if (m.finalName == name || m.finalName.startsWith(name)){
                    if (Objects.isNull(output)){
                        output = m;
                    } else {
                        throw new IllegalArgumentException();
                    }
                }
            }
            if(Objects.nonNull(output)){
                return output;
            }
            throw new IllegalArgumentException();
        }
        @Override
        public String toString() {
            return this.finalName;
        }
    }

    private static class SortByMonthsOrder implements Comparator<String>{
        @Override
        public int compare(String o1, String o2) {
            return Months.FromString(o1).ordinal() - Months.FromString(o2).ordinal();
        }
    }
    private static class SortByMonthsDays implements Comparator<String>{
        @Override
        public int compare(String o1, String o2) {
            return Months.FromString(o1).days - Months.FromString(o2).days;
        }
    }
}