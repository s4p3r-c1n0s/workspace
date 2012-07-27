Example 4
=========

In this example we discuss when the existing ways of DI doesn't works correctly.
The scenario is simple, if we have the source bean as singleton and the target
bean as non-singleton then we cannot use setter or constructor injection since only
one instance of source is will be created.

We will discuss a programmatic solution in this example. We will use the context object
to manually get an instance of target bean as and when we need it whereby giving us the 
solution we need.
