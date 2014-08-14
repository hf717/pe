(ns pe.x-007)

; By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 
; 6th prime is 13.

; What is the 10 001st prime number?

; solution below is very slow

((fn [x acc]
    (if (= (count acc)  10001)
        (print (apply max acc))
        (if (= (count (filter #(= (mod x %) 0) acc)) 0)
            (recur (+ 2 x) (cons x acc))
            (recur (+ 2 x) acc)))) 3 '(2))