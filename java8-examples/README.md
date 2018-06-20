# Optional
A container object which may or may not contain a non-null value. If a value is present, isPresent() will return true and get() will return the value.

## APIs
### orElse Family
![alt text](../images/orElseFamily.PNG)

## Rules
1. Never, ever, use null for an Option variable or return value.
2. Never use Optional.get() unless you can prove that the Optional is present.
