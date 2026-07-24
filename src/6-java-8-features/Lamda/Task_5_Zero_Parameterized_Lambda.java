import java.time.ZonedDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class Task_5_Zero_Parameterized_Lambda {
    public static void main(String[] args) {
        ZeroParamInterface time_india = ()->{
            ZoneId indiaZone = ZoneId.of("Asia/Kolkata");
            ZonedDateTime indiaTime = ZonedDateTime.now(indiaZone);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm:ss a");

            return "Current Time in India: " + indiaTime.format(formatter);
        };

        System.out.println(time_india.display_time());
    }
}
@FunctionalInterface
interface ZeroParamInterface{
    String display_time();
}
