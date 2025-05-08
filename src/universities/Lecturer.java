package universities;

public class Lecturer extends Professor {
    private int hoursPerMonth;
    private double hourlyRate;

    public Lecturer(long email, String name, int hoursPerMonth, double hourlyRate) throws LecturaInvalidaException {
        super(email, name);

        if (hoursPerMonth < 0) {
            throw new LecturaInvalidaException("Las horas por mes no pueden ser negativas.");
        }
        if (hourlyRate <= 0) {
            throw new LecturaInvalidaException("La tarifa por hora debe ser mayor a cero.");
        }

        this.hoursPerMonth = hoursPerMonth;
        this.hourlyRate = hourlyRate;
    }

    @Override
    public double calcularSalario() {
        return hoursPerMonth * hourlyRate;
    }

    public void setHoursPerMonth(int hoursPerMonth) throws LecturaInvalidaException {
        if (hoursPerMonth < 0) {
            throw new LecturaInvalidaException("Las horas por mes no pueden ser negativas");
        }
        this.hoursPerMonth = hoursPerMonth;
    }

    public void setHourlyRate(double hourlyRate) throws LecturaInvalidaException {
        if (hourlyRate <= 0) {
            throw new LecturaInvalidaException("La tarifa por hora debe ser mayor a cero");
        }
        this.hourlyRate = hourlyRate;
    }
}