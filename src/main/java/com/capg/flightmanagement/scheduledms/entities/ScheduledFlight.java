package scheduledms.entities;

import java.util.Objects;

public class ScheduledFlight  {

  private  int availableseats;
   private Flight flight;
   private Schedule schedule;


   public ScheduledFlight() {
       this(0,null,null);
   }


    public ScheduledFlight(int availableseats, Flight flight, Schedule schedule) {
        this.availableseats = availableseats;
        this.flight = flight;
        this.schedule = schedule;
    }



    public int getAvailableseats() {
        return availableseats;
    }

    public void setAvailableseats(int availableseats) {
        this.availableseats = availableseats;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ScheduledFlight)) return false;
        ScheduledFlight that = (ScheduledFlight) o;
        return getAvailableseats() == that.getAvailableseats() &&
                getFlight().equals(that.getFlight()) &&
                getSchedule().equals(that.getSchedule());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAvailableseats(), getFlight(), getSchedule());
    }
}
