
Part 1: All test cases working.
Part 2: All test cases working.
Part 3: 22 test cases working.
Part 4: 8 test cases working.

Able to generate simple C code file and able to perform operations
like print numbers into C file. 

Part 5: Implemented For loop and wrote test cases for the same.
        Cases does not work due to different token passing.But successfully implemented 
        for loop by changing BNF.
        
        
Implemented in code in function "forr()"
Part 5:
   Implementation for loop increments by 2
   E syntax for the for loop
1.)   modified BNF rule.
   for::= '^' assignment;number;block '$'
   
test01.e 
@i
^i=0;10;!i$
C equivalent for the implemented "for" loop

for(x_i=0;x_i<=10;x_i+=2)
{
   block();
}
This for loop will iterate over to every alternate element from 0 to 10.
