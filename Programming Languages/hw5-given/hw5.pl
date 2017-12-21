/*******************************************/
/**    Your solution goes in this file    **/ 
/*******************************************/

fc_course(B) :-
 course(B, _ ,P),
  P >= 3,
  P =< 4.
  
 prereq_110(B):-
  course(B,I,_),
  check(ecs110,I).
  
    check(X,[X|Tail]):-
        !.           
        
    check(X,[Y|Tail]):-
        check(X,Tail),!.
  
 ecs140a_students(A):-
  student(A,B),
  check(ecs140a,B).
  
%% Find the names of all instructors who teach john’s courses (instructor names).
instructor_names(B) :-
	student(john, CC),
	instructor(B, BI),
	side(CC,BI).


side(L1, [_|T2]) :- side(L1, T2), !.
side([_|T1], L2) :- side(T1, L2), !.
side([P|_], [P|_]) :- !.

students(B):-
instructor(jim,P),
student(B,Q),
side(P,Q).


allprereq([],[]):- !.
allprereq([L|_],O):-
course(L,B,_),
allprereq(B,BB),
append(BB, B, O1),
course(R,B1,_),
allprereq(B1,BB2),
append(BB2, O1, O),!.
allprereq(B,BB):-allprereq([B],BB).


all_length([],0).
all_length([H|T],N):-atomic(H),all_length(T,N1),N is N1+1,!.
all_length([H|T],N):-all_length(H,NN),all_length(T,N1), N is N1+NN,!.

occurrences([],_,0).
occurrences([X|Y],X,N):- occurrences(Y,X,W),N is W + 1.
occurrences([X|Y],Z,N):- occurrences(Y,Z,N),X\=Z.

equal_a_b(L):-
occurrences(L,a,C1),
occurrences(L,b,C2),
C1=C2.


swap_prefix_suffix(Y,XYZ,ZYX) :-
   append(X,YZ,XYZ),
   append(Y,Z,YZ),
   append(Z,Y,ZY),
   append(ZY,X,ZYX).

palin(L) :- reverse(L,L).


good([1|Tail]):-
concat(M,N,Tail),
good(M),
good(N).
good([0]).

concat([], List, List).
concat([Head|Tail], List, [Head|Rest]) :-
    append(Tail, List, Rest).

        %%%%%%%%%%%%%%%%%%%%%%%%%%%%  PART 3    %%%%%%%%%%%%%%%%%%%%%%%%%%%

%% Move only once if starting point is A and ending point B i.e. in one step we can 
%% go from A to B 
%%State D must be a safe state
path(B,D, Listt) :-
	safe(B),
	Q = arc(_, B, D),%% This Q is an object taken to the opposite bank of the river
	Q,
	\+ check(Q, Listt),
	updatedlist([Q|Listt]),
	!.
%%Move to intermediate state and continue movement	
%%State D must be a safe state
 path(B,D, Listt) :-
	safe(B),
	Q = arc(_, B, Middle),
	\+ check(Q, Listt),
	Q,
	path(Middle, D, [Q|Listt])
	.

%%State of the puzzle 1st blank is man,wolf,goat and cabbage respectively 
state(_,_,_,_).

%%now opposite side
opposite(left,right).
opposite(right,left).

%%unsafe is wolf and goat on same side and farmer on opposite side
unsafe(state(X,Y,Y,_)):-opposite(X,Y).
unsafe(state(X,_,Y,Y)):-opposite(X,Y).

%%safe state when m wolf and goat on same side

safe(state(X,_,X,_)).
safe(state(F,X,Y,X)):-opposite(X,Y).

%%take from one bank to the next

take(X, A, B) :- opposite(A, B).

%%move only is safe state is reached after move
arc(take(goat,A,B),state(A,Wolf,A,Cabbage),state(B,Wolf,B,Cabbage)):-opposite(A,B).

arc(take(wolf,A,B),state(A,A,Goat,Cabbage),state(B,B,Goat,Cabbage)):-opposite(A,B).

arc(take(cabbage,A,B),state(A,Wolf,Goat,A),state(B,Wolf,Goat,B)):-opposite(A,B).


arc(take(none,A,B),state(A,Wolf,Goat,Cabbage),state(B,Wolf,Goat,Cabbage)):-opposite(A,B).

%%Print the updated list every time a move is performed and print the list
updatedlist([]).
updatedlist([arc(take(O, A, B), _, _)|T]) :-
	updatedlist(T),
	write('take('), write(O), write(','),write(A),write(','), write(B),write(')'),nl.

%%now if farmer goes from 1 state to another and if that state is same 
%%that too will be considered
arc(take(farmer,A,B),state(A,Wolf,Goat,Cabbage),state(B,Wolf,Goat,Cabbage)):-opposite(A,B).

solve :- path(state(left, left, left, left),
state(left, left, left, right), []), !.

%%move only when safe state and do not move opposite state.