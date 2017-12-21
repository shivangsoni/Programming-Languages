%Write a prolog code to find out sum of the list elements%





divided(F):-
 F is 5/2.

sumto([],0):-!.
sumto([H|T],N):-
  sumto(T,N1),N is H+N1.
%Solution 2 for the above using cuts%
gcd1(u,0,u):-!.
gcd1(u,v,N):- 
M is mod(u,v),
 gcd1(v,M,N).
 
 sort([],[]).
 sort([X]).
 sort([X,Y|L]):-X>Y,sort([Y|L]),!.
 
 lastele(X,[X]).
 lastele(X,[_|Y]):-lastele(X,Y).
 
 
 
 nextto(X,Y,[X,Y|T]).
 nextto(X,Y,[_|T]):-nextto(X,Y,T).
 
 
 
 efface(X,[X|Z],Z).
 efface(X,[H|Y],[H|Z]):-efface(X,Y,Z).
 
 deleteall(X,[],[]).
 deleteall(X,[X|T],L):-deleteall(X,T,L).
 deleteall(X,[H|T],[H|L]):-deleteall(X,T,L).
 
 %Insertion sort%
 %Bubble sort%
 %LAST DO Que on graphs%
 sublist([],[H|T]).
 sublist([X|Y],[X|T]):-sublist(Y,T).
 sublist([X|Y],[P|T]):-sublist([X|Y],T).
 
 
 
 removeduplicate([],[]).
 removeduplicate([H|T],L):-member(H,T),!,removeduplicate(T,L).
 removeduplicate([H|T],[H|L]):-removeduplicate(T,L).
 
 
 subset([],Y).
 subset([X|T],Y):-member(X,Y),subset(T,Y).
 
 
 unionset([],[],[]).
 unionset([],Y,Y).
 unionset([H|T],Y,L):-member(H,Y),!,unionset(T,Y,L).
 unionset([H|T],Y,[H|L]):-unionset(T,Y,L).
 
 
 intersection([],Y,[]).
 intersection([H|T],Y,[H|L]):-member(H,Y),!,intersection(T,Y,L).
 intersection([H|T],Y,L):-intersection(T,Y,L).
 
 %How is this written dry run%
 permutation([],[]).
 permutation(L,[H|T]):-
 append(V,[H|U],L),
 append(V,U,W),
 permutation(W,T).
 
 
 %Insertion sort%
 %Bubble sort%
 gcd(X,0,X).
 gcd(X,Y,R):-M is mod(X,Y),
 gcd(Y,M,R).
 
 
 rmdup([],[]).
 rmdup([H|T],L):-member(H,T),!,rmdup(T,L).
 rmdup([H|T],[H|L]):-rmdup(T,L).
 
 rpn([],0).
 rpn([A],A).
 rpn([H1,H2,'+'|T],L):-H is H1+H2,rpn([H|T],L).
 rpn([H1,H2,'-'|T],L):-H is H1-H2,rpn([H|T],L).
 rpn([H1,H2,'*'|T],L):-H is H1*H2,rpn([H|T],L).
 rpn([H1,H2,'/'|T],L):-H is H1/H2,rpn([H|T],L).




 perm([],[]).
 perm([H|T],S):-perm(T,R),insert(H,R,S).
 
 insert(H,L,[H|L]).
 insert(H,[H1|L1],[H1|R1]):-insert(H,L1,R1).
 
 
 %Level order%
 %quicksort %
 
 
 insertionsort([],[]).
 insertionsort([H|T],L):-
 insertionsort(T,Temp),insort(H,Temp,L).
 
 insort(X,[H|T],[H|L]):-
  X>H, !, insort(X,T,L).
 insort(X,T,[X|T]).
 
 

%Bubble sort%
 bubblesort(List,SortedList):-
 swapsort(List,L),!,bubblesort(L,SortedList).
  
 bubblesort(A,A). 
 
 swapsort([X,Y|L],[Y,X|L]):-X>Y.
 swapsort([Z|L1],[Z|L2]):-swapsort(L1,L2).
 
 
 
 
 %inorder traversal of given binary tree%
 inorder(nil,[]).
 inorder(tree(X,Left,Right),L):-
 inorder(Left,L1),
 inorder(Right,L2),
 append(L1,[X|L2],L).
 
 
 preorder(nil,[]).
 preorder(tree(X,Left,Right),L):-
 preorder(Left,L1),
 preorder(Right,L2),
 append([X|L1],[L2],L).
 
 
 postorder(nil,[]).
 postorder(tree(X,Left,Right),L):-
 postorder(Left,L1),
 postorder(Right,L2),
 append([L1],[L2,X],L).
 
 
 quicksort([H|L],S):-split(H,L,L1,L2),
 quicksort(L1,S1),
 quicksort(L2,S2),
 append(S1,[H|S2],S).
  quicksort([],[]).
 
 split(X,[Y|N],M,[Y|K]):-X<Y,split(X,N,M,K).
 split(X,[Y|N],[Y|M],K):-X>=Y,split(X,N,M,K).
 split(_,[],[],[]).
 
 
 
 merge([],[],[]).
 merge([],Y,Y).
 merge(X,[],X).
 merge([H1|T1],[H2|T2],[H1|L]):-
 H1<H2,!,merge(T1,[H2|T2],L).
 merge([H1|T1],[H2|T2],[H2|L]):-
 H2<H1,!,merge([H1|T1],T2,L).
 