package com.neelam.training.spring.ioc.example14;

public class Manager extends Employee {
private int bonus;
public Manager(){}

public Manager(int id, String name, String salary,int bonus) {
	super(id, name, salary);
	this.bonus = bonus;
	// TODO Auto-generated constructor stub
}

public int getBonus() {
	return bonus;
}
public void setBonus(int bonus) {
	this.bonus = bonus;
}
public void display(){
	super.display();
	System.out.println("Bonus :" + bonus);
}
}
