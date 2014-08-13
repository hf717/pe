(ns pe.x-005)

; 2520 is the smallest number that can be divided by each of the numbers from 1 to 10 
; without any remainder.

; What is the smallest positive number that is evenly divisible by all of the numbers 
; from 1 to 20?

((fn [x]
   (if (= (count (filter #(zero? (mod x %)) (range 1 21))) 20)
     (print x)
     (recur (+ 20 x)))) 1000)