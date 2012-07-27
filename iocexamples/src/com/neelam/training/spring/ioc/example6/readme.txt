Example 6
=========

So now its time to take a small example where we can include some db and use the concepts we
have learnt so far.

The order of injection is:
EmployeeService -> depends on -> EmployeeDAO -> depends on -> DataSource
