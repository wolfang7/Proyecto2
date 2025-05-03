public class Lecturer extends Professor {
    private int hoursPerMonth;
    private double hourlyRate;

    public Lecturer(String email, String name, int hoursPerMonth, double hourlyRate) throws LecturaInvalida {
        super(email, name);

        if (hoursPerMonth < 0) {
            throw new LecturaInvalida("Las horas por mes no pueden ser negativas.");
        }
        if (hourlyRate <= 0) {
            throw new LecturaInvalida("La tarifa por hora debe ser mayor a cero.");
        }

        this.hoursPerMonth = hoursPerMonth;
        this.hourlyRate = hourlyRate;
    }

    @Override
    public double calcularSalario() {
        return hoursPerMonth * hourlyRate;
    }

    public void setHoursPerMonth(int hoursPerMonth) throws LecturaInvalida {
        if (hoursPerMonth < 0) {
            throw new LecturaInvalida("Las horas por mes no pueden ser negativas.");
        }
        this.hoursPerMonth = hoursPerMonth;
    }

    public void setHourlyRate(double hourlyRate) throws LecturaInvalida {
        if (hourlyRate <= 0) {
            throw new LecturaInvalida("La tarifa por hora debe ser mayor a cero.");
        }
        this.hourlyRate = hourlyRate;
    }
}