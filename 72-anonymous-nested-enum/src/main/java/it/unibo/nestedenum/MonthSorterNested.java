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

        JANUARY ("january"),
        FEBRUARY ("february"),
        MARCH ("march"),
        APRIL ("april"),
        MAY ("may"),
        JUNE ("june"),
        JULY ("july"),
        AUGUST("august"),
        SEPTEMBER("september"),
        OCTOBER("october"),
        NOVEMBER("november"),
        DECEMBER("december");

        private final String finalName;

        private Months(String finalName){
            this.finalName = finalName;
        }
        public Months FromString (String name){
            for (Months m : Months.values()){
                if(m.equals(name)){
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
}
