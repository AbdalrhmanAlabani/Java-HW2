import java.time.LocalDate;

public class ContractorEmployee extends Employee {

    private final int hourlyRate;
    private final int hoursWorked;

    public ContractorEmployee(String id, String name, LocalDate joinDate,
                              int hourlyRate, int hoursWorked) {
        super(id, name, 0, joinDate);   // الراتب الأساسي = 0
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }

    @Override
    public double calculateNetSalary() {
        return (double) hourlyRate * hoursWorked;
    }

    /** مكافأة مقطوعة 500$ فقط إذا كان التقييم أعلى من 4.0 */
    @Override
    public double calculateBonus(double performanceScore) {
        return performanceScore > 4.0 ? 500.0 : 0.0;
    }
}
