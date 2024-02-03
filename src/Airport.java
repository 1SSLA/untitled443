import java.util.ArrayList;
import java.util.List;

public class Airport {
    private String name;
    private List<Aircraft> aircraftVehicles;

    public Airport(String name) {
        this.name = name;
        this.aircraftVehicles = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Aircraft> getAircraftVehicles() {
        return aircraftVehicles;
    }

    public void addAircraft(Aircraft aircraft) {
        aircraftVehicles.add(aircraft);
        aircraft.setAirport(this);
    }

    public void removeAircraft(Aircraft aircraft) {
        aircraftVehicles.remove(aircraft);
        aircraft.setAirport(null);
    }

    public Passenger searchPassenger(String airlineName, int seatNo) {
        for (Aircraft aircraft : aircraftVehicles) {
            for (Passenger passenger : aircraft.getPassengers()) {
                if (passenger.getAircraft().getName().equals(airlineName) && passenger.getSeatNo() == seatNo) {
                    return passenger;
                }
            }
        }
        return null;
    }
}