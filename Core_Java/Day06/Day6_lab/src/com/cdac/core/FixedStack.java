package com.cdac.core;

public class FixedStack implements Stack {
	private Customer[] customers;
	private int top;
	

	public FixedStack() {
		customers = new Customer[STACK_SIZE];
		top = -1;
	}

	@Override
	public void push(Customer c) {
		if(top==STACK_SIZE-1) {
			System.out.println("stack Overflow..!");
		}else {
			customers[++top]=c;
		}
		
	}

	@Override
	public Customer pop() {
		if (top == -1) {
            System.out.println("Stack Underflow!");
            return null;
        } else {
            return customers[top--];

	}

}
}
	