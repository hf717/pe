(ns pe.x-002)

;Each new term in the Fibonacci sequence is generated by adding the previous two terms. 
;By starting with 1 and 2, the first 10 terms will be:

;1, 2, 3, 5, 8, 13, 21, 34, 55, 89, ...

;By considering the terms in the Fibonacci sequence whose values do not exceed 
;four million, find the sum of the even-valued terms.

(defn fib-step [[a b]]
  [b (+ a b)])

(defn fib-seq []
  (map first (iterate fib-step [0 1])))

(defn fib-sum [x] 
  (reduce
	  +
	  (filter
	    even?
	    (take-while
	      (partial > x)
	      (fib-seq)))))

;to test time efficency execute: (time (fib-sum 4000000))

; ********************************
; slower older version
(reduce + (filter even?  ((fn fib [a b]
                           (cons a (if (< (+ a b) 4000000)
                                     (do (lazy-seq (fib b (+ a b))))
                                     (do (lazy-seq (list b)))))) 0 1)))