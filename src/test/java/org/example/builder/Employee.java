package org.example.builder;

public class Employee {

    private int employeeId;
    private String employeeName;
    private String designation;

    public Employee(EmployeeBuilder builder) {
        this.employeeId = builder.employeeId;
        this.employeeName = builder.employeeName;
        this.designation = builder.designation;
    }


    public static class EmployeeBuilder{
        private int employeeId;
        private String employeeName;
        private String designation;

        public static EmployeeBuilder builder(){
            return new EmployeeBuilder();
        }

        public EmployeeBuilder setEmployeeId(int employeeId) {
            this.employeeId = employeeId;
            return this;
        }

        public EmployeeBuilder setEmployeeName(String employeeName) {
            this.employeeName = employeeName;
            return this;
        }

        public EmployeeBuilder setDesignation(String designation) {
            this.designation = designation;
            return this;
        }

        public Employee build(){
            return new Employee(this);
        }




    }
}
