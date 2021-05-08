package sarcina;

public class Maistru extends Muncitor{
	private int salary;
	private int SumSalHour = 350;
	private int Ore_lucratoare;
	int n;
	
	public int getTime(int Ore_lucratoare) {
		this.Ore_lucratoare = Ore_lucratoare;
		return Ore_lucratoare;
	}
	
	public int salary(int sal) {
		this.salary = sal;
		return getTime(Ore_lucratoare) * SumSalHour;
	}
}
