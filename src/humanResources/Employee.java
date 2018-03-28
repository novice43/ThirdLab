package humanResources;

public abstract class Employee
{
    String firstName;
    String lastName;
    JobTitlesEnum jobTitle;
    int salary;
    static final int DEFAULT_SALARY = 0;

    protected Employee(String firstName, String lastName, JobTitlesEnum jobTitle, Integer salary)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.jobTitle = jobTitle;
        if(salary >= 0) this.salary = salary;
        else throw new IllegalArgumentException();
    }

    protected Employee(String firstName, String lastName)
    {
        this(firstName, lastName, JobTitlesEnum.NONE,  DEFAULT_SALARY);
    }

    String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    JobTitlesEnum getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(JobTitlesEnum jobTitle) {
        this.jobTitle = jobTitle;
    }

    int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }


    boolean compareByName(Employee e)
    {
        return this.firstName.equals(e.firstName) &&
                this.lastName.equals(e.lastName);
    }

    boolean compareByName(String firstName, String secondName)
    {
        return this.firstName.equals(firstName) &&
                this.lastName.equals(secondName);
    }

    public abstract int getBonus();

    public abstract void setBonus(int bonus);

    protected StringBuilder getString()
    {
        //StringBuilder sb = new StringBuilder();
        String line = "";
        if(this.lastName != null && !this.lastName.isEmpty())
            line = String.format("%s", lastName);//sb.append(this.lastName).append(" ");
        if(this.firstName != null && !this.firstName.isEmpty())
            line = String.format("%s %s,", line, firstName);//sb.append(this.firstName).append(", ");
        if(this.jobTitle != null && this.jobTitle != JobTitlesEnum.NONE)
            line = String.format("%s %s,", line, jobTitle);//sb.append(this.jobTitle).append(", ");
        if(this.salary != 0)
            line = String.format("%s %dр.", line, salary);//sb.append(this.salary).append("р.");
        //sb.append("\n");
        return new StringBuilder(line);
    }

    @Override
    public String toString()
    {
        return getString().toString();
    }

    //TODO сделать во всех остальных equals() так же CHECK
    @Override
    public boolean equals(Object obj)
    {
        if(obj instanceof Employee)//Если на вход пришел экземпляр класса Employee
        {
            Employee employee = (Employee)obj;
            return  employee.firstName.equals(this.firstName) &&
                    employee.lastName.equals(this.lastName) &&
                    employee.jobTitle.equals(this.jobTitle) &&
                    employee.salary == this.salary;
        }
        else
            return false;
    }

    @Override
    public int hashCode()
    {

        int hash = this.firstName.hashCode();
        hash ^= this.lastName.hashCode();
        hash ^= this.jobTitle.hashCode();
        hash ^= this.salary;
        return hash;
    }
}