package com.merigasparyan.jmp.Task3;

public class EmployeeFactory {
    public static CommissionedEmployee createCommissioned(String name,
                                                          double commissionRate, double salesAmount, double baseSalary) {
        return new CommissionedEmployee(name, commissionRate, salesAmount, baseSalary);
    }

    public static HourlyEmployee createHourly(String name,
                                              double hourlyRate, int hoursWorked, int overtimeHours, double overtimeRate) {
        return new HourlyEmployee(name, hourlyRate, hoursWorked, overtimeHours, overtimeRate);
    }

    public static SalariedEmployee createSalaried(String name,
                                                  double monthlySalary, double bonus) {
        return new SalariedEmployee(name, monthlySalary, bonus);
    }
}