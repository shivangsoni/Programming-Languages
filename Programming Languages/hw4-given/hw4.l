;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;; Your solution goes in this file ;;;
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(defun all-length (l)
 (cond((null l) 0)
 ((listp (car l)) (+ (all-length (car l)) (all-length (cdr l))))
 (t (+ 1 (all-length (cdr l)))))
)
;this len function calculate length of the list.
(defun len (l)
 (cond ((nil l) 0)
 (t (+ 1 (len (cdr l)))))
)


(defun range (l)
 (cons (apply #'min l) (cons (apply #'max  l) nil))
)
    
(defun before_helper (b l)
 (cond 
 ((null l) nil)
 ((equal b (car l)) (cons (car l) nil))
 (t (cons (car l) (before_helper b (cdr l)))))
)

(defun before (a b l)
 (cond 
 ((equal l nil) nil)
 ((equal a (car l)) (before_helper b l))
 (t (before a b (cdr l))))
)


(defun split-if (a b)
 (list (splithelper1 a b) (splithelper2 a b))
)

(defun splithelper1 (a b)
 (cond
  ((equal b nil) nil)
  ((not (funcall a (car b))) (cons (car b) (splithelper1 a (cdr b))))
   (t (splithelper1 a (cdr b)))
 )
)

(defun splithelper2 (a b)
 (cond
  ((equal b nil) nil)
  ((funcall a (car b)) (cons (car b) (splithelper2 a (cdr b))))
  (t (splithelper2 a (cdr b)))
 )
)


(defun group (l n)
 (cond
 ((equal l nil) nil)
 (t  (group_helper2 0 l n ()))
 )
)


(defun group_helper2 (a b c d)
 (cond
   ((equal b nil) (list d))
   ((= a c) (setq a 0) (cons d (group_helper2 a b c nil))) 
   (t (group_helper2 (+ 1 a) (cdr b) c (append d (list (car b)))))
  )
)

;;apply function on list
    (defun mostn (fun l)
     (mostn1 fun l 0)
    )
 
 (defun mostn1 (fun l m)
    (setq m (mostn_helper2 fun l 0))
   (list (mostn_helper1 fun l () m) m)
 )
        
        
(defun mostn_helper1 (fun lst p w)
  (cond 
   ((equal lst nil) nil)
   ((equal (funcall fun (car lst)) w)
    (cons (car lst) (mostn_helper1 fun (cdr lst) p w)))
   (t (mostn_helper1 fun (cdr lst) p w))  
  )
 )
  
 (defun mostn_helper2 (fun lst a)
   (cond
    ((equal nil lst) a)
    ((< a (funcall fun (car lst))) (setq a (funcall fun (car lst))) (mostn_helper2 fun (cdr lst) a))
    (t (mostn_helper2 fun (cdr lst) a))
   )
 )
 ;;Part 2
    (defun match (lst1 lst2)
  (cond
     ((equal lst1 lst2) T)
     ((equal (match? lst1 lst2) T) T)
     ((equal (match! lst1 lst2) T) T)
     (t nil)
   )
  )
  
  (defun match? (lst1 lst2)
   (cond
    ((and (equal lst1 nil) (not (equal lst2 nil))) nil)
    ((and (not (equal lst1 nil)) (equal lst2 nil)) nil)
    ((and (equal lst1 nil) (equal lst2 nil)) T)
    ( (or (equal (car lst1) '?) (equal (car lst2) '?))  (match? (cdr lst1) (cdr lst2)))
    ( (equal (car lst1) (car lst2)) (match? (cdr lst1) (cdr lst2)))
    (t nil)
   )
  )
  
  
  (defun match! (lst1 lst2)
  (cond
    
    ((and (equal lst1 nil) (not (equal lst2 nil))) nil)
    ((and (not (equal lst1 nil)) (equal lst2 nil)) nil)  
    ((and (equal lst1 nil) (equal lst2 nil)) T)
    ((and (equal (car lst1) '?) (not (equal (car lst2) nil))) (match! (cdr lst1) (cdr lst2)))
    ((equal (car lst1) '!)(or (match! (cdr lst1) (cdr lst2)) (match! lst1 (cdr lst2))))
    ((equal (car lst1) (car lst2)) (match! (cdr lst1) (cdr lst2)))
    (t nil)
  )
  )
  
  ;; PART 3:
(defun match-var (lst1 lst2)
  (cond
     ((equal lst1 lst2) T)
     ((equal (match-var? lst1 lst2 ) T) T)
     ((equal (match-var! lst1 lst2 ()) T) T)
     (t nil)
   )
 )

(defun match-var? (lst1 lst2)
   (cond
    ((and (equal lst1 nil) (equal lst2 nil)) T)
    ((and (equal lst1 nil) (not (equal lst2 nil))) nil)
    ((and (not (equal lst1 nil)) (equal lst2 nil)) nil)
    ((equal (car lst1) (car lst2)) (match-var? (cdr lst1) (cdr lst2)))
    ((equal (caar lst1) '?) (set (cadar lst1) (car lst2)) (match-var? (cdr lst1) (cdr lst2)))
    (t nil)
   )
 )
 
  (defun match-var! (lst1 lst2 itm)
   (cond
    ((and (equal lst1 nil) (equal lst2 nil)) T)
    ((and (equal lst1 nil) (not (equal lst2 nil))) nil)
    ((and (not (equal lst1 nil)) (equal lst2 nil)) nil) 
    ((equal (car lst1) (car lst2)) (match-var! (cdr lst1) (cdr lst2) itm))
    ((and (listp (car lst1)) (equal (caar lst1) '?)) (set (cadar lst1) (car lst2)) (match-var! (cdr lst1) (cdr lst2) itm)) 
    ((and (listp (car lst1)) (equal (caar lst1) '!)) 
    (setq (symbol_val io) (append itm (list (car lst2))))
      (
        cond (
        (match-var! (cdr lst1) (cdr lst2) itm) (set (cadar lst1) io)  t)
        (t (match-var! lst1 (cdr lst2) io) )
      )
    ) 
    (t nil)
    )
 )
 