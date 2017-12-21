

All the parts of working.
Except in part 3 there is 3 test case where one of the variable value is printed extra.Code is working fine.

for example:
testing:  (MATCH-VAR '(A (! U) A (? V) A (! W)) '(A A A A B A A))
value:    T

testing:  (EVAL 'U)
value:    (A A)

testing:  (EVAL 'V)
value:    B

testing:  (EVAL 'W)
value:    (A)


For the above test case U,V values are printed correctly but W value is printed as (A A) same case 
with other 2 test cases too.


This lisp file contain code which only uses recursion.

