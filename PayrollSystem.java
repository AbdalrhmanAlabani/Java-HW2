import java.time.LocalDate;
import java.util.*;

public class PayrollSystem {

    public static void main(String[] args) {

        // 1) إنشاء القائمة
        List<Employee> employees = new ArrayList<>();
        employees.add(new FullTimeEmployee("F01", "Ahmed", 5000, LocalDate.of(2018, 3, 15), 1200));
        employees.add(new FullTimeEmployee("F02", "Sara",  4000, LocalDate.of(2021, 7, 1),   800));
        employees.add(new ContractorEmployee("C01", "Omar", LocalDate.of(2023, 1, 10), 50, 120));
        employees.add(new ContractorEmployee("C02", "Layla", LocalDate.of(2020, 9, 20), 70, 100));
        employees.add(new FullTimeEmployee("F03", "Khaled", 6500, LocalDate.of(2015, 5, 5), 1500));

        // تقييم الأداء لكل موظف (يُمرَّر للدالة دون أي Downcasting)
        Map<String, Double> scores = new HashMap<>();
        scores.put("F01", 4.5);
        scores.put("F02", 3.0);
        scores.put("C01", 4.8);
        scores.put("C02", 3.5);
        scores.put("F03", 5.0);

        // 2) الفرز الطبيعي (Comparable): تنازلي حسب صافي الراتب
        Collections.sort(employees);
        System.out.println("=== الفرز حسب صافي الراتب (تنازلي) ===");
        employees.forEach(System.out::println);

        // 3) الفرز بـ Comparator مخصص: الأقدمية (الأقدم أولاً)
        employees.sort(Comparator.comparing(Employee::getJoinDate));
        System.out.println("\n=== الفرز حسب تاريخ الانضمام (الأقدمية) ===");
        employees.forEach(System.out::println);

        // 4) إجمالي الضرائب والمكافآت (تعددية الأشكال بدون Downcasting)
        double totalTax = 0, totalBonus = 0;
        for (Employee e : employees) {
            double tax = e.calculateTax();
            double bonus = e.calculateBonus(scores.get(e.getId()));
            totalTax += tax;
            totalBonus += bonus;
            System.out.printf("%-8s tax=%8.2f  bonus=%8.2f%n", e.getName(), tax, bonus);
        }
        System.out.printf("%nإجمالي الضرائب  : %.2f%n", totalTax);
        System.out.printf("إجمالي المكافآت : %.2f%n", totalBonus);
    }
}
