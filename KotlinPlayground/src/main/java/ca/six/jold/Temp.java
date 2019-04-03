package ca.six.jold;

import org.reactivestreams.Subscriber;

import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;

import io.reactivex.subjects.BehaviorSubject;
import io.reactivex.subjects.PublishSubject;
import io.reactivex.subjects.ReplaySubject;

class Temp {
    public static void main(String[] args) {
      GregorianCalendar calendar = new GregorianCalendar(TimeZone.getTimeZone("GMT"), new Locale("en", "US", "POSIX"));
      System.out.println(calendar);
    }
}

/*
java.util.GregorianCalendar
  [time=1554300334170,
  areFieldsSet=true,areAllFieldsSet=true,lenient=true,
  zone=sun.util.calendar.ZoneInfo[id="GMT",offset=0,dstSavings=0,useDaylight=false,transitions=0,lastRule=null],
  firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=1,
  YEAR=2019,MONTH=3,WEEK_OF_YEAR=14,WEEK_OF_MONTH=1,DAY_OF_MONTH=3,DAY_OF_YEAR=93,DAY_OF_WEEK=4,DAY_OF_WEEK_IN_MONTH=1,AM_PM=1,
  HOUR=2,HOUR_OF_DAY=14,MINUTE=5,SECOND=34,MILLISECOND=170,ZONE_OFFSET=0,DST_OFFSET=0]

 */